package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Size;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;
import java.util.Scanner;

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
     * Constructs an instance of RegisterGreenSpaceUI with the given email.
     *
     * @param email the user's email address
     */
    public RegisterGreenSpaceUI(String managerName) {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = GreenSpaceRepository.getInstance();
        this.scanner = new Scanner(System.in);
        this.managerName = managerName;
    }

    /**
     * Runs the registration process for a green space.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Register Green Space ------------------------");
        requestData();
        submitData();
        printGreenSpace();
    }

    private void requestData() {
        name = requestName();
        requestArea();
    }

    private String requestName() {
        System.out.print("Green Space name: ");
        return scanner.nextLine();
    }

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

    private void submitData() {
        greenSpace = controller.registerGreenSpace(name, area, size, managerName);
        greenSpaceRepository.addGreenSpace(greenSpace);
    }

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
