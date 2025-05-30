package model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class TestFile {
    private ArrayList<String> lines = new ArrayList<>();
    private List<TrackV2> list;

    public void readFile() {
        try (FileReader fr = new FileReader("src/resources/spotify_songs1.csv")) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void splitFile() {
        String tempLine = "";
        for (int i = 1; i < lines.size(); i++) {
            tempLine = lines.get(i);
            String id = lines.get(i).substring(0, lines.get(i).indexOf(","));
            System.out.println("ID: " + id);
            tempLine = tempLine.substring(tempLine.indexOf(",") + 1);
            String name = tempLine.substring(0, tempLine.indexOf(","));
            System.out.println("Name: " + name + "\n");
        }
    }

    public void readCSV() {
        try (FileReader fr = new FileReader("src/resources/spotify_songs.csv")) {
            CsvToBean<TrackV2> csvToBean = new CsvToBeanBuilder<TrackV2>(fr).withType(TrackV2.class).build();

            list = csvToBean.parse();

//            for (TrackV2 bean : list) {
//                System.out.println(bean.toString());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSQLQuery() {
//        TrackV2 track = new TrackV2();
//
//        track.setTrackId("123456");
//        track.setTrackName("Song Example");
//        track.setTrackArtist("Artist Name");
//        track.setTrackPopularity(85);
//        track.setTrackAlbumId("ALB123");
//        track.setTrackAlbumName("Album Example");
//        track.setTrackAlbumReleaseDate("2023-01-01");
//        track.setPlaylistName("Top Hits");
//        track.setPlaylistId("PL123");
//        track.setPlaylistGenre("Pop");
//        track.setPlaylistSubgenre("Dance Pop");
//        track.setDanceability(0.75);
//        track.setEnergy(0.8);
//        track.setKey(5);
//        track.setLoudness(-5.2);
//        track.setMode(1);
//        track.setSpeechiness(0.05);
//        track.setAcousticness(0.1);
//        track.setInstrumentalness(0.0);
//        track.setLiveness(0.12);
//        track.setValence(0.65);
//        track.setTempo(120.5);
//        track.setDurationMs(210000);
        try {
            File file = new File("src/resources/spotify_songs1.sql");

            FileWriter fileWriter = new FileWriter(file, false);
            for (TrackV2 track : list) {
//                fileWriter.write("INSERT INTO ARTISTS (artist_name) " +
//                        "VALUES ('" + track.getTrackArtist() + "');\n");
//                fileWriter.write("INSERT INTO ALBUMS (album_id, album_name, release_date) " +
//                        "VALUES ('" + track.getTrackAlbumId() + "', '" + track.getTrackAlbumName() + "'"+ track.getTrackAlbumReleaseDate() +"');");

                boolean mode = false;
                if (track.getMode() == 1) {
                    mode = true;
                }

                String trackName = replaceQuotation(track.getTrackName());
                String artistName = replaceQuotation(track.getTrackArtist());
                String albumName = replaceQuotation(track.getTrackAlbumName());
                String playlistName = replaceQuotation(track.getPlaylistName());
                String date = track.getTrackAlbumReleaseDate();
                double loudness = track.getLoudness();

                if (loudness>0){
                    loudness = -loudness;
                }

                if (date.length() < 10) {
                    if (date.length() == 7) {
                        date = date + "-01";
                    } else if (date.length() == 4) {
                        date = date + "-01-01";
                    }
                }

                fileWriter.write("INSERT INTO ARTISTS (artist_name) " +
                        "VALUES ('" + artistName + "') ON CONFLICT (artist_name) DO NOTHING;\n");
                fileWriter.write("INSERT INTO ALBUMS (album_id, album_name, release_date) " +
                        "VALUES ('" + track.getTrackAlbumId() + "', '" + albumName + "' , DATE '" + date + "') ON CONFLICT (album_id) DO NOTHING;\n");
                fileWriter.write("INSERT INTO TRACKS (\n" +
                        "    track_id, track_name, track_popularity, duration_ms, danceability, energy, \n" +
                        "    track_key, loudness, track_mode, speechiness, acousticness, instrumentalness, \n" +
                        "    liveness, valence, tempo, artist_id, album_id\n" +
                        ")\n" +
                        "VALUES (\n" +
                        "    '" + track.getTrackId() + "', '" + trackName + "', " + track.getTrackPopularity() + ", " + track.getDurationMs() + ", " + track.getDanceability() + ", " + track.getEnergy() + ",\n" +
                        "    " + track.getKey() + ", " + loudness + ", " + mode + ", " + track.getSpeechiness() + ", " + track.getAcousticness() + ", " + track.getInstrumentalness() + ",\n" +
                        "    " + track.getLiveness() + ", " + track.getValence() + ", " + track.getTempo() + ", (SELECT GET_ARTIST_ID('" + artistName + "')), '" + track.getTrackAlbumId() + "'\n" +
                        ") ON CONFLICT (track_id) DO NOTHING;\n");
                fileWriter.write("INSERT INTO PLAYLISTS (playlist_id, playlist_name, genre, subgenre) " +
                        "VALUES ('" + track.getPlaylistId() + "', '" + playlistName + "', '" + track.getPlaylistGenre() + "', '" + track.getPlaylistSubgenre() + "') ON CONFLICT (playlist_id) DO NOTHING;\n");
                fileWriter.write("INSERT INTO PLAYLIST_TRACKS (track_id, playlist_id) " +
                        "VALUES ('" + track.getTrackId() + "', '" + track.getPlaylistId() + "') ON CONFLICT (track_id, playlist_id) DO NOTHING;\n \n \n");

            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

    private String replaceQuotation(String line) {
        String output = line;
        if (line.contains("'")) {
            output = output.replace("'", "''");
        }
        return output;
    }
}
