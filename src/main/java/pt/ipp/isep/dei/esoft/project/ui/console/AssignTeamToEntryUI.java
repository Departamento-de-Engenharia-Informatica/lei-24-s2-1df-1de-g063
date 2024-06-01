package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AssignTeamToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.List;
import java.util.Scanner;

/**
 * User interface for assigning teams to entries.
 */
public class AssignTeamToEntryUI implements Runnable {

    private final AssignTeamToEntryController controller;
    private final Scanner scanner;

    private int choiceTeam;
    private int choiceEntry;

    /**
     * Constructor for AssignTeamToEntryUI.
     * Initializes the controller and scanner.
     */
    public AssignTeamToEntryUI(){
        this.controller = new AssignTeamToEntryController();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the user interface.
     */
    public void run(){
        System.out.println("\n\n--- Assign Team to an Entry ------------------------");
        requestData();
    }

    /**
     * Requests data from the user.
     */
    public void requestData(){
    do {
        printTeamList();
        System.out.println("Choose a team:");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number:");
            scanner.next();
        }
        choiceTeam = scanner.nextInt();
        if (choiceTeam == -1) {
            return;
        }
        if (choiceTeam < 0 || choiceTeam >= controller.getTeams().size()) {
            System.out.println("Invalid choice. Please choose a number from the list:");
            continue;
        }
        break;
    } while (true);

    do {
        printEntryList();
        System.out.println("Choose an entry:");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number:");
            scanner.next();
        }
        choiceEntry = scanner.nextInt();
        if (choiceEntry == -1) {
            return;
        }
        if (choiceEntry < 0 || choiceEntry >= controller.getEntries().size()) {
            System.out.println("Invalid choice. Please choose a number from the list:");
            continue;
        }
        String selectedEntry = controller.getEntries().get(choiceEntry);
        if (selectedEntry.contains("(Team assigned)")) {
            System.out.println("This entry already has a team assigned. Please choose another entry:");
            continue;
        }
        break;
    } while (true);

    submitData();
}

    /**
     * Submits the data.
     */
    public void submitData(){
        controller.attributeTeamToEntry(choiceTeam,choiceEntry);
    }

    /**
     * Prints the list of teams.
     */
    private void printTeamList() {
        choiceTeam = 0;
        List<Team> teams = controller.getTeams();
        System.out.println("\n---  Teams List -------------------------");
        if (teams.isEmpty()) {
            System.out.println("No Teams registered yet.");
        } else {
            for (Team team : teams) {
                System.out.printf("%d - %s%n", choiceTeam, team);
                choiceTeam++;
            }
        }
    }
   private void printEntryList() {
    choiceEntry = 0;
    List<String> entries = controller.getEntries();
    System.out.println("\n--- Entries List -------------------------");
    if (entries.isEmpty()) {
        System.out.println("No Entries registered yet.");
    } else {
        for (String entry : entries) {
            System.out.printf("%d - %s%n", choiceEntry, entry);
            choiceEntry++;
        }
    }
}
}