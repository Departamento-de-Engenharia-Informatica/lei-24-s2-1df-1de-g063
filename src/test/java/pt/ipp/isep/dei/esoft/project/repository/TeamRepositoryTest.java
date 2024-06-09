package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamRepositoryTest {

    private TeamRepository teamRepository;
    private Team team1;
    private Team team2;

    @BeforeEach
    public void setUp() {
        teamRepository = TeamRepository.getInstance();
        teamRepository.clear();
        team1 = new Team();
        team2 = new Team();
    }

    @Test
    public void testAddTeams() {
        teamRepository.addTeams(team1);
        List<Team> teams = teamRepository.getTeams();
        assertEquals(1, teams.size());
        assertEquals(team1, teams.get(0));
    }

    @Test
    public void testGetTeams() {
        teamRepository.addTeams(team1);
        teamRepository.addTeams(team2);
        List<Team> teams = teamRepository.getTeams();
        assertEquals(2, teams.size());
        assertEquals(team1, teams.get(0));
        assertEquals(team2, teams.get(1));
    }

    @Test
    void getInstance() {
        TeamRepository instance1 = TeamRepository.getInstance();
        TeamRepository instance2 = TeamRepository.getInstance();
        // The getInstance method should always return the same instance
        assertSame(instance1, instance2);
    }

    @Test
    void addTeams() {
        Team team = new Team();
        // Add the team to the repository
        teamRepository.addTeams(team);
        // The team should now be in the repository
        assertTrue(teamRepository.getTeams().contains(team));
    }

    @Test
    void clear() {
        // Add some teams to the repository
        teamRepository.addTeams(new Team());
        teamRepository.addTeams(new Team());
        // Clear the repository
        teamRepository.clear();
        // The repository should now be empty
        assertTrue(teamRepository.getTeams().isEmpty());
    }

    @Test
    void getTeams() {
        // Add some teams to the repository
        Team team1 = new Team();
        Team team2 = new Team();
        teamRepository.addTeams(team1);
        teamRepository.addTeams(team2);
        // Get the teams from the repository
        List<Team> teams = teamRepository.getTeams();
        // The teams should be in the repository
        assertEquals(2, teams.size());
        assertTrue(teams.contains(team1));
        assertTrue(teams.contains(team2));
    }

}