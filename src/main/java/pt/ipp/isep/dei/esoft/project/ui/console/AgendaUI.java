package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AgendaController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static pt.ipp.isep.dei.esoft.project.domain.Status.valueOf;

/**
 * The AgendaUI class represents the user interface for managing agenda entries.
 * It allows users to select entries, specify start dates, calculate end dates, and submit entries to the agenda.
 */
public class AgendaUI implements Runnable {
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
     * Constructs an AgendaUI object.
     */
    public AgendaUI() {
        this.controller = new AgendaController();
        this.toDoList = controller.getToDoList();
        this.agendaRepository = Repositories.getInstance().getAgendaRepository();
        this.scanner = new Scanner(System.in);
        this.status = Status.scheduled;
    }

    @Override
    public void run() {
        requestData();
        submitData();
    }

    /**
     * Requests data from the user, including selecting an entry and specifying start date.
     */
    private void requestData() {
        selectedEntry = requestEntry();
        if (selectedEntry != null) {
            this.duration = selectedEntry.getDuration();
            requestStartDate();
            calculateEndDate();
            addEntryToAgenda(selectedEntry);
        }
    }

    /**
     * Requests the user to select an entry from the to-do list.
     *
     * @return the selected entry
     */
    private Entry requestEntry() {
        int contador = 0;
        Status testStatus= Status.valueOf("pending");
        choice = 0;
        List<Entry> entries = toDoList.getEntriesWithStatus(testStatus);
        System.out.println("\n--- Entry List -------------------------");
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
     * Adds the selected entry to the agenda.
     *
     * @param entry the entry to add
     */
    private void addEntryToAgenda(Entry entry) {
        if (entry != null) {
            agendaRepository.addEntry(entry);
            System.out.println("Entry added to the agenda.");
        } else {
            System.out.println("No entry was added to the agenda.");
        }
    }

    /**
     * Requests the user to input the start date of the task.
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
     * Calculates and prints the end date of the task based on start date and duration.
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
     * Submits the selected entry to the agenda after updating its start and end dates.
     */
    private void submitData() {
        if (selectedEntry != null) {
            selectedEntry.setStartDate(startDate);
            selectedEntry.setEndDate(endDate);
            selectedEntry.setStatus(Status.scheduled);
            System.out.println("Entry has been updated and saved to the agenda.");
        } else {
            System.out.println("No entry to submit.");
        }
        printData();
    }

    /**
     * Prints the entries in the agenda.
     */
    private void printData() {
        int contador = 0;
        Status testStatus= Status.valueOf("scheduled");
        List<Entry> entries = agendaRepository.getEntriesWithStatus(testStatus);
        System.out.println("\n--- Agenda Entries ---------------------");
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
     * Requests the user to input a choice.
     *
     * @param type the type of choice
     * @return the user's choice
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
