package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.MaintenanceRegistrationController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterVehicleController;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MaintenanceRegistrationUI implements Runnable{
    Scanner scan = new Scanner(System.in);

    private final MaintenanceRegistrationController controller;
    private final VehicleRepository vehicleRepository;
    private String brand;
    private String model;
    private String maintenance;

    public MaintenanceRegistrationUI() {
        controller = new MaintenanceRegistrationController();
        vehicleRepository = VehicleRepository.getInstance();
    }

    private MaintenanceRegistrationController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\n\n--- Vehicle Maintenance Result ------------------------");
        requestData();
        submitData();
    }

    private void requestData() {
        brand = requestBrand();
        model = requestModel();
        maintenance = requestMaintenance();
    }
    private String requestBrand(){
        System.out.println("Brand: ");
        return scan.nextLine();
    }
    private String requestModel(){
        System.out.println("Model: ");
        return scan.nextLine();
    }
    private String requestMaintenance() {
        System.out.println("Maintenance: ");
        return scan.nextLine();
    }

    private void submitData() {
        brand = requestBrand();
        model = requestModel();
        int index = controller.findVehicle(brand,model);

        Vehicle selectedVehicle = vehicleRepository.getVehicles().get(index);

        selectedVehicle.setMaintenance(maintenance);

        System.out.println(selectedVehicle.getMaintenance());
    }

}
