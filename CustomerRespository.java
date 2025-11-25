package bank.utils;

import bank.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * CustomerRepository
 * ------------------
 * In-memory data store for demo purposes.
 * Later replace with database DAO in Part B.4.
 */
public class CustomerRepository {

    private static Map<String, Customer> store = new HashMap<>();

    static {
        // Seed demo customer
        Customer c = new Customer("C001", "Lebopo", "Mogorosi", "Gaborone");

        // Accounts
        c.addAccount(new SavingsAccount("SA100", 1000, "Main"));
        c.addAccount(new InvestmentAccount("IA100", 1000, "Main"));
        c.addAccount(new ChequeAccount("CA100", 500, "Main", "TechCorp"));

        // Cards (linked to accounts)
        BankCard card1 = new BankCard("VISA", "SA100");
        BankCard card2 = new BankCard("MASTERCARD", "CA100");

        // Known PINs for testing
        card1.setPin("1234");
        card2.setPin("4321");

        c.addBankCard(card1);
        c.addBankCard(card2);

        // Login credentials (demo)
        store.put("lebopo", c);
    }

    public static Customer findByUsername(String username) {
        return store.get(username.toLowerCase());
    }

    public static void save(String username, Customer c) {
        store.put(username.toLowerCase(), c);
    }
}
