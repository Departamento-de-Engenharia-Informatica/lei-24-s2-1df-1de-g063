package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The VehicleNeedingCheckUpController class manages vehicles needing check-up.
 * It interacts with the VehicleRepository and AuthenticationRepository.
 * <p>
 * This class provides methods to access the vehicle repository and retrieve vehicles needing check-up.
 * <p>
 * Example usage:
 * <pre>{@code
 * VehicleNeedingCheckUpController controller = new VehicleNeedingCheckUpController();
 * VehicleRepository vehicleRepo = controller.getVehicleRepository();
 * AuthenticationRepository authRepo = controller.getAuthenticationRepository();
 * }</pre>
 */
public class VehicleNeedingCheckUpController {
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a VehicleNeedingCheckUpController object.
     * Initializes the VehicleRepository and AuthenticationRepository attributes.
     */
    public VehicleNeedingCheckUpController() {
        this.vehicleRepository = VehicleRepository.getInstance();
        getAuthenticationRepository();
    }

    /**
     * Constructs a VehicleNeedingCheckUpController object with specified repositories.
     *
     * @param vehicleRepository      the vehicle repository
     * @param authenticationRepository the authentication repository
     */
    public VehicleNeedingCheckUpController(VehicleRepository vehicleRepository,
                                           AuthenticationRepository authenticationRepository) {
        this.vehicleRepository = vehicleRepository;
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the vehicle repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the vehicle repository
     */
    public VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    /**
     * Retrieves a list of vehicles needing check-up.
     *
     * @return the list of vehicles needing check-up
     */
    public List<Vehicle> getVehiclesNeedingCheckUp() {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        List<Vehicle> vehiclesNeedingCheckUp = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            double currentKm = vehicle.getCurrentKm();
            double checkUpFrequency = vehicle.getCheckUpFrequency();
            double lastMaintenanceKm = vehicle.getLastMaintenanceKm();

            if (currentKm - lastMaintenanceKm >= checkUpFrequency) {
                vehiclesNeedingCheckUp.add(vehicle);
            }
        }

        return vehiclesNeedingCheckUp;
    }

    /**
     * Retrieves the authentication repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
}
