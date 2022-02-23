package user;

import playable.Ads;
import playable.Playable;
import playable.Song;

import java.util.List;

public class Player {
    private List<Song> queuedSongs;
    private List<Song> originalQueue;
    private Playable activeSong;
    private User user;
    private int volume;
    private boolean isShuffled;
    private boolean isRepeat;
    private boolean isPaused;
    private boolean areLyricsShown;
    private boolean isAdsShown;

    private int index;

    // Album
    public Player(List<Song> queuedSongs, User user, int volume) {
        this.user = user;
        this.queuedSongs = queuedSongs;
        this.originalQueue = queuedSongs;
        this.activeSong = null;
        this.volume = volume;
        this.isShuffled = false;
        this.isRepeat = false;
        this.isPaused = false;
        this.areLyricsShown = false;
        this.index = 0;
        this.isAdsShown = user.getAccountType() == AccountType.FREE;
    }

    // Single song
    public Player(User user, int volume) {
        this(user.getLikedTracks(), user, volume);
    }

    public void playSong(Song song) {
        this.activeSong = song;
        this.index = this.queuedSongs.indexOf(song);
    }

    public void playNextSong() {
        if (user.getAccountType() == AccountType.FREE) {
            activeSong = new Ads();
            return;
        }

        if (index + 1 >= queuedSongs.size()) return;
        activeSong = queuedSongs.get(++index);
    }

    public void playPrevSong() {
        if (index - 1 < 0) return;

        if (user.getAccountType() == AccountType.FREE) {
            activeSong = new Ads();
            return;
        }

        activeSong = queuedSongs.get(--index);
    }

    public void pause() {
        if (activeSong instanceof Ads) return;
        this.isPaused = !this.isPaused;
    }

    public void repeat() {
        if (activeSong instanceof Ads) return;
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

    public Playable getActiveSong() {
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
        if (activeSong instanceof Ads) return;

        if (shuffled) {
            shuffleSongs();
        } else {
            queuedSongs = originalQueue;
        }

        isShuffled = shuffled;
    }

    private void shuffleSongs() {
        for (int i = 0; i < queuedSongs.size(); i++) {
            int randomIndex = (int) Math.floor(Math.random() * queuedSongs.size());

            Song temp = queuedSongs.get(randomIndex);
            queuedSongs.set(randomIndex, queuedSongs.get(i));
            queuedSongs.set(i, temp);
        }
    }

    public boolean isRepeat() {
        return isRepeat;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean isAreLyricsShown() {
        return areLyricsShown;
    }

    public boolean isAdsShown() {
        return isAdsShown;
    }
}