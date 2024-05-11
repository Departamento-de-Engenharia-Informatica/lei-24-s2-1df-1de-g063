package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void ensureJobIsCreatedSuccessfully() {
        Job job = new Job("Developer Job");
        assertEquals("Developer Job", job.getName());
    }

    @Test
    void ensureJobNameIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Job(null));
    }

    @Test
    void ensureJobToStringReturnsName() {
        Job job = new Job("Developer Job");
        assertEquals("Developer Job", job.toString());
    }

    @Test
    void testEqualsSameObject() {
        Job job = new Job("Developer Job");
        assertEquals(job, job);
    }

    @Test
    void testEqualsDifferentClass() {
        Job job = new Job("Developer Job");
        assertNotEquals(job, new Object());
    }

    @Test
    void testEqualsNull() {
        Job job = new Job("Developer Job");
        assertNotEquals(job, null);
    }

    @Test
    void testEqualsDifferentObject() {
        Job job1 = new Job("Developer Job");
        Job job2 = new Job("Gardener Job");
        assertNotEquals(job1, job2);
    }

    @Test
    void testEqualsSameObjectDifferentName() {
        Job job1 = new Job("Developer Job");
        Job job2 = new Job("Web Developer Job");
        assertNotEquals(job1, job2);
    }
}