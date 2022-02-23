package playable;

public class Episode extends Playable {
    private String author;
    private String description;
    private boolean isPIPEnabled;

    public Episode(String title, String lyrics, int duration, String author, String description) {
        super(title, lyrics, duration);
        this.author = author;
        this.description = description;
        this.isPIPEnabled = false;
    }

    public void enablePictureInPicture() {
        this.isPIPEnabled = !this.isPIPEnabled;
    }

    public void fastForward() {
        int newProgress = getProgress() + 15;
        if (newProgress <= getDuration()) {
            setProgress(newProgress);
        }
    }

    public void skipBack() {
        int newProgress = getProgress() - 15;
        if (newProgress >= 0) {
            setProgress(newProgress);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPIPEnabled() {
        return isPIPEnabled;
    }
}
