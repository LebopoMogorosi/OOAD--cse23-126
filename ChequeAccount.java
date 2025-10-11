package bank;
/**
 * 
 */
public class ChequeAccount extends Account {

    private String employer;

    public ChequeAccountt(String accountNumber, String branch, double openingBalance, String employer) {
        super(accountNumber, branch, openingBalance);
        this.employer = employer;
    }

    public String getEmployer() { return employer;}
    public void setEmployer(String employer) { this.employer = employer; }

    @Override
     public void withdraw(double amount) {
        if (amount <= 0) return;
        if (amount <= balance) {
            balance -= amount;
            transcastions.add(new Transaction("Withdraw", amount, balance));
        } else{
            System.out.println("Insufficient funds in the Cheque Account.");
        }
    }
}