package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * The VehicleRepository class manages the storage and retrieval of vehicles.
 * It provides methods to add vehicles and retrieve a list of all vehicles.
 */
public class VehicleRepository {

    private static VehicleRepository instance;
    private final List<Vehicle> vehicles;

    /**
     * Private constructor to prevent external instantiation.
     */
    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of VehicleRepository.
     *
     * @return the instance of VehicleRepository
     */
    public static VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }

    /**
     * Adds a vehicle to the repository.
     *
     * @param vehicle the vehicle to add
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Retrieves a list of all vehicles stored in the repository.
     *
     * @return a list of all vehicles
     */
    public List<Vehicle> getVehicles() {
        // This is a defensive copy to prevent modification of the repository's internal list
        return List.copyOf(vehicles);
    }

    public Vehicle getVehicles(int index) {
        if (index >= 0 && index < vehicles.size()) {
            return vehicles.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
