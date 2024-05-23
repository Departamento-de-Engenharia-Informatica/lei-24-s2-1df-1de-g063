package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;

public class AssignVehicleToEntryController {
    private VehicleRepository vehicleRepository;

    public AssignVehicleToEntryController() {
        this.vehicleRepository = getVehicleRepository();
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    // Overloaded method to get a specific vehicle by index
    public Vehicle getVehicles(int index) {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        if (index >= 0 && index < vehicles.size()) {
            return vehicles.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    // Uncomment and adjust when entry logic is available
    // public List<Entry> getEntries() {
    //     return entryRepository.getEntries();
    // }

    // Overloaded method to get a specific entry by index
    // public Entry getEntries(int index) {
    //     List<Entry> entries = entryRepository.getEntries();
    //     if (index >= 0 && index < entries.size()) {
    //         return entries.get(index);
    //     } else {
    //         throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    //     }
    // }

    // Uncomment and adjust when entry logic is available
    // public void attributeVehicleToEntry(Vehicle selectedVehicle, Entry selectedEntry) {
    //     // Attribution logic
    // }

    private VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }
}

