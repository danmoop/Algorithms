package bank;

import transaction.Transaction;
import transaction.TransactionStatus;

public class Bank {
    public boolean isValidAccount(Account account) {
        return false;
    }

    public boolean isValidPin(Account account, int pin) {
        return false;
    }

    public boolean hasSufficientFunds(Account account) {
        return false;
    }

    public TransactionStatus processTransaction(Transaction t) {
        return TransactionStatus.SUCCESS;
    }
}