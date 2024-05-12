package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * The TeamRepository class manages the storage and retrieval of teams.
 * It provides methods to add teams and retrieve a list of all teams.
 */
public class TeamRepository {

    private static List<Team> teams;
    private static TeamRepository instance;

    /**
     * Private constructor to prevent external instantiation.
     */
    public TeamRepository() {
        teams = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of TeamRepository.
     *
     * @return the instance of TeamRepository
     */
    public static TeamRepository getInstance() {
        if (instance == null) {
            instance = new TeamRepository();
        }
        return instance;
    }

    /**
     * Adds a team to the repository.
     *
     * @param team the team to add
     */
    public static void addTeams(Team team) {
        teams.add(team);
    }

    /**
     * Retrieves a list of all teams stored in the repository.
     *
     * @return a list of all teams
     */
    public List<Team> getTeams() {
        // This is a defensive copy to prevent modification of the repository's internal list
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
