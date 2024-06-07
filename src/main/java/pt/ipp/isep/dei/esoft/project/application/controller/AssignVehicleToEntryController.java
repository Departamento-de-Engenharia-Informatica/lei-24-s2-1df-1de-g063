package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;

/**
 * Controller class for assigning vehicles to entries.
 */
public class AssignVehicleToEntryController {
    private VehicleRepository vehicleRepository;
    private final AgendaRepository agendaRepositories;

    /**
     * Constructor for AssignVehicleToEntryController.
     * Initializes the vehicle repository.
     */
    public AssignVehicleToEntryController() {
        this.vehicleRepository = getVehicleRepository();
        this.agendaRepositories = Repositories.getInstance().getAgendaRepository();
    }

    /**
     * Retrieves all vehicles from the vehicle repository.
     * @return a list of all vehicles.
     */
    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }


    // The following methods are commented out but may be used in the future.

    public List<Entry> getEntries() {
        return agendaRepositories.getEntries();
    }



   public void attributeVehicleToEntry(int choiceVehicle, int choiceEntry){
        Vehicle selectedVehicle = vehicleRepository.getVehicles(choiceVehicle);
        Entry selectedEntry = agendaRepositories.getEntries(choiceEntry);
        selectedEntry.addVehicle(selectedVehicle);

    }

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