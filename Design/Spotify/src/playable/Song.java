package playable;

import search.Album;
import search.Artist;

import java.util.List;

public class Song extends Playable {
    private Artist artist;
    private int year;
    private Album album;
    private String image;
    private String genre;

    public Song(String title, String lyrics, int duration, Artist artist, int year, Album album, String image, String genre) {
        super(title, lyrics, duration);
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.image = image;
        this.genre = genre;
    }

    public List<Song> showSimilar() {
        return null;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}