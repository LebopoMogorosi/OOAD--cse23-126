package bank;
/**
 * 
 */
import java.time.LocalDateTime;

public class Transaction {
    private static int counter = 1;
    private String transcastionId;
    private String type;
    private double amount;
    private LocalDateTime date;
    private double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        this.transcastionId = "TX" + (counter++);
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.balanceAfter = balanceAfter;
    }

    public String getTransactionId() { return transcastionId; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public LocalDateTime getDate() { return date; }
    public double getBalanceAfter() { return balanceAfter; }

    @Override
    public String toString() {
        return transcastionId + " | " + type + " | " + amount + " | " + date + " | Balance after: " + balanceAfter;
    }
}