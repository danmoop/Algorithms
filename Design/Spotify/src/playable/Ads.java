package playable;

public class Ads extends Playable {
    private String company;
    private String link;

    public Ads(String title, String lyrics, int duration, String company, String link) {
        super(title, lyrics, duration);
        this.company = company;
        this.link = link;
    }

    public Ads() {
        super();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
