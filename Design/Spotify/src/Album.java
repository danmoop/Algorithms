import java.util.List;

public class Album {
    private String title;
    private Artist artist;
    private int releaseYear;
    private int duration;
    private List<Song> songs;
    private String recordLabel;

    public Album(String title, Artist artist, int releaseYear, int duration, List<Song> songs, String recordLabel) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.songs = songs;
        this.recordLabel = recordLabel;
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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }
}