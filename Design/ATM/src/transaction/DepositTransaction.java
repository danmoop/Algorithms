package transaction;

import java.util.Date;

public class DepositTransaction extends Transaction {
    private int amount;

    DepositTransaction(Date date, int amount) {
        super(date);
        this.amount = amount;
    }
}