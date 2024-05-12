package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;

/**
 * The Vehicle class represents a vehicle used in a project.
 * Each vehicle has various attributes such as brand, model, weight, mileage, and maintenance details.
 */
public class Vehicle {
    private final String brand; // The brand of the vehicle.
    private final String model; // The model of the vehicle.
    private final double tareWeight; // The weight of the vehicle without cargo.
    private final double grossWeight; // The weight of the vehicle with cargo.
    private double currentKm; // The current mileage of the vehicle.
    private final LocalDate registerDate; // The date when the vehicle was registered.
    private final LocalDate acquisitionDate; // The date when the vehicle was acquired.
    private final double checkUpFrequency; // The frequency at which the vehicle requires check-ups.
    private double lastMaintenanceKm = 0; // The mileage at the last maintenance.
    private String maintenance; // Details of the last maintenance performed on the vehicle.

    /**
     * Constructs a new Vehicle with the specified attributes.
     *
     * @param brand            The brand of the vehicle.
     * @param model            The model of the vehicle.
     * @param tareWeight       The weight of the vehicle without cargo.
     * @param grossWeight      The weight of the vehicle with cargo.
     * @param currentKm        The current mileage of the vehicle.
     * @param registerDate     The date when the vehicle was registered.
     * @param acquisitionDate  The date when the vehicle was acquired.
     * @param checkUpFrequency The frequency at which the vehicle requires check-ups.
     */
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

    /**
     * Gets the details of the last maintenance performed on the vehicle.
     *
     * @return Details of the last maintenance.
     */
    public String getMaintenance() {
        return maintenance;
    }

    /**
     * Sets the details of the last maintenance performed on the vehicle.
     *
     * @param maintenance Details of the last maintenance.
     */
    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    /**
     * Gets the mileage at the last maintenance of the vehicle.
     *
     * @return The mileage at the last maintenance.
     */
    public double getLastMaintenanceKm() {
        return lastMaintenanceKm;
    }

    /**
     * Sets the mileage at the last maintenance of the vehicle.
     *
     * @param lastMaintenanceKm The mileage at the last maintenance.
     */
    public void setLastMaintenanceKm(double lastMaintenanceKm) {
        this.lastMaintenanceKm = lastMaintenanceKm;
    }

    /**
     * Gets the brand of the vehicle.
     *
     * @return The brand of the vehicle.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return The model of the vehicle.
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the current mileage of the vehicle.
     *
     * @return The current mileage of the vehicle.
     */
    public double getCurrentKm() {
        return currentKm;
    }

    /**
     * Gets the frequency at which the vehicle requires check-ups.
     *
     * @return The check-up frequency.
     */
    public double getCheckUpFrequency() {
        return checkUpFrequency;
    }

    /**
     * Returns a string representation of the vehicle.
     *
     * @return A string representation of the vehicle.
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", tareWeight=" + tareWeight +
                ", grossWeight=" + grossWeight +
                ", currentKm=" + currentKm +
                ", registerDate=" + registerDate +
                ", acquisitionDate=" + acquisitionDate +
                ", checkUpFrequency=" + checkUpFrequency +
                '}';
    }
}
