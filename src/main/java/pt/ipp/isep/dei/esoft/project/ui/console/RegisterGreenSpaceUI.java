package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Size;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;
import java.util.Scanner;

/**
 * This class provides a console-based user interface for registering a green space.
 * It allows the user to enter the name and area of the green space, and automatically determines the size of the green space based on the area.
 * The class implements the Runnable interface, meaning it can be used in a thread.
 * The class uses a RegisterGreenSpaceController to handle the business logic of registering the green space.
 * It also uses a GreenSpaceRepository to manage the green spaces.
 * The class includes several private instance variables to store the data entered by the user, including the name, size, area, and a Scanner object for reading user input.
 * The class includes a main method, run(), which is called when the class is run as a thread.
 * This method requests data from the user, submits the data, and prints the list of green spaces.
 * The class includes a constructor that initializes the controller, green space repository, scanner, and manager's name.
 */
public class RegisterGreenSpaceUI implements Runnable {
    private final RegisterGreenSpaceController controller;
    private final GreenSpaceRepository greenSpaceRepository;
    private final Scanner scanner;
    private String name;
    private Size size;
    private double area;
    private GreenSpace greenSpace;
    private final String managerName;

    /**
     * Constructs a new RegisterGreenSpaceUI.
     *
     * @param managerName The name of the manager for whom the green space is to be registered.
     */
    public RegisterGreenSpaceUI(String managerName) {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = GreenSpaceRepository.getInstance();
        this.scanner = new Scanner(System.in);
        this.managerName = managerName;
    }

    /**
     * Executes the RegisterGreenSpaceUI.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Register Green Space ------------------------");
        requestData();
        submitData();
        printGreenSpace();
    }

    /**
     * Requests data from the user.
     * This includes the name and area of the green space.
     * It also automatically determines the size of the green space based on the area.
     */
    private void requestData() {
        name = requestName();
        requestArea();
    }

    /**
     * Requests the name of the green space from the user.
     *
     * @return The name of the green space.
     */
    private String requestName() {
        System.out.print("Green Space name: ");
        return scanner.nextLine();
    }

    /**
     * Requests the area of the green space from the user.
     * It also automatically determines the size of the green space based on the area.
     */
    private void requestArea() {
        boolean isValid = false;
        do {
            System.out.print("Green Space area (squared meter): ");
            if (scanner.hasNextDouble()) {
                area = scanner.nextDouble();
                scanner.nextLine();
                if (area > 0) {
                    isValid = true;
                    if (area < 50.0) {
                        size = Size.Garden;
                    } else if (area <= 200.0) {
                        size = Size.Medium_Size;
                    } else {
                        size = Size.Large_Size;
                    }
                } else {
                    System.out.println("Invalid area. Please enter a valid number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        } while (!isValid);
    }

    /**
     * Submits the data entered by the user.
     * This includes creating a new green space with the entered name, area, and size, and adding it to the green space repository.
     */
    private void submitData() {
        greenSpace = controller.registerGreenSpace(name, area, size, managerName);
        greenSpaceRepository.addGreenSpace(greenSpace);
    }

    /**
     * Prints the list of green spaces in the green space repository.
     */
    private void printGreenSpace() {
        int contador = 1;
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
        System.out.println("\n--- Green Spaces List -------------------------");
        for (GreenSpace greenSpace : greenSpaces) {
            System.out.printf("%d - %s%n", contador, greenSpace);
            contador++;
        }
    }
}