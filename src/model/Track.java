package model;

public class Track {

    private String track_id;
    private String track_name;
    private String track_popularity;
    private String duration_ms;
    private String danceability;
    private String energy;
    private String track_key;
    private String loudness;
    private String track_mode;
    private String speechiness;
    private String acousticness;
    private String instrumentalness;
    private String liveness;
    private String valence;
    private String tempo;
    private String artist_id;
    private String album_id;

    public Track(String track_id, String track_name, String track_popularity, String duration_ms, String danceability, String energy, String track_key, String loudness, String track_mode, String speechiness, String acousticness, String instrumentalness, String liveness, String valence, String tempo, String artist_id, String album_id) {
        this.track_id = track_id;
        this.track_name = track_name;
        this.track_popularity = track_popularity;
        this.duration_ms = duration_ms;
        this.danceability = danceability;
        this.energy = energy;
        this.track_key = track_key;
        this.loudness = loudness;
        this.track_mode = track_mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.artist_id = artist_id;
        this.album_id = album_id;
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }

    public String getTrack_popularity() {
        return track_popularity;
    }

    public void setTrack_popularity(String track_popularity) {
        this.track_popularity = track_popularity;
    }

    public String getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(String duration_ms) {
        this.duration_ms = duration_ms;
    }

    public String getDanceability() {
        return danceability;
    }

    public void setDanceability(String danceability) {
        this.danceability = danceability;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getTrack_key() {
        return track_key;
    }

    public void setTrack_key(String track_key) {
        this.track_key = track_key;
    }

    public String getLoudness() {
        return loudness;
    }

    public void setLoudness(String loudness) {
        this.loudness = loudness;
    }

    public String getTrack_mode() {
        return track_mode;
    }

    public void setTrack_mode(String track_mode) {
        this.track_mode = track_mode;
    }

    public String getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(String speechiness) {
        this.speechiness = speechiness;
    }

    public String getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(String acousticness) {
        this.acousticness = acousticness;
    }

    public String getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(String instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public String getLiveness() {
        return liveness;
    }

    public void setLiveness(String liveness) {
        this.liveness = liveness;
    }

    public String getValence() {
        return valence;
    }

    public void setValence(String valence) {
        this.valence = valence;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    @Override
    public String toString() {
        return "Track{" +
                "track_id='" + track_id + '\'' +
                ", track_name='" + track_name + '\'' +
                ", track_popularity='" + track_popularity + '\'' +
                ", duration_ms='" + duration_ms + '\'' +
                ", danceability='" + danceability + '\'' +
                ", energy='" + energy + '\'' +
                ", track_key='" + track_key + '\'' +
                ", loudness='" + loudness + '\'' +
                ", track_mode='" + track_mode + '\'' +
                ", speechiness='" + speechiness + '\'' +
                ", acousticness='" + acousticness + '\'' +
                ", instrumentalness='" + instrumentalness + '\'' +
                ", liveness='" + liveness + '\'' +
                ", valence='" + valence + '\'' +
                ", tempo='" + tempo + '\'' +
                ", artist_id='" + artist_id + '\'' +
                ", album_id='" + album_id + '\'' +
                '}';
    }
}