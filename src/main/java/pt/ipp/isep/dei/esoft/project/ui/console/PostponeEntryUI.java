package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AgendaController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static pt.ipp.isep.dei.esoft.project.domain.Status.valueOf;

/**
 * This class provides a console-based user interface for postponing an entry.
 * It allows the user to select an entry, specify a new start date, and automatically calculates the end date based on the duration of the task.
 * The class implements the Runnable interface, meaning it can be used in a thread.
 * The class uses an AgendaController to handle the business logic of managing the agenda.
 * It also uses an AgendaRepository to manage the entries in the agenda.
 * The class includes several private instance variables to store the data entered by the user, including the choice of entry, duration, status, start date, end date, and a Scanner object for reading user input.
 * The class includes a main method, run(), which is called when the class is run as a thread.
 * This method requests data from the user and submits the data.
 * The class includes a constructor that initializes the controller, to-do list, agenda repository, and scanner.
 * It also sets the status to "postponed".
 */
public class PostponeEntryUI implements Runnable {
    private final AgendaController controller;
    private final ToDoList toDoList;
    private final AgendaRepository agendaRepository;
    private final Scanner scanner;
    private int choice;
    private int duration;
    private Status status;
    private Entry entry;
    private LocalDate startDate;
    private LocalDate endDate;
    private Entry selectedEntry;
    private int loc;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /**
     * Constructs a new PostponeEntryUI.
     */
    public PostponeEntryUI() {
        this.controller = new AgendaController();
        this.toDoList = controller.getToDoList();
        this.agendaRepository = Repositories.getInstance().getAgendaRepository();
        this.scanner = new Scanner(System.in);
        this.status = Status.postponed;
    }

    /**
     * Executes the PostponeEntryUI.
     */
    @Override
    public void run() {
        requestData();
        submitData();
    }

    /**
     * Requests data from the user.
     * This includes selecting an entry, specifying a new start date, and automatically calculating the end date based on the duration of the task.
     */
    private void requestData() {
        selectedEntry = requestEntry();
        if (selectedEntry != null) {
            this.duration = selectedEntry.getDuration();
            requestStartDate();
            calculateEndDate();
        }
    }

    /**
     * Requests the user to select an entry to postpone.
     *
     * @return The selected entry.
     */
    private Entry requestEntry() {
        int contador = 0;
        Status testStatus= Status.valueOf("scheduled");
        choice = 0;
        List<Entry> entries = agendaRepository.getEntriesWithStatus(testStatus);
        System.out.println("\n--- Agenda List -------------------------");
        if (entries.isEmpty()) {
            System.out.println("No entries registered yet.");
            return null;
        } else {
            for (Entry entry : entries) {
                System.out.printf("%d - %s%n", contador, entry);
                contador++;
            }
        }
        choice = requestUserChoice("entry");
        return entries.get(choice);
    }

    /**
     * Requests the user to enter a new start date for the selected entry.
     */
    private void requestStartDate() {
        boolean valid = false;
        do {
            System.out.print("Enter the start date (YYYY/MM/DD): ");
            try {
                String input = scanner.nextLine();
                this.startDate = LocalDate.parse(input, DATE_FORMATTER);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY/MM/DD format.");
            }
        } while (!valid);
    }

    /**
     * Calculates the end date of the selected entry based on the new start date and the duration of the task.
     */
    private void calculateEndDate() {
        if (startDate != null && duration > 0) {
            int fullDays = duration / 8;
            int remainingHours = duration % 8;

            this.endDate = startDate.plusDays(fullDays);

            if (remainingHours > 0) {
                this.endDate = this.endDate.plusDays(0);
            }
            System.out.printf("The task will end on: %s%n", endDate.format(DATE_FORMATTER));
        }
    }

    /**
     * Submits the data entered by the user.
     * This includes updating the start date, end date, and status of the selected entry, and saving the updated entry to the agenda.
     */
    private void submitData() {
        if (selectedEntry != null) {
            selectedEntry.setStartDate(startDate);
            selectedEntry.setEndDate(endDate);
            selectedEntry.setStatus(Status.postponed);
            System.out.println("Entry has been updated and saved to the agenda.");
        } else {
            System.out.println("No entry to submit.");
        }
        printData();
    }

    /**
     * Prints the data of the postponed entries in the agenda.
     */
    private void printData() {
        int contador = 0;
        Status testStatus= Status.valueOf("postponed");
        List<Entry> entries = agendaRepository.getEntriesWithStatus(testStatus);
        System.out.println("\n--- Agenda (postponed) Entries ---------------------");
        if (entries.isEmpty()) {
            System.out.println("No entries registered yet.");
        } else {
            for (Entry entry : entries) {
                System.out.printf("%d - %s%n", contador, entry);
                contador++;
            }
        }
        System.out.println("----------------------------------------");
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
                if (userChoice >= 0 && userChoice <= toDoList.getToDoList().size() - 1) {
                    isValid = true;
                } else {
                    System.out.printf("Invalid choice. Please enter a number between 0 and %d.%n",
                            toDoList.getToDoList().size() - 1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!isValid);

        return userChoice;
    }
}