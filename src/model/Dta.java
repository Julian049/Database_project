package model;

public class Dta {
    private String track_id;
    private String track_name;
    private String track_artist;
    private String track_popularity;
    private String track_album_id;
    private String track_album_name;
    private String track_album_release_date;
    private String playlist_name;
    private String playlist_id;
    private String playlist_genre;
    private String playlist_subgenre;
    private String danceability;
    private String energy;
    private String key;
    private String loudness;
    private String mode;
    private String speechiness;
    private String acousticness;
    private String instrumentalness;
    private String liveness;
    private String valence;
    private String tempo;
    private String duration_ms;

    public Dta(String track_id, String track_name, String track_artist, String track_popularity, String track_album_id, String track_album_name, String track_album_release_date, String playlist_name, String playlist_id, String playlist_genre, String playlist_subgenre, String danceability, String energy, String key, String loudness, String mode, String speechiness, String acousticness, String instrumentalness, String liveness, String valence, String tempo, String duration_ms) {
        this.track_id = track_id;
        this.track_name = track_name;
        this.track_artist = track_artist;
        this.track_popularity = track_popularity;
        this.track_album_id = track_album_id;
        this.track_album_name = track_album_name;
        this.track_album_release_date = track_album_release_date;
        this.playlist_name = playlist_name;
        this.playlist_id = playlist_id;
        this.playlist_genre = playlist_genre;
        this.playlist_subgenre = playlist_subgenre;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.duration_ms = duration_ms;
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

    public String getTrack_artist() {
        return track_artist;
    }

    public void setTrack_artist(String track_artist) {
        this.track_artist = track_artist;
    }

    public String getTrack_popularity() {
        return track_popularity;
    }

    public void setTrack_popularity(String track_popularity) {
        this.track_popularity = track_popularity;
    }

    public String getTrack_album_id() {
        return track_album_id;
    }

    public void setTrack_album_id(String track_album_id) {
        this.track_album_id = track_album_id;
    }

    public String getTrack_album_name() {
        return track_album_name;
    }

    public void setTrack_album_name(String track_album_name) {
        this.track_album_name = track_album_name;
    }

    public String getTrack_album_release_date() {
        return track_album_release_date;
    }

    public void setTrack_album_release_date(String track_album_release_date) {
        this.track_album_release_date = track_album_release_date;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(String playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_genre() {
        return playlist_genre;
    }

    public void setPlaylist_genre(String playlist_genre) {
        this.playlist_genre = playlist_genre;
    }

    public String getPlaylist_subgenre() {
        return playlist_subgenre;
    }

    public void setPlaylist_subgenre(String playlist_subgenre) {
        this.playlist_subgenre = playlist_subgenre;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLoudness() {
        return loudness;
    }

    public void setLoudness(String loudness) {
        this.loudness = loudness;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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

    public String getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(String duration_ms) {
        this.duration_ms = duration_ms;
    }

    @Override
    public String toString() {
        return "Dta{" +
                "track_id='" + track_id + '\'' +
                ", track_name='" + track_name + '\'' +
                ", track_artist='" + track_artist + '\'' +
                ", track_popularity='" + track_popularity + '\'' +
                ", track_album_id='" + track_album_id + '\'' +
                ", track_album_name='" + track_album_name + '\'' +
                ", track_album_release_date='" + track_album_release_date + '\'' +
                ", playlist_name='" + playlist_name + '\'' +
                ", playlist_id='" + playlist_id + '\'' +
                ", playlist_genre='" + playlist_genre + '\'' +
                ", playlist_subgenre='" + playlist_subgenre + '\'' +
                ", danceability='" + danceability + '\'' +
                ", energy='" + energy + '\'' +
                ", key='" + key + '\'' +
                ", loudness='" + loudness + '\'' +
                ", mode='" + mode + '\'' +
                ", speechiness='" + speechiness + '\'' +
                ", acousticness='" + acousticness + '\'' +
                ", instrumentalness='" + instrumentalness + '\'' +
                ", liveness='" + liveness + '\'' +
                ", valence='" + valence + '\'' +
                ", tempo='" + tempo + '\'' +
                ", duration_ms='" + duration_ms + '\'' +
                '}';
    }
}
