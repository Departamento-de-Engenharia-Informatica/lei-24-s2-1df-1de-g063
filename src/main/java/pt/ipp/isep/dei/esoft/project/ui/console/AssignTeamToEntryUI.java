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

    private int choice;

    public AssignTeamToEntryUI(){
        this.controller = new AssignTeamToEntryController();
        this.scanner = new Scanner(System.in);
    }


    public void run(){
        System.out.println("\n\n--- Assign Team to an Entry ------------------------");
        printTeamList();
        requestData();
        submitData();
    }

    public void requestData(){

    }

    public void submitData(){

    }
    private void printTeamList() {
        choice = 0;
        List<Team> teams = controller.getTeams();
        System.out.println("\n---  Teams List -------------------------");
        if (teams.isEmpty()) {
            System.out.println("No Teams registered yet.");
        } else {
            for (Team team : teams) {
                System.out.printf("%d - %s%n", choice, team);
                choice++;
            }
        }
    }

}
