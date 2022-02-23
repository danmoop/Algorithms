package playable;

public class Playable {

    private String title;
    private String lyrics;
    private int duration;
    private int progress;

    public Playable(String title, String lyrics, int duration) {
        this.title = title;
        this.lyrics = lyrics;
        this.duration = duration;
        this.progress = 0;
    }

    public Playable() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
}