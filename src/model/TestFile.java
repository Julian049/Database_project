package model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestFile {


    private static final Logger LOGGER = Logger.getLogger(TestFile.class.getName());
    private static final String CSV_INPUT_PATH = "src/resources/spotify_songs.csv";
    private static final String SQL_OUTPUT_PATH = "src/resources/spotify_songs.sql";
    private static final String MONTH_DAY_SUFFIX = "-01";
    private static final String YEAR_SUFFIX = "-01-01";
    private static final int FULL_DATE_LENGTH = 10;
    private static final int YEAR_MONTH_LENGTH = 7;
    private static final int YEAR_LENGTH = 4;
    private List<TrackV2> tracks;

    public void processSpotifyData() {
        try {
            readCsvData();
            generateSqlFile();
            LOGGER.info("Procesamiento completado exitosamente");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error durante el procesamiento", e);
            throw new RuntimeException("Fallo en el procesamiento de datos de Spotify", e);
        }
    }

    public void readCsvData() throws IOException {
        Path csvPath = Paths.get(CSV_INPUT_PATH);

        if (!Files.exists(csvPath)) {
            throw new FileNotFoundException("Archivo CSV no encontrado: " + CSV_INPUT_PATH);
        }

        try (FileReader fileReader = new FileReader(csvPath.toFile())) {
            CsvToBean<TrackV2> csvToBean = new CsvToBeanBuilder<TrackV2>(fileReader)
                    .withType(TrackV2.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            tracks = csvToBean.parse();
            LOGGER.info("Se leyeron " + tracks.size() + " tracks del archivo CSV");
        }
    }

    public void generateSqlFile() throws IOException {
        Path outputPath = Paths.get(SQL_OUTPUT_PATH);

        Files.createDirectories(outputPath.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write("-- Archivo SQL generado automáticamente para datos de Spotify\n");
            writer.write("-- Total de tracks: " + tracks.size() + "\n\n");

            for (TrackV2 track : tracks) {
                writeTrackSqlStatements(writer, track);
            }

            LOGGER.info("Archivo SQL generado: " + SQL_OUTPUT_PATH);
        }
    }

    public void writeTrackSqlStatements(BufferedWriter writer, TrackV2 track) throws IOException {
        String trackName = sanitizeString(track.getTrackName());
        String artistName = sanitizeString(track.getTrackArtist());
        String albumName = sanitizeString(track.getTrackAlbumName());
        String playlistName = sanitizeString(track.getPlaylistName());
        String releaseDate = formatReleaseDate(track.getTrackAlbumReleaseDate());
        double loudness = normalizeLoudness(track.getLoudness());
        boolean mode = track.getMode() == 1;

        writer.write(buildArtistInsert(artistName));
        writer.write(buildAlbumInsert(track.getTrackAlbumId(), albumName, releaseDate));
        writer.write(buildTrackInsert(track, trackName, artistName, loudness, mode));
        writer.write(buildPlaylistInsert(track.getPlaylistId(), playlistName,
                track.getPlaylistGenre(), track.getPlaylistSubgenre()));
        writer.write(buildPlaylistTrackInsert(track.getTrackId(), track.getPlaylistId()));
        writer.write("\n");
    }

    public String buildArtistInsert(String artistName) {
        return String.format(
                "INSERT INTO ARTISTS (artist_name) VALUES ('%s') ON CONFLICT (artist_name) DO NOTHING;\n",
                artistName
        );
    }

    public String buildAlbumInsert(String albumId, String albumName, String releaseDate) {
        return String.format(
                "INSERT INTO ALBUMS (album_id, album_name, release_date) VALUES ('%s', '%s', DATE '%s') ON CONFLICT (album_id) DO NOTHING;\n",
                albumId, albumName, releaseDate
        );
    }

    public String buildTrackInsert(TrackV2 track, String trackName, String artistName,
                                    double loudness, boolean mode) {
        return String.format(
                """
                INSERT INTO TRACKS (
                    track_id, track_name, track_popularity, duration_ms, danceability, energy,
                    track_key, loudness, track_mode, speechiness, acousticness, instrumentalness,
                    liveness, valence, tempo, artist_id, album_id
                ) VALUES (
                    '%s', '%s', %d, %d, %.6f, %.6f,
                    %d, %.6f, %s, %.6f, %.6f, %.6f,
                    %.6f, %.6f, %.6f, (SELECT GET_ARTIST_ID('%s')), '%s'
                ) ON CONFLICT (track_id) DO NOTHING;
                """,
                track.getTrackId(), trackName, track.getTrackPopularity(), track.getDurationMs(),
                track.getDanceability(), track.getEnergy(), track.getKey(), loudness, mode,
                track.getSpeechiness(), track.getAcousticness(), track.getInstrumentalness(),
                track.getLiveness(), track.getValence(), track.getTempo(), artistName, track.getTrackAlbumId()
        );
    }

    public String buildPlaylistInsert(String playlistId, String playlistName,
                                       String genre, String subgenre) {
        return String.format(
                "INSERT INTO PLAYLISTS (playlist_id, playlist_name, genre, subgenre) VALUES ('%s', '%s', '%s', '%s') ON CONFLICT (playlist_id) DO NOTHING;\n",
                playlistId, playlistName, genre, subgenre
        );
    }

    public String buildPlaylistTrackInsert(String trackId, String playlistId) {
        return String.format(
                "INSERT INTO PLAYLIST_TRACKS (track_id, playlist_id) VALUES ('%s', '%s') ON CONFLICT (track_id, playlist_id) DO NOTHING;\n",
                trackId, playlistId
        );
    }

    public String sanitizeString(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("'", "''");
    }

    public String formatReleaseDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            return "1900-01-01";
        }

        String trimmedDate = date.trim();

        return switch (trimmedDate.length()) {
            case YEAR_LENGTH -> trimmedDate + YEAR_SUFFIX;         
            case YEAR_MONTH_LENGTH -> trimmedDate + MONTH_DAY_SUFFIX;
            case FULL_DATE_LENGTH -> trimmedDate;
            default -> {
                LOGGER.warning("Formato de fecha inesperado: " + date);
                yield "1900-01-01";
            }
        };
    }

    public double normalizeLoudness(double loudness) {
        return loudness > 0 ? -loudness : loudness;
    }

    @Deprecated
    public void processLinesManually() {
        LOGGER.warning("Método deprecado. Use processSpotifyData() en su lugar.");

        try {
            List<String> lines = Files.readAllLines(Paths.get(CSV_INPUT_PATH));

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",", 2);
                if (parts.length >= 2) {
                    String id = parts[0].trim();
                    String name = parts[1].split(",")[0].trim();
                    LOGGER.info(String.format("ID: %s, Name: %s", id, name));
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error procesando líneas manualmente", e);
        }
    }

    public List<TrackV2> getTracks() {
        return tracks;
    }

    public int getTrackCount() {
        return tracks != null ? tracks.size() : 0;
    }
}
