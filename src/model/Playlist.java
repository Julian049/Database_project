package model;

public class Playlist {

    private String playlist_id;
    private String playlist_name;
    private String genre;
    private String subgenre;

    public Playlist(String subgenre, String genre, String playlist_name, String playlist_id) {
        this.subgenre = subgenre;
        this.genre = genre;
        this.playlist_name = playlist_name;
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(String playlist_id) {
        this.playlist_id = playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlist_id='" + playlist_id + '\'' +
                ", playlist_name='" + playlist_name + '\'' +
                ", genre='" + genre + '\'' +
                ", subgenre='" + subgenre + '\'' +
                '}';
    }
}
