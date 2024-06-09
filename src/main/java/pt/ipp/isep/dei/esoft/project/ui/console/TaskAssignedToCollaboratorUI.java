package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.TaskAssignedToCollaboratorController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * Provides a console-based user interface for viewing tasks assigned to a collaborator within a specified date range.
 */
public class TaskAssignedToCollaboratorUI implements Runnable {
    private final String managerName;
    private TaskAssignedToCollaboratorController controller;
    private Scanner scanner;

    /**
     * Constructs a TaskAssignedToCollaboratorUI object with the specified manager's name.
     *
     * @param managerName The name of the manager for whom tasks are to be viewed.
     */
    public TaskAssignedToCollaboratorUI(String managerName) {
        this.controller = new TaskAssignedToCollaboratorController(managerName);
        this.managerName = managerName;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the TaskAssignedToCollaboratorUI, prompting the user for input and displaying the tasks assigned to the collaborator.
     */
    @Override
    public void run() {
        requestData();
    }

    /**
     * Requests data from the user, including the start date, end date, and status of tasks to view.
     */
    public void requestData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate startDate = null;
        LocalDate endDate = null;
        boolean validDates = false;

        Pattern letterPattern = Pattern.compile("[a-zA-Z]+");

        while (!validDates) {
            System.out.println("Enter the start date (YYYY/MM/DD): ");
            String startDateStr = scanner.nextLine();

            System.out.println("Enter the end date (YYYY/MM/DD): ");
            String endDateStr = scanner.nextLine();

            try {
                startDate = LocalDate.parse(startDateStr, formatter);
                endDate = LocalDate.parse(endDateStr, formatter);

                if (startDate.isAfter(endDate)) {
                    System.out.println("Error: Start date cannot be after end date. Please try again.");
                } else {
                    validDates = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Invalid date format. Please enter dates in YYYY/MM/DD format.");
            }
        }

        String status;
        do {
            System.out.println("Enter the status (letters only): ");
            status = scanner.nextLine();
        } while (!letterPattern.matcher(status).matches());

        List<Entry> entries = controller.getEntriesBetweenDates(startDate, endDate, status, managerName);

        if (entries.isEmpty()) {
            System.out.println("No entries found with the given criteria.");
        } else {
            AtomicInteger counter = new AtomicInteger(1);
            entries.forEach(entry -> System.out.println(counter.getAndIncrement() + " - " + entry.toString()));
        }
    }

}
