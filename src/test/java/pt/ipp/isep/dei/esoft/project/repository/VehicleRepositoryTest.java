package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryTest {

    @Test
    void ensureVehicleRepositoryIsSingleton() {
        VehicleRepository instance1 = VehicleRepository.getInstance();
        VehicleRepository instance2 = VehicleRepository.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void ensureVehicleIsAddedSuccessfully() {
        VehicleRepository vehicleRepository = VehicleRepository.getInstance();
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                null, null, 10000.0);
        vehicleRepository.addVehicle(vehicle);
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        assertTrue(vehicles.contains(vehicle));
    }

    @Test
    void ensureVehicleListIsImmutable() {
        VehicleRepository vehicleRepository = VehicleRepository.getInstance();
        assertThrows(UnsupportedOperationException.class,
                () -> vehicleRepository.getVehicles().add(new Vehicle("Toyota", "Corolla", 1200.0, 1500.0,
                        50000.0, null, null, 10000.0)));
    }

    @Test
    void ensureGetVehiclesReturnsCorrectList() {
        VehicleRepository vehicleRepository = VehicleRepository.getInstance();
        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                null, null, 10000.0);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", 1100.0, 1400.0, 60000.0,
                null, null, 12000.0);
        vehicleRepository.addVehicle(vehicle1);
        vehicleRepository.addVehicle(vehicle2);
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.contains(vehicle1));
        assertTrue(vehicles.contains(vehicle2));
    }
}
