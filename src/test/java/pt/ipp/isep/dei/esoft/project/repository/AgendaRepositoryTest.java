package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

class AgendaRepositoryTest {

    @Test
    void testAddEntry() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);

        // Execute
        repository.addEntry(entry);

        // Assert
        List<Entry> entries = repository.getEntries();
        assertTrue(entries.contains(entry), "Entry should be added to the repository");
    }

    @Test
    void testGetEntries() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        repository.addEntry(entry);

        // Execute
        List<Entry> entries = repository.getEntries();

        // Assert
        assertTrue(entries.contains(entry), "Entries should be retrieved from the repository");
    }

    @Test
    
void testUpdateEntry() {
    // Setup
    AgendaRepository repository = new AgendaRepository();
    Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
    repository.addEntry(entry);

    // Update the properties of the existing entry
    entry.setGreenSpace(new GreenSpace("Green Space 2",2, Size.Medium_Size,"Francisco"));
    entry.setStatus(Status.completed);

    // Execute
    repository.updateEntry(entry);

    // Assert
    List<Entry> entries = repository.getEntries();
    assertTrue(entries.contains(entry), "Entry should be updated in the repository");
}

    @Test
    void testGetEntriesWithStatus() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry1 = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        Entry entry2 = new Entry("Task 2", Urgency.Low, 3, new GreenSpace("Green Space 2",2, Size.Medium_Size,"Francisco"), Status.completed);
        repository.addEntry(entry1);
        repository.addEntry(entry2);

        // Execute
        List<Entry> entries = repository.getEntriesWithStatus(Status.completed);

        // Assert
        assertTrue(entries.contains(entry2), "Entries with the specified status should be retrieved from the repository");
        assertFalse(entries.contains(entry1), "Entries with a different status should not be retrieved from the repository");
    }

    // Add more tests as needed
}