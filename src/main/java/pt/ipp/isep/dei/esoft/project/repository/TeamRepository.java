package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    private static List<Team> teams;
    private static TeamRepository instance;

    public static TeamRepository getInstance() {
        if (instance == null) {
            instance = new TeamRepository();
        }
        return instance;
    }

    public TeamRepository() {
        teams = new ArrayList<>();
    }

    public static void addTeams(Team team) {
        teams.add(team);
    }

//    public void printTeamsWithIndex() {
//        System.out.println("--- Teams List ---");
//        for (int i = 0; i < teams.size(); i++) {
//            System.out.println("Index: " + i);
//            System.out.println(teams.get(i));
//        }
//    }
    public List<Team> getTeams() {
        // This is a defensive copy, so that the repository cannot be modified from the outside.
        List<Team> defensiveCopy = List.copyOf(teams);
        for (int i = 0; i < defensiveCopy.size(); i++) {
            System.out.println("-----------------");
            System.out.println("Team number: " + i);
            System.out.println(defensiveCopy.get(i));
            System.out.println("-----------------");

        }
        return defensiveCopy;
    }

}
