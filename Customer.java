package bank;
/**
 * 
 * 
 */
import java.util.ArrayList;
import java.util.List;

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

    //Encapsulation
    public String getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }

    /**Adding an account to this customer */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**Retrieval of all accounts */
    public List<Account> getAccounts() { return accounts, }

    /**Finding account by acccount number */
    public Account findAccount(String accNo) {
        for (Account a : accounts)
         if (a.getAccountNumber().equals(accNo)) return a;
        return null;
    }

    /**Linking a Bank Card (for the GUI/Database use) */
    public void addBankCard(BankCard card) {
        bankCards.add(card);
    }

    @Override
    public String toString() {
        return "Customer: " + firstName + " " + lastName + " (" + customerId + ")";
    }
}