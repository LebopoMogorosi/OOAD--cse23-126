package bank;

//

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected String accountNumber;
    protected String branch;
    protected double balance;
    protected List<Transaction> transcastions = new ArrayList<>();

    //
 public Account() {}
 
 public Account(String accountNumber, String branch, double balance) {
    this.accountNumber = accountNumber;
    this.branch = branch;
    this.balance = balance;
 }

 //
 public String getAccountNumber() { return accountNumber; }
 public String getBranch() { return branch; }
 public double getBalance() { return balance; }
 public void setBranch(String branch) { this.branch = branch; }

 /** */
 public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        transcastions.add(new Transaction("Deposit", amount, balance));
    }
 }
 /**The Abstract withdraw method will force subclasses toimplement their own rules */
 public abstract void withdraw(double amount);

 /**Enforces interest bearing accounts to override */
 public void applyInterest() {
    // default = no interest
 }

 public List<Transaction> getTransactions() { return transcastions; }
 
 @Override
 public String toString() {
    return accountNumber + " | Balance: " + balance + " | Branch: " + branch;
 }
}