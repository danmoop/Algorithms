package atm;

public class CashDispenser {
    private int cashAvailable;

    public CashDispenser(int cashAvailable) {
        this.cashAvailable = cashAvailable;
    }

    public void dispenseCash(int amount) {

    }

    public boolean canDispenseAmount(int amount) {
        return this.cashAvailable >= amount;
    }
}
