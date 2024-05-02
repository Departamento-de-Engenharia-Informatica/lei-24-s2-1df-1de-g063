package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class MaintenanceRegistrationController {

    private OrganizationRepository organizationRepository;
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    public MaintenanceRegistrationController(OrganizationRepository organizationRepository, OrganizationRepository organizationRepository1, OrganizationRepository organizationRepository2){
        getVehicleRepository();
        getAuthenticationRepository();
        getOrganizationRepository();
    }

    //Allows receiving the repositories as parameters for testing purposes
    public MaintenanceRegistrationController(OrganizationRepository organizationRepository,
                                             VehicleRepository vehicleRepository,
                                             AuthenticationRepository authenticationRepository) {
        this.organizationRepository = organizationRepository;
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

    private OrganizationRepository getOrganizationRepository() {
        if (organizationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;

    }

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

//    public Optional<Vehicle> MaintenanceRegistration(String brand,String model,double tareWeight,double grossWeight,double currentKm,String registerDate,String acquisitionDate) {
//
//    }

    private List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        return vehicles;
    }
}
