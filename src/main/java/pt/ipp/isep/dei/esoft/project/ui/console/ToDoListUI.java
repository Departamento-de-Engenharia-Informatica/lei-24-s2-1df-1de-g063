package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SerializationUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides a console-based user interface for managing a to-do list.
 * It allows the user to add new entries to the to-do list, each with a task, urgency, duration, associated green space, and status.
 * The class implements the Runnable interface, meaning it can be used in a thread.
 * It also implements Serializable, allowing instances of the class to be saved to a file for later use.
 *
 * The class uses a ToDoListController to handle the business logic of managing the to-do list.
 * It also uses a GreenSpaceRepository to manage the green spaces associated with tasks.
 *
 * The class provides methods for requesting data from the user, submitting data, and printing the list of entries and green spaces.
 * It also includes methods for validating the task entered by the user and requesting the user's choice of green space.
 *
 * The class includes several private instance variables to store the data entered by the user, including the task, urgency, duration, green space, and status.
 * It also includes a Scanner object for reading user input.
 *
 * The class includes a main method, run(), which is called when the class is run as a thread.
 * This method displays a menu to the user, requests data from the user, and submits the data.
 *
 * The class includes a constructor that initializes the controller, to-do list, scanner, and green space repository.
 * It also sets the status to "pending".
 *
 * The class includes a serialVersionUID for serialization.
 */
public class ToDoListUI implements Runnable, Serializable {
    private static final long serialVersionUID = 1L;
    private final ToDoListController controller;
    private final ToDoList toDoList;
    private final Scanner scanner;
    private final GreenSpaceRepository greenSpaceRepository;
    private int choice;
    private String task;
    private Urgency urgency;
    private int duration;
    private GreenSpace greenSpace;
    private Status status;
    private int userChoiceGreenspace;
    private Entry entry;

    /**
     * Constructs a new ToDoListUI.
     */
    public ToDoListUI() {
        this.controller = new ToDoListController();
        this.toDoList = controller.getToDoList();
        this.scanner = new Scanner(System.in);
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
        this.status = Status.valueOf("pending");
    }

    /**
     * Executes the ToDoListUI.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Add a new Entry to To-Do List ------------------------");
        requestData();
        try {
            submitData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        this.task = requestTask();
        this.urgency = requestUrgency();
        this.duration = requestDuration();
        printGreenSpacesList();
        this.greenSpace = greenSpaceRepository.getGreenSpaces().get(userChoiceGreenspace);
    }

    /**
     * Submits data entered by the user.
     */
    private void submitData() throws IOException {
        System.out.println("Task: " + task);
        System.out.println("Urgency: " + urgency);
        System.out.println("Duration: " + duration + "hours");
        System.out.println("Status: " + status);
        entry = controller.registerEntry(task, urgency, duration, greenSpace, status);
        toDoList.addEntry(entry);
        printData();
    }

    /**
     * Requests the task from the user.
     * Validates the task input.
     *
     * @return The task entered by the user.
     */
    private String requestTask() {
        boolean valid;
        do {
            System.out.print("Task: ");
            task = scanner.nextLine();
            valid = validateEntry(task);
        } while (!valid);
        return task;
    }

    /**
     * Requests the urgency of the task from the user.
     * Validates the urgency input.
     *
     * @return The urgency of the task.
     */
    private Urgency requestUrgency() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Urgency List -------------------------");
        for (int i = 0; i < Urgency.values().length; i++) {
            System.out.printf("%d - %s%n", i, Urgency.values()[i]);
        }
        do {
            System.out.print("Choose an urgency (0-" + (Urgency.values().length - 1) + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice < 0 || choice >= Urgency.values().length) {
                System.out.println("Invalid choice. Please choose a number within the range.");
            }
        } while (choice < 0 || choice >= Urgency.values().length);
        scanner.nextLine();
        return Urgency.values()[choice];
    }

    /**
     * Requests the duration of the task from the user.
     * Validates the duration input.
     *
     * @return The duration of the task.
     */
    private int requestDuration() {
        boolean valid = false;
        int duration = 0;

        do {
            System.out.print("Duration of the task (in hours, 1 day = 8 hours): ");
            if (scanner.hasNextInt()) {
                duration = scanner.nextInt();
                scanner.nextLine();

                if (duration > 0) {
                    valid = true;
                } else {
                    System.out.println("Please input a positive number greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        } while (!valid);

        return duration;
    }

    /**
     * Prints the list of green spaces.
     * Requests the user's choice of green space.
     */
    private void printGreenSpacesList() {
        choice = 0;
        List<GreenSpace> greenSpaces = GreenSpaceRepository.getInstance().getGreenSpaces();
        System.out.println("\n--- GreenSpace List -------------------------");
        if (greenSpaces.isEmpty()) {
            System.out.println("No Greenspaces registered yet.");
        } else {
            for (GreenSpace greenSpace1 : greenSpaces) {
                System.out.printf("%d - %s%n", choice, greenSpace1);
                choice++;
            }
        }
        userChoiceGreenspace = requestUserChoice("greenspace");
    }

    /**
     * Prints the data of the to-do list.
     */
    private void printData() {
        int contador = 0;
        List<Entry> entries = toDoList.getToDoList();
        System.out.println("\n--- Entry List -------------------------");
        if (entries.isEmpty()) {
            System.out.println("No entries registered yet.");
        } else {
            for (Entry entry : entries) {
                System.out.printf("%d - %s%n", contador, entry);
                contador++;
            }
        }
    }

    /**
     * Validates the task entered by the user.
     *
     * @param Task The task to validate.
     * @return true if the task is valid, false otherwise.
     */
    private boolean validateEntry(String Task) {
        List<Entry> entryList = toDoList.getToDoList();
        boolean valid = true;

        if (task == null || task.trim().isEmpty()) {
            valid = false;
        } else if (!task.matches("[a-zA-Z0-9., !?-]+")) {
            System.out.println("Entry has invalid characters");
            valid = false;
        }
        for (Entry e : entryList) {
            if (e.toString().equals(toDoList.toString())) {
                System.out.println("Entry already exists");
                valid = false;
            }
        }

        return valid;
    }

    /**
     * Requests the user's choice for a specific type.
     *
     * @param type The type of choice to request.
     * @return The user's choice.
     */
    private int requestUserChoice(String type) {
        int userChoice = 0;
        boolean isValid = false;

        do {
            System.out.printf("Enter your choice for %s: ", type);

            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice >= 0 && userChoice <= choice - 1) {
                    isValid = true;
                } else {
                    System.out.printf("Invalid choice. Please enter a number between 0 and %d.%n", choice - 1);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!isValid);

        return userChoice;
    }
}