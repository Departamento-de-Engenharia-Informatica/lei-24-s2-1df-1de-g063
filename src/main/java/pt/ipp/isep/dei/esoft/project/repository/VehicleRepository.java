package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;
import java.util.ArrayList;

public class VehicleRepository {
    private final List<Vehicle> vehicles;
    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }

}
