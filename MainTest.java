package bank; 
/**
 * 
 * 
 */
public class MainTest {
    public static void main(String[] args) {
        //creating a new customer
        Create c1 = new  Customer();

        //Create different account types
        SavingsAccount sa = new SavingsAccount();
        InvestmentAccount ia = new InvestmentAccount();
        ChequeAccount ca = new ChequeAccount();

        //Link accounts to customer
        c1.addAccount(sa);
        c1.addAccount(ia);
        c1.addAccount(ca);

        System.out.println("\n---- Initial Balances ----");
        for (Account a : c1.getAccounts())
        System.out.println(a);

        //Perform depositts and withdrawals
        sa.deposit();
        ia.deposit();
        ia.withdraw();
        ca.withdraw();

        //Apply interest where applicable
        sa.applyInterest();
        ia.applyInterest();

        System.out.println("\n--- After Transaction ----");
        for (Account a : c1.getAccounts()) {
            System.out.println(a);
            //Showing transaction history
            for (Transaction t : a.getTransactions())
            System.out.println("      " + t);
        }

        //Demonstration of BankCard placeholder
        BankCard card = new BankCard("BC001");
        c1.addBankCard(card);
        System.out.println("\n--- Bank Card Linked ----");
        System.out.println(card;)
    }
}