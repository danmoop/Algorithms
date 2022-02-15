package bank;

public class Account {
    private double balance;
    private String ownerName;
    private int ownerAge;

    public Account(double balance, String ownerName, int ownerAge) {
        this.balance = balance;
        this.ownerName = ownerName;
        this.ownerAge = ownerAge;
    }
}