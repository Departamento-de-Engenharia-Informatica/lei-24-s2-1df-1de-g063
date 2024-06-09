package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 * The TeamRepository class manages the storage and retrieval of teams.
 * It provides methods to add teams and retrieve a list of all teams.
 */
public class TeamRepository implements Serializable {

    private List<Team> teams;
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
    public void addTeams(Team team) {
        teams.add(team);
    }

    public void clear() {
        teams.clear();
    }

    /**
     * Retrieves a list of all teams stored in the repository.
     *
     * @return a list of all teams
     */
    public List<Team> getTeams() {
        // This is a defensive copy to prevent modification of the repository's internal list
        return List.copyOf(teams);
    }
    public Team getTeams(int index) {
        if (index >= 0 && index < teams.size()) {
            return teams.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
