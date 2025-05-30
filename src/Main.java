import model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
//    public static void main(String[] args) {
//        ConnectionPostgres con = new ConnectionPostgres();
//        con.connect();
//        con.executeQuery("select * from artists");
//    }
    private ArrayList<Artist> artists;
    private ArrayList<Dta> songs;
    private ArrayList<Album> albums;
    private ArrayList<Playlist> playlists;
    private ArrayList<Track> tracks;

    public void loadData() {
        songs = new ArrayList<>();
        Path ruta = Path.of("src/resources/spotify_songs.csv");
        try (var lineas = Files.lines(ruta).skip(1)) {
            lineas.forEach(linea -> {
                String[] columnas = linea.split(",");
                Dta data = new Dta(columnas[0], columnas[1], columnas[columnas.length-21], columnas[columnas.length-20], columnas[columnas.length-19], columnas[columnas.length-18], columnas[columnas.length-17], columnas[columnas.length-16],columnas[columnas.length-15],columnas[columnas.length-14], columnas[columnas.length-13], columnas[columnas.length-12],columnas[columnas.length-11],columnas[columnas.length-10], columnas[columnas.length-9],columnas[columnas.length-8],columnas[columnas.length-7],columnas[columnas.length-6],columnas[columnas.length-5], columnas[columnas.length-4], columnas[columnas.length-3],columnas[columnas.length-2], columnas[columnas.length-1]);
                songs.add(data);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addArtists() {
        artists = new ArrayList<>();
        Set<String> nombresYaAgregados = new HashSet<>();
        int i = 0;

        for (Dta song : songs) {
            String nombreArtista = song.getTrack_artist().trim();

            if (!nombresYaAgregados.contains(nombreArtista)) {
                Artist nuevoArtista = new Artist("AR" + i, nombreArtista);
                artists.add(nuevoArtista);
                nombresYaAgregados.add(nombreArtista);
                i++;
            }
        }
    }

    public void addAlbums() {
        albums = new ArrayList<Album>();
        Set<String> albumYaAgregado = new HashSet<>();

        for (Dta song : songs) {
            String id_album = song.getTrack_album_id().trim();
            if (!albumYaAgregado.contains(id_album)) {
//                LocalDate release = LocalDate.parse(song.getTrack_album_release_date());
                Album newAlbum = new Album(id_album, song.getTrack_album_name(), song.getTrack_album_release_date());
                albums.add(newAlbum);
                albumYaAgregado.add(id_album);
            }
        }
    }

    public void addPlaylists() {
        playlists = new ArrayList<>();
        Set<String> playlistYaAgregado = new HashSet<>();

        for (Dta song : songs) {
            String id_playlist = song.getPlaylist_id().trim();
            if (!playlistYaAgregado.contains(id_playlist)) {
                Playlist newPlaylist = new Playlist(song.getPlaylist_subgenre(), song.getPlaylist_genre(), song.getPlaylist_name(), id_playlist);
                playlists.add(newPlaylist);
                playlistYaAgregado.add(id_playlist);
            }
        }
    }

    public void addTracks() {
        tracks = new ArrayList<>();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.loadData();
        main.addArtists();
        main.addAlbums();
        main.addPlaylists();

//        ArrayList<Artist> artists = main.artists();
//        for (Artist artist : artists) {
//            System.out.println(artist.toString());
//        }

//        ArrayList<Album> albums = main.albums;
//        for (Album album : albums) {
//            System.out.println(album.toString());
//        }

        ArrayList<Playlist> playlists = main.playlists;
        for (Playlist playlist : playlists) {
            System.out.println(playlist.toString());
        }
    }

}