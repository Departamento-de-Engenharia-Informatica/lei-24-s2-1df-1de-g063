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

public class ToDoListUI implements Runnable {
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

    public ToDoListUI() {
        this.controller = new ToDoListController();
        this.toDoList = controller.getToDoList();
        this.scanner = new Scanner(System.in);
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
        this.status = Status.valueOf("pending");
    }

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

    private void requestData() {
        this.task = requestTask();
        this.urgency = requestUrgency();
        this.duration = requestDuration();
        printGreenSpacesList();
        this.greenSpace = greenSpaceRepository.getGreenSpaces().get(userChoiceGreenspace);
    }

    private void submitData() throws IOException {
        System.out.println("Task: " + task);
        System.out.println("Urgency: " + urgency);
        System.out.println("Duration: " + duration + "hours");
        System.out.println("Status: " + status);
        entry = controller.registerEntry(task, urgency, duration, greenSpace, status);
        toDoList.addEntry(entry);
        printData();
    }



    private String requestTask() {
        boolean valid;
        do {
            System.out.print("Task: ");
            task = scanner.nextLine();
            valid = validateEntry(task);
        } while (!valid);
        return task;
    }

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

    private void printGreenSpacesList() {
        choice = 0;
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
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
