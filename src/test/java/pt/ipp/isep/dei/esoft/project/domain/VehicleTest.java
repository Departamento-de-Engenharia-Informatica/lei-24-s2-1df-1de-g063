package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void ensureVehicleIsCreatedSuccessfully() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
    }

    @Test
    void ensureMaintenanceIsNullInitially() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertNull(vehicle.getMaintenance());
    }

    @Test
    void ensureLastMaintenanceKmIsInitiallyZero() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals(0.0, vehicle.getLastMaintenanceKm());
    }

    @Test
    void ensureGetBrandReturnsCorrectValue() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals("Toyota", vehicle.getBrand());
    }

    @Test
    void ensureGetCurrentKmReturnsCorrectValue() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals(50000.0, vehicle.getCurrentKm());
    }

    @Test
    void ensureGetCheckUpFrequencyReturnsCorrectValue() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals(10000.0, vehicle.getCheckUpFrequency());
    }

    @Test
    void ensureSetMaintenanceUpdatesMaintenanceCorrectly() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        vehicle.setMaintenance("Regular checkup");
        assertEquals("Regular checkup", vehicle.getMaintenance());
    }

    @Test
    void ensureSetLastMaintenanceKmUpdatesCorrectly() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        vehicle.setLastMaintenanceKm(55000.0);
        assertEquals(55000.0, vehicle.getLastMaintenanceKm());
    }

}
