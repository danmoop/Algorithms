package search;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String title;
    private List<Artist> artists;
    private List<Playlist> playlists;
    private List<Album> albums;

    public Category(String title, List<Artist> artists, List<Playlist> playlists, List<Album> albums) {
        this.title = title;
        this.artists = artists;
        this.playlists = playlists;
        this.albums = albums;
    }

    public Category(String title) {
        this.title = title;
        this.artists = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}