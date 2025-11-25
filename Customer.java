package bank.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Customer
 */
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String address;
    private List<Account> accounts = new ArrayList<>();
    private List<BankCard> bankCards = new ArrayList<>();

    public Customer(String customerId, String firstName, String lastName, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }

    public void addAccount(Account a) { accounts.add(a); }
    public List<Account> getAccounts() { return accounts; }

    public Account findAccount(String accNo) {
        for (Account a : accounts) if (a.getAccountNumber().equals(accNo)) return a;
        return null;
    }

    // Bank card management
    public void addBankCard(BankCard card) { bankCards.add(card); }
    public List<BankCard> getBankCards() { return bankCards; }
    public BankCard findCard(String cardNumber) {
        for (BankCard c : bankCards) 
            if (c.getCardNumber().equals(cardNumber)) return c;
        return null;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + customerId + ")";
    }
}
