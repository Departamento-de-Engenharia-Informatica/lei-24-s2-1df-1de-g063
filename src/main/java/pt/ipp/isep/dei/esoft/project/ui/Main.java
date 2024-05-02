package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.domain.Vehicle;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;
import java.util.Scanner;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

////---------------------------------------------------------US07------------------------------------------------------------------------------------------------------
//
//        System.out.println("Introduza o nome do veículo que quer apontar o resultado do checkup:");
//        String brandName = scan.nextLine();
//
//        System.out.println("Introduza o modelo do veículo que quer apontar o resultado do checkup:");
//        String modelName = scan.nextLine();
//
//        List<Vehicle> vehicles = vehicleRepository.getVehicles();
//
//        boolean found = false;
//        int contador = 0;
//        int index = 0;
//
//        for(Vehicle vehicle : vehicles) {
//            if(vehicle.getBrand().equals(brandName)){
//                if(vehicle.getModel().equals(modelName)){
//                    found = true;
//                    index = contador;
//                }
//            }
//            contador++;
//        }
//
//        Vehicle selectedVehicle = vehicleRepository.getVehicles().get(index);
//
//        System.out.println("Introduza o resultado do CheckUp");
//        String checkUpResult = scan.nextLine();
//        selectedVehicle.setMaintenance(checkUpResult);
//
//        System.out.println(selectedVehicle.getMaintenance());
//---------------------------------------------------------US08------------------------------------------------------------------------------------------------------

    }
}