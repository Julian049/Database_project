package model;

public class Track {

    private String track_id;
    private String track_name;
    private String track_popularity;
    private int duration_ms;
    private double danceability;
    private double energy;
    private double track_key;
    private double loudness;
    private boolean track_mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private String artist_id;
    private String album_id;

    public Track(String track_id, String track_name, String track_popularity, int duration_ms, double danceability, double energy, double track_key, double loudness, boolean track_mode, double speechiness, double acousticness, double instrumentalness, double liveness, double valence, double tempo, String artist_id, String album_id) {
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

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
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

    public double getTrack_key() {
        return track_key;
    }

    public void setTrack_key(double track_key) {
        this.track_key = track_key;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public boolean isTrack_mode() {
        return track_mode;
    }

    public void setTrack_mode(boolean track_mode) {
        this.track_mode = track_mode;
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
}