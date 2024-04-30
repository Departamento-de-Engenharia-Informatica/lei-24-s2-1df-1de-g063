package pt.ipp.isep.dei.esoft.project.domain;

public class Vehicle {
    private String brand;
    private String model;
    private float tareWeight;
    private float grossWeight;
    private float currentKm;
    private String registerDate;
    private String acquisitionDate;
    private String checkUpFrequency;

    public Vehicle(String brand,String model,float tareWeight,float grossWeight,float currentKm,String registerDate,String acquisitionDate) {
        this.brand = brand;
        this.model = model;
        this.tareWeight = tareWeight;
        this.grossWeight = grossWeight;
        this.currentKm = currentKm;
        this.registerDate = registerDate;
        this.acquisitionDate = acquisitionDate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public float getTareWeight() {
        return tareWeight;
    }

    public float getGrossWeight() {
        return grossWeight;
    }

    public float getCurrentKm() {
        return currentKm;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public String getCheckUpFrequency() {
        return checkUpFrequency;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTareWeight(float tareWeight) {
        this.tareWeight = tareWeight;
    }

    public void setGrossWeight(float grossWeight) {
        this.grossWeight = grossWeight;
    }

    public void setCurrentKm(float currentKm) {
        this.currentKm = currentKm;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public void setCheckUpFrequency(String checkUpFrequency) {
        this.checkUpFrequency = checkUpFrequency;
    }
}