package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

/**
 * The MaintenanceRegistrationController class manages the registration of maintenance tasks for vehicles.
 * It interacts with the VehicleRepository and AuthenticationRepository.
 * <p>
 * This class provides methods to access the VehicleRepository and AuthenticationRepository,
 * ensuring that instances of these repositories are properly initialized.
 * It is responsible for handling maintenance registration tasks.
 * <p>
 * Example usage:
 * <pre>{@code
 * MaintenanceRegistrationController controller = new MaintenanceRegistrationController();
 * VehicleRepository vehicleRepo = controller.getVehicleRepository();
 * AuthenticationRepository authRepo = controller.getAuthenticationRepository();
 * }</pre>
 */
public class MaintenanceRegistrationController {
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a MaintenanceRegistrationController object.
     * Initializes the AuthenticationRepository attribute.
     */
    public MaintenanceRegistrationController() {
        getAuthenticationRepository();
    }

    /**
     * Constructs a MaintenanceRegistrationController object with specified repositories.
     *
     * @param vehicleRepository       the vehicle repository
     * @param authenticationRepository the authentication repository
     */
    public MaintenanceRegistrationController(VehicleRepository vehicleRepository,
                                             AuthenticationRepository authenticationRepository) {
        this.vehicleRepository = VehicleRepository.getInstance();
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
