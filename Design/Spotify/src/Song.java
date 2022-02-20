import java.util.List;

public class Song {
    private String title;
    private Artist artist;
    private int duration;
    private int year;
    private Album album;
    private String lyrics;
    private String image;
    private String genre;

    public Song(String title, Artist artist, int duration, int year, Album album, String lyrics, String image, String genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.year = year;
        this.album = album;
        this.lyrics = lyrics;
        this.image = image;
        this.genre = genre;
    }

    public List<Song> showSimilar() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}