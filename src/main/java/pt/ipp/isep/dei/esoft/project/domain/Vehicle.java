package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Vehicle {
    private String brand;
    private String model;
    private double tareWeight;
    private double grossWeight;
    private double currentKm;
    private LocalDate registerDate;
    private LocalDate acquisitionDate;
    private String checkUpFrequency;
    private String maintenance;

    public Vehicle(String brand, String model, double tareWeight, double grossWeight, double currentKm,
                   LocalDate registerDate, LocalDate acquisitionDate, String checkUpFrequency) {
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

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand,model,tareWeight,grossWeight,currentKm,registerDate,acquisitionDate,checkUpFrequency);
    }
    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Vehicle clone() {
        return new Vehicle(this.brand,this.model,this.tareWeight,this.grossWeight,this.currentKm,this.registerDate,this.acquisitionDate,this.checkUpFrequency);
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