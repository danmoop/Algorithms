package transaction;

import java.util.Date;

public class WithdrawTransaction extends Transaction {
    private double amount;

    WithdrawTransaction(Date date, double amount) {
        super(date);
        this.amount = amount;
    }
}
