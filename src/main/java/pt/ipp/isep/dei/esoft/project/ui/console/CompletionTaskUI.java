package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CompletionTaskController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for marking an entry as completed.
 */
public class CompletionTaskUI implements Runnable {
    /**
     * The repository for agenda entries.
     */
    private final AgendaRepository agenda;

    /**
     * The controller for managing completion tasks.
     */
    private final CompletionTaskController completionTaskController;

    /**
     * Scanner object for user input.
     */
    private final Scanner scanner;

    /**
     * Constructs a new CompletionTaskUI.
     */
    public CompletionTaskUI() {
        this.agenda = Repositories.getInstance().getAgendaRepository();
        this.completionTaskController = new CompletionTaskController();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Executes the CompletionTaskUI.
     */
    @Override
    public void run() {
        requestData();
        submitData();
    }

    /**
     * Requests data from the user.
     */
    private void requestData() {
        System.out.println("Select an entry to mark as completed:");
        List<Entry> entries = agenda.getEntries();
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ". " + entries.get(i).toString());
        }
    }

    /**
     * Submits data entered by the user.
     */
    private void submitData() {
        System.out.println("Enter the number of the entry you want to mark as completed:");
        int choice = scanner.nextInt();
        Entry selectedEntry = agenda.getEntries(choice - 1);
        completionTaskController.markAsCompleted(selectedEntry);
        System.out.println("The selected entry has been marked as completed.");
    }
}
