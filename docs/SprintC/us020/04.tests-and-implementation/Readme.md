# US020 - As a Green Space Manager (GSM), I want to register a green space.

## 4. Tests

**Test 1:** Ensures that a Vehicle object is instantiated correctly with all its properties set to the expected values.

    @Test
    void ensureVehicleIsCreatedSuccessfully() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
    }


**Test 2:** Ensures that when a Vehicle object is initially created, its maintenance status is null.

    @Test
    void ensureMaintenanceIsNullInitially() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertNull(vehicle.getMaintenance());
    }


**Test 3:** Verifies that when a Vehicle object is first created, its last maintenance kilometer reading is initially set to zero.

    @Test
    void ensureLastMaintenanceKmIsInitiallyZero() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals(0.0, vehicle.getLastMaintenanceKm());
    }


**Test 4:** Confirms that the getBrand() method of a Vehicle object returns the correct brand name, which is "Toyota" in this case.

    @Test
    void ensureGetBrandReturnsCorrectValue() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals("Toyota", vehicle.getBrand());
    }


**Test 5:** Ensures that the getCurrentKm() method of a Vehicle object returns the correct current kilometers.

    @Test
    void ensureGetCurrentKmReturnsCorrectValue() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals(50000.0, vehicle.getCurrentKm());
    }


**Test 6:** Verifies that the getCheckUpFrequency() method of a Vehicle object returns the correct value.

    @Test
    void ensureGetCheckUpFrequencyReturnsCorrectValue() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        assertEquals(10000.0, vehicle.getCheckUpFrequency());
    }

**Test 7:** Ensures that when the setMaintenance() method is called on a Vehicle object with the argument "Regular checkup".

    @Test
    void ensureSetMaintenanceUpdatesMaintenanceCorrectly() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        vehicle.setMaintenance("Regular checkup");
        assertEquals("Regular checkup", vehicle.getMaintenance());
    }


**Test 8:** Verifies that when the setLastMaintenanceKm() method is called on a Vehicle object with the argument 55000.0

    @Test
    void ensureSetMaintenanceUpdatesMaintenanceCorrectly() {
        LocalDate registerDate = LocalDate.of(2022, 1, 1);
        LocalDate acquisitionDate = LocalDate.of(2022, 1, 1);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1200.0, 1500.0, 50000.0,
                registerDate, acquisitionDate, 10000.0);
        vehicle.setMaintenance("Regular checkup");
        assertEquals("Regular checkup", vehicle.getMaintenance());
    }


## 5. Construction (Implementation)

### Class VehicleNeedingCheckUpController

```java
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
```

### Class VehicleRepository

```java
public class VehicleRepository {
    private static VehicleRepository instance;
    private final List<Vehicle> vehicles;

    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }

    public static VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return List.copyOf(vehicles);
    }

}

```
### Class Vehicle

```java
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
```

## 6. Integration and Demo
Simulate how the VehicleNeedingCheckUpController interacts with the VehicleRepository to retrieve vehicles that need check-up:

* We instantiate the VehicleRepository.
* We create a VehicleNeedingCheckUpController with the repositories.
* We add a vehicle to the repository and set its last maintenance kilometer reading.
* We call the getVehiclesNeedingCheckUp() method of the controller to retrieve vehicles needing check-up.
* We print the vehicles needing check-up.

## 7. Observations

n/a