package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;
import java.util.ArrayList;

/**
 * The VehicleRepository class represents a repository for managing vehicles.
 * It provides methods to add and retrieve vehicles.
 */
public class VehicleRepository {
    private static VehicleRepository instance; // Singleton instance of VehicleRepository.
    private final List<Vehicle> vehicles; // List to store vehicles.

    /**
     * Constructs a new VehicleRepository with an empty list of vehicles.
     */
    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }

    /**
     * Gets the singleton instance of VehicleRepository.
     *
     * @return The singleton instance of VehicleRepository.
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
     * @param vehicle The vehicle to add.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Retrieves all vehicles from the repository.
     *
     * @return A list of all vehicles.
     */
    public List<Vehicle> getVehicles() {
        return List.copyOf(vehicles);
    }
}
