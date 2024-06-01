package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;

/**
 * The GreenSpacesListUI class provides a user interface for listing green spaces registered by a specific email.
 */
public class GreenSpacesListUI implements Runnable {
    private final String email;
    private final GreenSpaceRepository greenSpaceRepository;

    /**
     * Constructs a new GreenSpacesListUI object with the specified email.
     *
     * @param email The email address of the user.
     */
    public GreenSpacesListUI(String email) {
        this.email = email;
        this.greenSpaceRepository = GreenSpaceRepository.getInstance();
    }

    /**
     * Runs the green spaces list interface.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Green Spaces Registered by " + email + " ------------------------");
        listGreenSpaces();
    }

    /**
     * Lists and displays the green spaces registered by the email.
     */
    private void listGreenSpaces() {
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpacesByEmail(email);
        if (greenSpaces.isEmpty()) {
            System.out.println("No green spaces registered by this email.");
        } else {
            int counter = 1;
            for (GreenSpace greenSpace : greenSpaces) {
                System.out.printf("%d - %s%n", counter, greenSpace);
                counter++;
            }
        }
    }
}
