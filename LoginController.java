package bank.controller;

import bank.model.Customer;
import bank.utils.CustomerRepository;

/**
 * LoginController
 * ----------------
 * Authenticates a user and stores the current logged-in customer.
 * In this demo, username only is checked (no password rules yet).
 */
public class LoginController {

    private Customer currentCustomer;

    /**
     * Authenticate user.
     * For now:
     *  - Uses in-memory CustomerRepository
     *  - Accepts any non-empty password
     */
    public boolean authenticate(String username, String password) {
        if (username == null || username.isBlank())
            return false;

        Customer c = CustomerRepository.findByUsername(username);
        if (c != null) {
            currentCustomer = c;
            return true;
        }

        return false;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }
}
