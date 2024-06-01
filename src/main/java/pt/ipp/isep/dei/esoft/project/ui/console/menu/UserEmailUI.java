package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Scanner;

/**
 * The UserEmailUI class provides an interface for the user to input their personal email address.
 */
public class UserEmailUI implements Runnable {
    private final Scanner scanner;
    private String email;

    /**
     * Constructs a new UserEmailUI object.
     */
    public UserEmailUI() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the user email input interface.
     */
    public void run() {
        System.out.println("\n\n--- PERSONAL EMAIL INPUT ---------------------------");
        email = requestPersonalEmail();
        System.out.println("Your personal email: " + email);
    }

    /**
     * Requests the personal email address from the user.
     *
     * @return the user's personal email address
     */
    private String requestPersonalEmail() {
        String email;
        boolean valid = false;
        do {
            System.out.print("Enter your personal email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                valid = true;
            } else {
                System.out.println("Invalid email format. Please try again.");
            }
        } while (!valid);
        return email;
    }

    /**
     * Validates the email format.
     *
     * @param email the email to validate
     * @return true if the email format is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public String getEmail() {
        return email;
    }
}
