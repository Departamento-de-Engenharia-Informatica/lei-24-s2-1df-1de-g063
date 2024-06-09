package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;


class EntryTest {

    @Test
    void testAddVehicle() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1000, 2000, 10000, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000);

        // Execute
        entry.addVehicle(vehicle);

        // Assert
        List<Vehicle> vehicles = entry.getVehicles();
        assertTrue(vehicles.contains(vehicle), "Vehicle should be added to the entry");
    }

    @Test
    void testIsVehicleAssigned() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1000, 2000, 10000, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000);
        entry.addVehicle(vehicle);

        // Execute & Assert
        assertTrue(entry.isVehicleAssigned(vehicle), "Vehicle should be assigned to the entry");
    }

    @Test
    void testSetTeam() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        Team team = new Team();

        // Execute
        entry.setTeam(team);

        // Assert
        assertEquals(team, entry.getTeam(), "Team should be set to the entry");
    }

    @Test
    void testSetStartDate() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        LocalDate startDate = LocalDate.now();

        // Execute
        entry.setStartDate(startDate);

        // Assert
        assertEquals(startDate, entry.getStartDate(), "Start date should be set to the entry");
    }

    @Test
    void testSetEndDate() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        LocalDate endDate = LocalDate.now();

        // Execute
        entry.setEndDate(endDate);

        // Assert
        assertEquals(endDate, entry.getEndDate(), "End date should be set to the entry");
    }
    @Test
    void testGetTask() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals("Task 1", entry.getTask());
    }

    @Test
    void testGetUrgency() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals(Urgency.Low, entry.getUrgency());
    }

    @Test
    void testGetDuration() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals(1, entry.getDuration());
    }

    @Test
    void testGetGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco");
        Entry entry = new Entry("Task 1", Urgency.Low, 1, greenSpace, Status.pending);
        assertEquals(greenSpace, entry.getGreenSpace());
    }

    @Test
    void testSetGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco");
        Entry entry = new Entry("Task 1", Urgency.Low, 1, null, Status.pending);
        entry.setGreenSpace(greenSpace);
        assertEquals(greenSpace, entry.getGreenSpace());
    }

    @Test
    void testGetStatus() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals(Status.pending, entry.getStatus());
    }

    @Test
    void testSetStatus() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        entry.setStatus(Status.completed);
        assertEquals(Status.completed, entry.getStatus());
    }

    @Test
    void testToString() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        String expectedString = "Entry{" +
                "team=No team assigned" +
                ", vehicles=[]" +
                ", task='Task 1'" +
                ", urgency=Low" +
                ", duration=1" +
                ", greenSpace=GreenSpace{name='Green Space 1', area=1.0, size=Large_Size, manager name='Francisco'}" +
                ", status=pending" +
                ", startDate=null" +
                ", endDate=null" +
                '}';
        assertEquals(expectedString, entry.toString());
    }
}