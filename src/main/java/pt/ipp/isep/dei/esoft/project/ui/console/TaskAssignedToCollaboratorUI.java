package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.TaskAssignedToCollaboratorController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskAssignedToCollaboratorUI implements Runnable {
    private final String managerName;
    private TaskAssignedToCollaboratorController controller;
    private Scanner scanner;

    public TaskAssignedToCollaboratorUI(String managerName) {
        this.controller = new TaskAssignedToCollaboratorController(managerName);
        this.managerName = managerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        System.out.println("Enter the start date (YYYY/MM/DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.println("Enter the end date (YYYY/MM/DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine(), formatter);

        System.out.println("Enter the status: ");
        String status = scanner.nextLine();

        List<Entry> entries = controller.getEntriesBetweenDates(startDate, endDate, status, managerName);

        if (entries.isEmpty()) {
            System.out.println("No entries found with the given criteria.");
        } else {
            AtomicInteger counter = new AtomicInteger(1);
            entries.forEach(entry -> System.out.println(counter.getAndIncrement() + " - " + entry.toString()));

        }
    }

}