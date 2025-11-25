package bank.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * BankCard
 * -----------------
 * - 16-digit card number (generated)
 * - 3-digit CVV
 * - expiry (MM/yy)
 * - PIN (4 digits) stored in-memory (plain for demo; use hashing for production)
 * - blocked flag
 * - linked accountNumber (optional)
 *
 * Methods:
 *  - validatePin(String)
 *  - block(), unblock()
 *  - getMaskedNumber()
 */
public class BankCard {
    private String cardNumber;
    private String cvv;
    private String expiry; // MM/yy
    private String pin; // in real apps, store a hash
    private boolean blocked;
    private String linkedAccountNumber; // card may be linked to a primary account
    private String cardType; //"VISA", "MASTERCARD"

    private static Random rng = new Random();

    // Constructor: generates card details
    public BankCard(String cardType, String linkedAccountNumber) {
        this.cardType = cardType == null ? "VISA" : cardType;
        this.cardNumber = generateCardNumber();
        this.cvv = generateCVV();
        this.expiry = generateExpiry(3); // 3 years from now
        this.pin = generatePin(); // randomly generated; can be reset later
        this.blocked = false;
        this.linkedAccountNumber = linkedAccountNumber;
    }

    // Basic getters
    public String getCardNumber() { return cardNumber; }
    public String getCvv() { return cvv; }
    public String getExpiry() { return expiry; }
    public boolean isBlocked() { return blocked; }
    public String getLinkedAccountNumber() { return linkedAccountNumber; }
    public String getCardType() { return cardType; }

    // Set or change PIN (in real world require auth)
    public void setPin(String newPin) {
        if (newPin != null && newPin.matches("\\d{4}")) this.pin = newPin;
    }

    // Validate a PIN input (returns true/false)
    public boolean validatePin(String attempt) {
        if (blocked) return false;
        return attempt != null && attempt.equals(pin);
    }

    // Block/unblock
    public void block() { this.blocked = true; }
    public void unblock() { this.blocked = false; }

    // Returns masked card number e.g. "XXXX-XXXX-XXXX-1234"
    public String getMaskedNumber() {
        if (cardNumber == null || cardNumber.length() < 4) return "****";
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        return "XXXX-XXXX-XXXX-" + last4;
    }

    // Utilities to generate card/cvv/pin/expiry
    private String generateCardNumber() {
        StringBuilder sb = new StringBuilder();
        // Start with 4 to hint Visa-like (optional)
        for (int i = 0; i < 16; i++) {
            sb.append(rng.nextInt(10));
        }
        return sb.toString();
    }

    private String generateCVV() {
        int v = rng.nextInt(900) + 100;
        return String.valueOf(v);
    }

    private String generatePin() {
        int v = rng.nextInt(9000) + 1000;
        return String.valueOf(v);
    }

    private String generateExpiry(int yearsFromNow) {
        LocalDate now = LocalDate.now().plusYears(yearsFromNow);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yy");
        return now.format(fmt);
    }

    @Override
    public String toString() {
        return cardType + " " + getMaskedNumber() + " (Exp: " + expiry + ") " + (blocked ? "[BLOCKED]" : "");
    }
}
