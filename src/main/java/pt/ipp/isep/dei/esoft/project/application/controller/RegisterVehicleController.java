package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.time.LocalDate;

/**
 * The RegisterVehicleController class manages the registration of vehicles.
 * It interacts with the VehicleRepository and AuthenticationRepository.
 * <p>
 * This class provides methods to access these repositories, ensuring that instances are properly initialized.
 * It is responsible for handling vehicle registration tasks.
 * <p>
 * Example usage:
 * <pre>{@code
 * RegisterVehicleController controller = new RegisterVehicleController();
 * VehicleRepository vehicleRepo = controller.getVehicleRepository();
 * AuthenticationRepository authRepo = controller.getAuthenticationRepository();
 * }</pre>
 */
public class RegisterVehicleController {
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a RegisterVehicleController object.
     * Initializes the VehicleRepository and AuthenticationRepository attributes.
     */
    public RegisterVehicleController() {
        getVehicleRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructs a RegisterVehicleController object with specified repositories.
     *
     * @param authenticationRepository the authentication repository
     * @param vehicleRepository        the vehicle repository
     */
    public RegisterVehicleController(AuthenticationRepository authenticationRepository, VehicleRepository vehicleRepository) {
        this.authenticationRepository = authenticationRepository;
        this.vehicleRepository = vehicleRepository;
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

    /**
     * Creates a new vehicle with the specified attributes.
     *
     * @param brand           the brand of the vehicle
     * @param model           the model of the vehicle
     * @param tareWeight      the tare weight of the vehicle
     * @param grossWeight     the gross weight of the vehicle
     * @param currentKm       the current mileage of the vehicle
     * @param registerDate    the registration date of the vehicle
     * @param acquisitionDate the acquisition date of the vehicle
     * @param checkUpFrequency the check-up frequency of the vehicle
     * @return the newly created vehicle
     */
    public Vehicle createVehicle(String brand, String model, double tareWeight, double grossWeight, double currentKm,
                                 LocalDate registerDate, LocalDate acquisitionDate, double checkUpFrequency) {
        return new Vehicle(brand, model, tareWeight, grossWeight, currentKm, registerDate, acquisitionDate,
                checkUpFrequency);
    }
}
