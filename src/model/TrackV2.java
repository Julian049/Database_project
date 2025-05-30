package model;

import com.opencsv.bean.CsvBindByName;

public class TrackV2 {

    @CsvBindByName(column = "track_id")
    private String trackId;

    @CsvBindByName(column = "track_name")
    private String trackName;

    @CsvBindByName(column = "track_artist")
    private String trackArtist;

    @CsvBindByName(column = "track_popularity")
    private int trackPopularity;

    @CsvBindByName(column = "track_album_id")
    private String trackAlbumId;

    @CsvBindByName(column = "track_album_name")
    private String trackAlbumName;

    @CsvBindByName(column = "track_album_release_date")
    private String trackAlbumReleaseDate;

    @CsvBindByName(column = "playlist_name")
    private String playlistName;

    @CsvBindByName(column = "playlist_id")
    private String playlistId;

    @CsvBindByName(column = "playlist_genre")
    private String playlistGenre;

    @CsvBindByName(column = "playlist_subgenre")
    private String playlistSubgenre;

    @CsvBindByName(column = "danceability")
    private double danceability;

    @CsvBindByName(column = "energy")
    private double energy;

    @CsvBindByName(column = "key")
    private int key;

    @CsvBindByName(column = "loudness")
    private double loudness;

    @CsvBindByName(column = "mode")
    private int mode;

    @CsvBindByName(column = "speechiness")
    private double speechiness;

    @CsvBindByName(column = "acousticness")
    private double acousticness;

    @CsvBindByName(column = "instrumentalness")
    private double instrumentalness;

    @CsvBindByName(column = "liveness")
    private double liveness;

    @CsvBindByName(column = "valence")
    private double valence;

    @CsvBindByName(column = "tempo")
    private double tempo;

    @CsvBindByName(column = "duration_ms")
    private long durationMs;

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(String trackArtist) {
        this.trackArtist = trackArtist;
    }

    public int getTrackPopularity() {
        return trackPopularity;
    }

    public void setTrackPopularity(int trackPopularity) {
        this.trackPopularity = trackPopularity;
    }

    public String getTrackAlbumId() {
        return trackAlbumId;
    }

    public void setTrackAlbumId(String trackAlbumId) {
        this.trackAlbumId = trackAlbumId;
    }

    public String getTrackAlbumName() {
        return trackAlbumName;
    }

    public void setTrackAlbumName(String trackAlbumName) {
        this.trackAlbumName = trackAlbumName;
    }

    public String getTrackAlbumReleaseDate() {
        return trackAlbumReleaseDate;
    }

    public void setTrackAlbumReleaseDate(String trackAlbumReleaseDate) {
        this.trackAlbumReleaseDate = trackAlbumReleaseDate;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistGenre() {
        return playlistGenre;
    }

    public void setPlaylistGenre(String playlistGenre) {
        this.playlistGenre = playlistGenre;
    }

    public String getPlaylistSubgenre() {
        return playlistSubgenre;
    }

    public void setPlaylistSubgenre(String playlistSubgenre) {
        this.playlistSubgenre = playlistSubgenre;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(long durationMs) {
        this.durationMs = durationMs;
    }

    @Override
    public String toString() {
        return "TrackV2{" +
                "trackId='" + trackId + '\'' +
                ", trackName='" + trackName + '\'' +
                ", trackArtist='" + trackArtist + '\'' +
                ", trackPopularity=" + trackPopularity +
                ", trackAlbumId='" + trackAlbumId + '\'' +
                ", trackAlbumName='" + trackAlbumName + '\'' +
                ", trackAlbumReleaseDate='" + trackAlbumReleaseDate + '\'' +
                ", playlistName='" + playlistName + '\'' +
                ", playlistId='" + playlistId + '\'' +
                ", playlistGenre='" + playlistGenre + '\'' +
                ", playlistSubgenre='" + playlistSubgenre + '\'' +
                ", danceability=" + danceability +
                ", energy=" + energy +
                ", key=" + key +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", speechiness=" + speechiness +
                ", acousticness=" + acousticness +
                ", instrumentalness=" + instrumentalness +
                ", liveness=" + liveness +
                ", valence=" + valence +
                ", tempo=" + tempo +
                ", durationMs=" + durationMs +
                '}';
    }
}


