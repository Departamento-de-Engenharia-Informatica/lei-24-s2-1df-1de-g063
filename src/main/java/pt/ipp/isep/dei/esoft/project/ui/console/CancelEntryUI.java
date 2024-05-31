package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AgendaController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CancelEntryUI implements Runnable {
    private final AgendaController controller;
    private final ToDoList toDoList;
    private final AgendaRepository agenda;
    private final Scanner scanner;
    private int choice;
    private int duration;
    private Status status;
    private Entry entry;
    private LocalDate startDate;
    private LocalDate endDate;
    private Entry selectedEntry;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public CancelEntryUI() {
        this.controller = new AgendaController();
        this.toDoList = controller.getToDoList();
        this.agenda = controller.getAgendaRepository();
        this.scanner = new Scanner(System.in);
        this.status = Status.canceled;
    }

    @Override
    public void run() {
        requestData();
        submitData();
    }

    private void requestData() {
        selectedEntry = requestEntry();
        if (selectedEntry != null) {
            this.duration = selectedEntry.getDuration();
        }
    }

    private Entry requestEntry() {
        int contador = 0;
        choice = 0;
        List<Entry> entries = agenda.getAgenda();
        System.out.println("\n--- Agenda -------------------------");
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

    private void submitData() {
        if (selectedEntry != null) {
            selectedEntry.setStartDate(startDate);
            selectedEntry.setEndDate(endDate);
            selectedEntry.setStatus(Status.canceled);
            System.out.println("Entry has been canceled and saved to the agenda.");
        } else {
            System.out.println("No entry to submit.");
        }
        printData();
    }

    private void printData() {
        int contador = 0;
        List<Entry> entries = agenda.getAgenda();
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
