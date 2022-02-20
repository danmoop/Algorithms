import java.util.List;

public class Player {
    private List<Song> queuedSongs;
    private Song activeSong;
    private int volume;
    private boolean isShuffled;
    private boolean isRepeat;
    private boolean isPaused;
    private boolean areLyricsShown;

    private int index;

    public Player(List<Song> queuedSongs, Song activeSong, int volume) {
        this.queuedSongs = queuedSongs;
        this.activeSong = activeSong;
        this.volume = volume;
        this.isShuffled = false;
        this.isRepeat = false;
        this.isPaused = false;
        this.areLyricsShown = false;

        this.index = queuedSongs.indexOf(activeSong);
    }

    public void playNextSong() {
        if (index + 1 >= queuedSongs.size()) return;
        activeSong = queuedSongs.get(++index);
    }

    public void playPrevSong() {
        if (index - 1 < 0) return;
        activeSong = queuedSongs.get(--index);
    }

    public void pause() {
        this.isPaused = !this.isPaused;
    }

    public void repeat() {
        this.isRepeat = !this.isRepeat;
    }

    public void showLyrics() {
        this.areLyricsShown = !this.areLyricsShown;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Song> getQueuedSongs() {
        return queuedSongs;
    }

    public void setQueuedSongs(List<Song> queuedSongs) {
        this.queuedSongs = queuedSongs;
    }

    public Song getActiveSong() {
        return activeSong;
    }

    public void setActiveSong(Song activeSong) {
        this.activeSong = activeSong;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isShuffled() {
        return isShuffled;
    }

    public void setShuffled(boolean shuffled) {
        isShuffled = shuffled;
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public void setRepeat(boolean repeat) {
        isRepeat = repeat;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public boolean isAreLyricsShown() {
        return areLyricsShown;
    }

    public void setAreLyricsShown(boolean areLyricsShown) {
        this.areLyricsShown = areLyricsShown;
    }
}