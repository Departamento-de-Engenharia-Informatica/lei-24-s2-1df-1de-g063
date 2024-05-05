package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

public class MaintenanceRegistrationController {
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    public MaintenanceRegistrationController(){
        this.vehicleRepository = VehicleRepository.getInstance();
        getAuthenticationRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public MaintenanceRegistrationController(VehicleRepository vehicleRepository,
                                             AuthenticationRepository authenticationRepository) {
        this.vehicleRepository = vehicleRepository;
        this.authenticationRepository = authenticationRepository;
    }

    public VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the TaskCategoryRepository
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

}
