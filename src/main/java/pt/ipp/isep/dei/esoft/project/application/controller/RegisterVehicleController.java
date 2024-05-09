package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.time.LocalDate;

public class RegisterVehicleController {
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterVehicleController(){
        getVehicleRepository();
        getAuthenticationRepository();
    }

    public RegisterVehicleController(AuthenticationRepository authenticationRepository, VehicleRepository vehicleRepository) {
        this.authenticationRepository = authenticationRepository;
        this.vehicleRepository = vehicleRepository;
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
