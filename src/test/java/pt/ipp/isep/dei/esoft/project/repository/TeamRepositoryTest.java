package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
