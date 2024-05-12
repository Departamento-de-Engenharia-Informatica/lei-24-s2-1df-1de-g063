package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {

    private Team team;
    private Collaborator collaborator1;
    private Collaborator collaborator2;

    @BeforeEach
    public void setUp() {
        team = new Team();
        collaborator1 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
            collaborator2 = new Collaborator("Jane Smith", "456 Main St", "jane.smith@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
    }

    @Test
    public void testAddMember() {
        team.addMember(collaborator1);
        assertEquals(1, team.getMembers().size());
        assertEquals(collaborator1, team.getMembers().get(0));
    }

    @Test
    public void testRemoveMember() {
        team.addMember(collaborator1);
        team.addMember(collaborator2);
        assertEquals(2, team.getMembers().size());

        team.removeMember(collaborator1);
        assertEquals(1, team.getMembers().size());
        assertEquals(collaborator2, team.getMembers().get(0));
    }

    @Test
    public void testToString() {
        team.addMember(collaborator1);
        team.addMember(collaborator2);

        String expected = "Members:\n" +
                "- John Doe\n" +
                "- Jane Smith\n";
        assertEquals(expected, team.toString());
    }
}

