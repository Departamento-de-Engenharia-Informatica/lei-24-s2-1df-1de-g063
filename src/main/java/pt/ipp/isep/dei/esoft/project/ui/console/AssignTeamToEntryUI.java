package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.AssignTeamToEntryController;
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
        printTeamList();
        System.out.println("Choose a team:");
        choiceTeam = scanner.nextInt();
        submitData();
    }

    /**
     * Submits the data.
     */
    public void submitData(){
        //controller.attributeTeamToEntry(choiceTeam,choiceEntry);
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
}