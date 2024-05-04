package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;


import java.time.LocalDate;

public class RegisterVehicleController {
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterVehicleController(){
        this.vehicleRepository = VehicleRepository.getInstance();
        getAuthenticationRepository();
    }

    public RegisterVehicleController(VehicleRepository vehicleRepository,
                                     AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    public VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();

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


    public Vehicle createVehicle(String brand,String model,double tareWeight,double grossWeight,double currentKm,LocalDate registerDate,LocalDate acquisitionDate,double checkUpFrequency) {
        return new Vehicle(brand,model,tareWeight,grossWeight,currentKm,registerDate,acquisitionDate,checkUpFrequency);
    }

}
