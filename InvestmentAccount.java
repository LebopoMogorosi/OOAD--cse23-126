package bank.model;
/**
 * 
 * 
 */
public class InvestmentAccount extends Account {
    public InvestmentAccount(String accountNumber, String branch, double openingBalance) {
        super(accountNumber, branch, Math.max(openingBalance, 500.00));
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;
        if (amount <= balance) {
            balance -= amount;
            transcastions.add(new Transaction("Withdraw", amount, balance));
        } else{
            System.out.println("Insufficient funds, cannot transact Investment Account.");
        }
    }
    @Override
    public void applyInterest() {
        double interest = balance * 0.05; //interest charged at 5% monthly for Investments
        balance += interest;
        transcastions.add(new Transaction("Interest", interest, balance));
    }
}