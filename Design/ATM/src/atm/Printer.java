package atm;

public class Printer {
    private int paper;

    public Printer(int paper) {
        this.paper = paper;
    }

    public boolean hasPaperAvailable() {
        return this.paper > 0;
    }

    public void dispenseCheck() {
        paper--;
    }
}
