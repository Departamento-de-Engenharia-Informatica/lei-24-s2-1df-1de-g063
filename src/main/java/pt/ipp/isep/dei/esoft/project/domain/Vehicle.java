package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;

public class Vehicle {
    private final String brand;
    private final String model;
    private final double tareWeight;
    private final double grossWeight;
    private double currentKm;
    private final LocalDate registerDate;
    private final LocalDate acquisitionDate;
    private final double checkUpFrequency;
    private double lastMaintenanceKm = 0;
    private String maintenance;

    public Vehicle(String brand, String model, double tareWeight, double grossWeight, double currentKm,
                   LocalDate registerDate, LocalDate acquisitionDate, double checkUpFrequency) {
        this.brand = brand;
        this.model = model;
        this.tareWeight = tareWeight;
        this.grossWeight = grossWeight;
        this.currentKm = currentKm;
        this.registerDate = registerDate;
        this.acquisitionDate = acquisitionDate;
        this.checkUpFrequency = checkUpFrequency;
    }


    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public double getLastMaintenanceKm() {
        return lastMaintenanceKm;
    }

    public void setLastMaintenanceKm(double lastMaintenanceKm) {
        this.lastMaintenanceKm = lastMaintenanceKm;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getCurrentKm(){
        return currentKm;
    }

    public double getCheckUpFrequency() {
        return checkUpFrequency;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", tareWeight=" + tareWeight +
                ", grossWeight=" + grossWeight +
                ", currentKm=" + currentKm +
                ", registerDate='" + registerDate + '\'' +
                ", acquisitionDate='" + acquisitionDate + '\'' +
                ", checkUpFrequency='" + checkUpFrequency + '\'' +
                '}';
    }
}