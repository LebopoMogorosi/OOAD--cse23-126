package bank;
/**
 * 
 * 
 */
public class BankCard {
    private String cardNumber;
    private boolean active;

    public BankCard(String cardNumber) {
        this.cardNumber = cardNumber;
        this.active = true;
    }

    public String toString() {
        return "Card: " + cardNumber + " | Active: " + active;
    }
}