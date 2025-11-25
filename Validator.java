package bank.utils;

/**
 * Validator
 * ---------
 * Small reusable helpers for validating user input.
 */
public class Validator {

    public static boolean isNonEmpty(String s) {
        return s != null && !s.trim().isEmpty();
    }

    public static boolean isPositiveAmount(String s) {
        try {
            double v = Double.parseDouble(s);
            return v > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
