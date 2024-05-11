package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkillTest {

    @Test
    void ensureSkillIsCreatedSuccessfully() {
        Skill skill = new Skill("Java Programming");
        assertEquals("Java Programming", skill.getName());
    }

    @Test
    void ensureSkillNameIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Skill(null));
    }

    @Test
    void ensureSkillToStringReturnsName() {
        Skill skill = new Skill("Java Programming");
        assertEquals("Java Programming", skill.toString());
    }

    @Test
    void testEqualsSameObject() {
        Skill skill = new Skill("Java Programming");
        assertEquals(skill, skill);
    }

    @Test
    void testEqualsDifferentClass() {
        Skill skill = new Skill("Java Programming");
        assertNotEquals(skill, new Object());
    }

    @Test
    void testEqualsNull() {
        Skill skill = new Skill("Java Programming");
        assertNotEquals(skill, null);
    }

    @Test
    void testEqualsDifferentObject() {
        Skill skill1 = new Skill("Java Programming");
        Skill skill2 = new Skill("Python Programming");
        assertNotEquals(skill1, skill2);
    }

    @Test
    void testEqualsSameObjectDifferentName() {
        Skill skill1 = new Skill("Java Programming");
        Skill skill2 = new Skill("Java Programming Advanced");
        assertNotEquals(skill1, skill2);
    }
}
