package pt.ipp.isep.dei.esoft.project.ui.console;
import pt.ipp.isep.dei.esoft.project.application.controller.AssignTeamToEntryController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AssignTeamToEntryUI implements Runnable {

    private final AssignTeamToEntryController controller;
    private final Scanner scanner;

    private int choiceTeam;

    private int choiceEntry;

    public AssignTeamToEntryUI(){
        this.controller = new AssignTeamToEntryController();
        this.scanner = new Scanner(System.in);
    }


    public void run(){
        System.out.println("\n\n--- Assign Team to an Entry ------------------------");
        requestData();
    }

    public void requestData(){
        printTeamList();
        System.out.println("Choose a team:");
        choiceTeam = scanner.nextInt();
//        printEntryList();
//        System.out.println("Choose a entry");
//        choiceEntry = scanner.nextInt();
        submitData();

    }

    public void submitData(){
        Team selectedTeam = controller.getTeams(choiceTeam);
        //Entry selectedEntry = controller.getEntries(choiceEntry);
        //controller.attributeTeamToEntry(selectedTeam,selectedEntry);

    }
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
//    private void printEntryList() {
//        choiceEntry = 0;
//        List<Team> teams = controller.getEntries();
//        System.out.println("\n---  Teams List -------------------------");
//        if (teams.isEmpty()) {
//            System.out.println("No Teams registered yet.");
//        } else {
//            for (Team team : teams) {
//                System.out.printf("%d - %s%n", choiceEntry, team);
//                choiceEntry++;
//            }
//        }
//    }

}
