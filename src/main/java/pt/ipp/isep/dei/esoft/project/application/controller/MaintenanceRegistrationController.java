package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


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
    public int findVehicle(String brand,String model) {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        int contador = 0;
        int index = 0;

        for(Vehicle vehicle : vehicles) {
            if(vehicle.getBrand().equals(brand)){
                if(vehicle.getModel().equals(model)){
                    index = contador;
                }
            }
            contador++;
        }
        return index;
    }


    private Employee getEmployeeFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }
}
