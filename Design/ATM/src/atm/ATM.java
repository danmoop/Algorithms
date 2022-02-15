package atm;

public class ATM {
    private int id;
    private Address address;
    private Keypad keypad;
    private Screen screen;
    private CashDispenser cashDispenser;
    private Printer printer;

    public ATM(int id, Address address) {
        this.id = id;
        this.address = address;
    }
}