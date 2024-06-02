package pt.ipp.isep.dei.esoft.project.ui.console.menu;

import java.util.Scanner;

/**
 * The UserNameUI class provides an interface for the user to input their personal name.
 */
public class UserNameUI implements Runnable {
    private final Scanner scanner;
    private String name;

    /**
     * Constructs a new UserNameUI object.
     */
    public UserNameUI() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the user name input interface.
     */
    public void run() {
        System.out.println("\n\n--- PERSONAL NAME INPUT ---------------------------");
        name = requestPersonalName();
        System.out.println("Your personal name: " + name);
    }

    /**
     * Requests the personal name from the user.
     *
     * @return the user's personal name
     */
    private String requestPersonalName() {
        String name;
        boolean valid = false;
        do {
            System.out.print("Enter your personal name: ");
            name = scanner.nextLine();
            if (isValidName(name)) {
                valid = true;
            } else {
                System.out.println("Invalid name format. Please try again.");
            }
        } while (!valid);
        return name;
    }

    /**
     * Validates the name format.
     *
     * @param name the name to validate
     * @return true if the name format is valid, false otherwise
     */
    private boolean isValidName(String name) {
        // Add your name validation logic here
        return name != null && !name.trim().isEmpty();
    }

    public String getName() {
        return name;
    }

}