package bank;

/**
 * 
 * 
 */
public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, String branch, double openingBalance) {
        super(accountNumber, branch, openingBalance);
    }

    @Override
    public void withdraw(double amount) {
        
        //withdrawals are not allowed in this account

        System.out.println("Withdrawals are restricted on Savings Account.");
    }
    
    @Override
    public void applyInterest() {
        double interest = balance * 0.0005; //interest charged at 0.05% monthly for Savings
        balance += interest;
        transcastions.add(new Transaction("Interest", interest, balance));
    }
}