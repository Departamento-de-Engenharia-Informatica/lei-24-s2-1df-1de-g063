package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollaboratorTest {

    @Test
    void ensureCollaboratorIsCreatedSuccessfully() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotNull(collaborator);
    }

    @Test
    void ensureSkillListIsMutable() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        List<Skill> skills = new ArrayList<>();
        collaborator.setSkills(skills);
        skills.add(new Skill("Java"));
        assertEquals(1, collaborator.getSkills().size());
    }

    @Test
    void testEqualsSameObject() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertEquals(collaborator, collaborator);
    }

    @Test
    void testEqualsDifferentClass() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator, new Object());
    }

    @Test
    void testEqualsNull() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator, null);
    }

    @Test
    void testEqualsDifferentObject() {
        Collaborator collaborator1 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        Collaborator collaborator2 = new Collaborator("Jane Smith", "456 Oak St", "jane.smith@example.com",
                "987554321", "cartão de cidadão", "98765432", LocalDate.of(1995, 5, 5),
                LocalDate.now(), "Tester");
        assertNotEquals(collaborator1, collaborator2);
    }

    @Test
    void testEqualsSameObjectDifferentValues() {
        Collaborator collaborator1 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123-456-7890", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        Collaborator collaborator2 = new Collaborator("John Doe", "456 Oak St", "john.doe@example.com",
                "123556789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator1, collaborator2);
    }

    @Test
    void testEqualsSameObjectSameValues() {
        Collaborator collaborator1 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        Collaborator collaborator2 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertEquals(collaborator1, collaborator2);
    }

}
