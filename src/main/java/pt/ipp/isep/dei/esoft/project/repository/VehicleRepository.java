package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;
import java.util.ArrayList;

public class VehicleRepository {
    private static VehicleRepository instance;
    private List<Vehicle> vehicles;

    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }
    public static VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return List.copyOf(vehicles);
    }

}
