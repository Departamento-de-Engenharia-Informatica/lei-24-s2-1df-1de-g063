package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for registering collaborators.
 */
public class RegisterGreenSpaceUI implements Runnable {
    private final RegisterGreenSpaceController controller;
    private final GreenSpaceRepository greenSpaceRepository;
    private final Scanner scanner;
    private String name;
    private GreenSpace.Tamanho tamanho;
    private double area;
    private GreenSpace greenSpace;

    /**
     * Constructs an instance of RegisterCollaboratorUI.
     */
    public RegisterGreenSpaceUI() {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = GreenSpaceRepository.getInstance();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the registration process for a collaborator.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Register Green Space ------------------------");
        requestData();
        submitData();
        printCollaborator();
    }

    private void requestData() {
        name = requestName();
        area = (double) requestArea();
    }

    private String requestName() {
        System.out.print("Green Space name: ");
        return scanner.nextLine();
    }

    private Object requestArea() {
        double area;
        boolean isValid = false;
        do {
            System.out.print("Green Space area (squared meter): ");
            area = scanner.nextDouble();

            if (area > 0) {
                isValid = true;
                if (area < 50.0) {
                    return GreenSpace.Tamanho.Garden;
                } else if (area >= 50.0 && area <= 200.0) {
                    return GreenSpace.Tamanho.Medium_Size;
                } else {
                    return GreenSpace.Tamanho.Large_Size;
                }
            } else {
                System.out.println("Invalid area. Please enter a valid number.");
            }
        } while (!isValid);
        return area;
    }

    private void submitData() {
        greenSpace = controller.registerGreenSpace(name, area, tamanho);
        greenSpaceRepository.addGreenSpace(greenSpace);
    }

    private void printCollaborator() {
        int contador = 1;
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
        System.out.println("\n--- Green Spaces List -------------------------");
        for (GreenSpace greenSpace : greenSpaces) {
            System.out.printf("%d - %s%n", contador, greenSpace);
            contador++;
        }
    }
}

