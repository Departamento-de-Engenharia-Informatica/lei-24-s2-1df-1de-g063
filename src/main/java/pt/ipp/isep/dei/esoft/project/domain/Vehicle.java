package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * The Vehicle class represents a vehicle within the system.
 * It encapsulates information about the vehicle such as brand, model, weight, mileage, and maintenance details.
 * <p>
 * Example usage:
 * <pre>{@code
 * Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
 *                                LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000.0);
 * System.out.println(vehicle);
 * }</pre>
 */
public class Vehicle implements Serializable {
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

    /**
     * Constructs a Vehicle object with the specified parameters.
     *
     * @param brand           the brand of the vehicle
     * @param model           the model of the vehicle
     * @param tareWeight      the tare weight of the vehicle
     * @param grossWeight     the gross weight of the vehicle
     * @param currentKm       the current mileage of the vehicle
     * @param registerDate    the registration date of the vehicle
     * @param acquisitionDate the acquisition date of the vehicle
     * @param checkUpFrequency the frequency of vehicle check-ups
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
     * Gets the maintenance details of the vehicle.
     *
     * @return the maintenance details of the vehicle
     */
    public String getMaintenance() {
        return maintenance;
    }

    /**
     * Sets the maintenance details of the vehicle.
     *
     * @param maintenance the maintenance details to set
     */
    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    /**
     * Gets the mileage of the vehicle at the last maintenance.
     *
     * @return the mileage of the vehicle at the last maintenance
     */
    public double getLastMaintenanceKm() {
        return lastMaintenanceKm;
    }

    /**
     * Sets the mileage of the vehicle at the last maintenance.
     *
     * @param lastMaintenanceKm the mileage at the last maintenance to set
     */
    public void setLastMaintenanceKm(double lastMaintenanceKm) {
        this.lastMaintenanceKm = lastMaintenanceKm;
    }

    /**
     * Gets the brand of the vehicle.
     *
     * @return the brand of the vehicle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the current mileage of the vehicle.
     *
     * @return the current mileage of the vehicle
     */
    public double getCurrentKm(){
        return currentKm;
    }

    /**
     * Gets the frequency of check-ups for the vehicle.
     *
     * @return the check-up frequency of the vehicle
     */
    public double getCheckUpFrequency() {
        return checkUpFrequency;
    }

    /**
     * Returns a string representation of the vehicle, including its brand, model, and other details.
     *
     * @return a string representation of the vehicle
     */

    
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
