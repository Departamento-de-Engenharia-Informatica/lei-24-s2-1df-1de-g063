package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

public class VehicleNeedingCheckUpController {
    private VehicleRepository vehicleRepository;
    private AuthenticationRepository authenticationRepository;

    public VehicleNeedingCheckUpController(){
        this.vehicleRepository = VehicleRepository.getInstance();
        getAuthenticationRepository();
    }

    public VehicleNeedingCheckUpController(VehicleRepository vehicleRepository,
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

    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();

            //Get the AuthenticationRepository
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

}
