package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.application.controller.GreenSpaceListController;

import java.util.List;

/**
 * The GreenSpacesListUI class provides a user interface for listing green spaces registered by a specific email.
 */
public class GreenSpacesListUI implements Runnable {
    private final String managerName;
    private final GreenSpaceRepository greenSpaceRepository;
    private final GreenSpaceListController greenSpaceListController;

    /**
     * Constructs a new GreenSpacesListUI object with the specified email.
     *
     * @param managerName The personal name of the user.
     */
    public GreenSpacesListUI(String managerName) {
        this.greenSpaceListController = new GreenSpaceListController();
        this.managerName = managerName;
        this.greenSpaceRepository = greenSpaceListController.getGreenSpaceRepository();
    }

    /**
     * Runs the green spaces list interface.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Green Spaces Registered by " + managerName + " ------------------------");
        listGreenSpaces();
    }

    /**
     * Lists and displays the green spaces registered by the email.
     */
    private void listGreenSpaces() {
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpacesByName(managerName);
        if (greenSpaces.isEmpty()) {
            System.out.println("No green spaces registered by this name.");
        } else {
            int counter = 1;
            for (GreenSpace greenSpace : greenSpaces) {
                System.out.printf("%d - %s%n", counter, greenSpace);
                counter++;
            }
        }
    }
}
