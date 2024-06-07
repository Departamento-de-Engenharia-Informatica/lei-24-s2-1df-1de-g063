package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.application.controller.GreenSpaceListController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

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
            sortGreenSpaces(greenSpaces);
            int counter = 1;
            for (GreenSpace greenSpace : greenSpaces) {
                System.out.printf("%d - %s%n", counter, greenSpace);
                counter++;
            }
        }
    }

    /**
     * Sorts the list of green spaces based on the configuration file.
     *
     * @param greenSpaces the list of green spaces to sort.
     */
    private void sortGreenSpaces(List<GreenSpace> greenSpaces) {
        String algorithm = getSortingAlgorithm();
        switch (algorithm) {
            case "SelectionSort":
                new SelectionSort().selectionSortListGreenSpaces(greenSpaces);
                break;
            case "MergeSort":
                new MergeSort().mergeSortGreenSpaces(greenSpaces);
                break;
            case "BubbleSort":
                new BubbleSort().bubbleSortListGreenSpaces(greenSpaces);
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm specified");
        }
    }

    /**
     * Reads the sorting algorithm from the configuration file.
     *
     * @return the sorting algorithm as a string.
     */
    private String getSortingAlgorithm() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Configuration file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
        return properties.getProperty("sorting.algorithm", "MergeSort");
    }
}
