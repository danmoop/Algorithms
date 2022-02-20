import java.util.List;

public class Artist {
    private String name;
    private int monthlyListeners;
    private List<Song> popularSongs;
    private List<Album> albums;
    private String bio;

    public Artist(String name, int monthlyListeners, List<Song> popularSongs, List<Album> albums, String bio) {
        this.name = name;
        this.monthlyListeners = monthlyListeners;
        this.popularSongs = popularSongs;
        this.albums = albums;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthlyListeners() {
        return monthlyListeners;
    }

    public void setMonthlyListeners(int monthlyListeners) {
        this.monthlyListeners = monthlyListeners;
    }

    public List<Song> getPopularSongs() {
        return popularSongs;
    }

    public void setPopularSongs(List<Song> popularSongs) {
        this.popularSongs = popularSongs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}