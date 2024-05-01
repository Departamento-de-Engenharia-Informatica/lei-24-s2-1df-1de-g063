package pt.ipp.isep.dei.esoft.project.domain;

public class Vehicle {
    private String brand;
    private String model;
    private double tareWeight;
    private double grossWeight;
    private double currentKm;
    private String registerDate;
    private String acquisitionDate;
    private String checkUpFrequency;
    private String maintenance;

    public Vehicle(String brand,String model,double tareWeight,double grossWeight,double currentKm,String registerDate,String acquisitionDate) {
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