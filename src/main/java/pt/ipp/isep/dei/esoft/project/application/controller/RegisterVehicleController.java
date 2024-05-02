package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.isep.lei.esoft.auth.domain.model.Email;


import java.time.LocalDate;
import java.util.Optional;

public class RegisterVehicleController {
    private OrganizationRepository organizationRepository;
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterVehicleController(){
        getVehicleRepository();
        getAuthenticationRepository();
        getOrganizationRepository();
    }

    public RegisterVehicleController(OrganizationRepository organizationRepository,
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

    public Optional<Vehicle> RegisterVehicle(String brand, String model, double tareWeight,
                                             double grossWeight, double currentKm, LocalDate registerDate,
                                             LocalDate acquisitionDate, String checkUpFrequency) {
        Employee employee = getEmployeeFromSession();
        Optional<Organization> organization = getOrganizationRepository().getOrganizationByEmployee(employee);

        Optional<Vehicle> newVehicle = Optional.empty();

        if (organization.isPresent()) {
            newVehicle = organization.get()
                    .createVehicle(brand, model, tareWeight, grossWeight, currentKm, registerDate,
                            acquisitionDate, checkUpFrequency, employee);
        }
        return newVehicle;
    }

    private Employee getEmployeeFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }
}
