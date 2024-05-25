package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;

/**
 * Controller class for assigning vehicles to entries.
 */
public class AssignVehicleToEntryController {
    private VehicleRepository vehicleRepository;

    /**
     * Constructor for AssignVehicleToEntryController.
     * Initializes the vehicle repository.
     */
    public AssignVehicleToEntryController() {
        this.vehicleRepository = getVehicleRepository();
    }

    /**
     * Retrieves all vehicles from the vehicle repository.
     * @return a list of all vehicles.
     */
    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    /**
     * Retrieves a specific vehicle from the vehicle repository by index.
     * @param index the index of the vehicle in the list.
     * @return the vehicle at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Vehicle getVehicles(int index) {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        if (index >= 0 && index < vehicles.size()) {
            return vehicles.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    // The following methods are commented out but may be used in the future.
    /*
    public List<Entry> getEntries() {
        return entryRepository.getEntries();
    }

    public Entry getEntries(int index) {
        List<Entry> entries = entryRepository.getEntries();
        if (index >= 0 && index < entries.size()) {
            return entries.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

   public void attributeVehicleToEntry(int choiceVehicle, int choiceEntry){
        Vehicle selectedVehicle = getVehicles(choiceVehicle);
        Entry selectedEntry = getEntries(choiceEntry);
        // Add logic to assign vehicle to entry
    }
    */

    /**
     * Retrieves the vehicle repository.
     * If the vehicle repository is null, it initializes it.
     * @return the vehicle repository.
     */
    private VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }
}