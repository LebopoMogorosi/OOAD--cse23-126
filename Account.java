package bank.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Account - base for all account types.
 */
public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String branch;
    protected List<Transaction> transactions = new ArrayList<>();

    public Account() {}

    public Account(String accountNumber, double balance, String branch) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.branch = branch;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getBranch() { return branch; }
    public List<Transaction> getTransactions() { return transactions; }

    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
        transactions.add(new Transaction("Deposit", amount, balance));
    }

    public abstract void withdraw(double amount);

    // Overridable for interest accounts
    public void applyInterest() {}

    @Override
    public String toString() {
        return accountNumber + " | Balance: "
                + String.format("%.2f", balance)
                + " | Branch: "
                + branch;
    }
}
