package bank.controller;

import bank.model.Account;

/**
 * AccountController
 * -----------------
 * Acts as the logic layer between the GUI and an Account.
 */
public class AccountController {

    Account account;

    public AccountController(Account account) {
        this.account = account;
    }

    public double deposit(double amount) {
        if (amount > 0)
            account.deposit(amount);
        return account.getBalance();
    }

    public double withdraw(double amount) {
        if (amount > 0)
            account.withdraw(amount);
        return account.getBalance();
    }

    public double getBalance() {
        return account.getBalance();
    }

    public Account getAccount() {
        return account;
    }
}
