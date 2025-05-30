package model;

import java.time.LocalDate;

public class Album {

    private String album_id;
    private String album_name;
    private String release_date;

    public Album(String album_id, String album_name, String release_date) {
        this.album_id = album_id;
        this.album_name = album_name;
        this.release_date = release_date;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Album{" +
                "album_id='" + album_id + '\'' +
                ", album_name='" + album_name + '\'' +
                ", release_date=" + release_date +
                '}';
    }
}
