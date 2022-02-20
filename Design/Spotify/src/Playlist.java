import java.util.List;

public class Playlist {
    private String title;
    private Artist artist;
    private User author;
    private List<Song> songs;
    private int duration;

    public Playlist(String title, Artist artist, User author, List<Song> songs, int duration) {
        this.title = title;
        this.artist = artist;
        this.author = author;
        this.songs = songs;
        this.duration = duration;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}