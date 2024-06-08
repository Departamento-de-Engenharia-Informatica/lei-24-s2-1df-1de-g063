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

    // Add more tests as needed
}