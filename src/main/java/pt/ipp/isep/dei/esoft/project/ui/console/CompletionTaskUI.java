package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CompletionTaskController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;

import java.util.List;
import java.util.Scanner;

public class CompletionTaskUI implements Runnable {
    private final AgendaRepository agenda;
    private final CompletionTaskController completionTaskController;
    private final Scanner scanner;

    public CompletionTaskUI() {
        this.agenda = AgendaRepository.getInstance();
        this.completionTaskController = new CompletionTaskController();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        requestData();
        submitData();
    }

    private void requestData() {
        System.out.println("Select an entry to mark as completed:");
        List<Entry> entries = agenda.getEntries();
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ". " + entries.get(i).toString());
        }
    }

    private void submitData() {
        System.out.println("Enter the number of the entry you want to mark as completed:");
        int choice = scanner.nextInt();
        Entry selectedEntry = agenda.getEntries(choice - 1);
        completionTaskController.markAsCompleted(selectedEntry);
        System.out.println("The selected entry has been marked as completed.");
    }
}