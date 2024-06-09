package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Size;
import pt.ipp.isep.dei.esoft.project.domain.Urgency;
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
    private  String managerName;

    /**
     * Constructs a new RegisterGreenSpaceUI.
     * Initializes the controller, green space repository, and scanner.
     */
    public RegisterGreenSpaceUI() {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = GreenSpaceRepository.getInstance();
        this.scanner = new Scanner(System.in);

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
        managerName = requestManagerName();
        area = requestArea();
        size = requestSize();

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
     * Requests the name of the manager responsible for the green space from the user.
     *
     * @return The name of the manager.
     */
    private String requestManagerName() {
        System.out.print("Manager name: ");
        return scanner.nextLine();
    }
    /**
     * Requests the area of the green space from the user.
     *
     * @return The area of the green space.
     */
    private double requestArea() {
        System.out.print("Area: ");
        return scanner.nextDouble();
    }


    private Size requestSize() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Size List -------------------------");
        for (int i = 0; i < Size.values().length; i++) {
            System.out.printf("%d - %s%n", i, Size.values()[i]);
        }
        do {
            System.out.print("Choose a Size (0-" + (Size.values().length - 1) + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice >= Size.values().length) {
                System.out.println("Invalid choice. Please choose a number within the range.");
            }
        } while (choice < 0 || choice >= Size.values().length);
        scanner.nextLine();
        return Size.values()[choice];
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