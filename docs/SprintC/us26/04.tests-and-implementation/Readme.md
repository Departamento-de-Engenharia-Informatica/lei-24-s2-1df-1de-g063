# US26 - As a GSM, I want to assign one or more vehicles to an entry in the Agenda.

## 4. Tests

**Test 1:** Ensures that a Vehicle object can be added to an Entry object.

    @Test
    void testAddVehicle() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1000, 2000, 10000, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000);

        // Execute
        entry.addVehicle(vehicle);

        // Assert
        List<Vehicle> vehicles = entry.getVehicles();
        assertTrue(vehicles.contains(vehicle), "Vehicle should be added to the entry");
    }


**Test 2:** Ensures that the isVehicleAssigned() method of an Entry object returns true when the vehicle is assigned to the entry.

    @Test
    void testIsVehicleAssigned() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1000, 2000, 10000, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000);
        entry.addVehicle(vehicle);

        // Execute & Assert
        assertTrue(entry.isVehicleAssigned(vehicle), "Vehicle should be assigned to the entry");
    }



## 5. Construction (Implementation)

### Class AssignVehicleToEntryController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VehicleRepository;
import pt.ipp.isep.dei.esoft.project.domain.Vehicle;

import java.util.List;

/**
 * Controller class for assigning vehicles to entries.
 */
public class AssignVehicleToEntryController {
    private VehicleRepository vehicleRepository;
    private final AgendaRepository agendaRepositories;

    /**
     * Constructor for AssignVehicleToEntryController.
     * Initializes the vehicle repository.
     */
    public AssignVehicleToEntryController() {
        this.vehicleRepository = getVehicleRepository();
        this.agendaRepositories = Repositories.getInstance().getAgendaRepository();
    }

    /**
     * Retrieves all vehicles from the vehicle repository.
     * @return a list of all vehicles.
     */
    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }


    // The following methods are commented out but may be used in the future.

    public List<Entry> getEntries() {
        return agendaRepositories.getEntries();
    }



   public void attributeVehicleToEntry(int choiceVehicle, int choiceEntry){
        Vehicle selectedVehicle = vehicleRepository.getVehicles(choiceVehicle);
        Entry selectedEntry = agendaRepositories.getEntries(choiceEntry);
        selectedEntry.addVehicle(selectedVehicle);

    }

    /**
     * Retrieves the vehicle repository.
     * If the vehicle repository is null, it initializes it.
     * @return the vehicle repository.
     */
    private VehicleRepository getVehicleRepository() {
        if (vehicleRepository == null) {
            Repositories repositories = Repositories.getInstance();
            vehicleRepository = repositories.getVehicleRepository();
        }
        return vehicleRepository;
    }
}
```
### Class Entry

```java
package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Entry implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String task;
    private final Urgency urgency;
    private final int duration;
    private GreenSpace greenSpace;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Team team;

    private List<Vehicle> vehicles;

    public Entry(String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        this.task = task;
        this.urgency = urgency;
        this.duration = duration;
        this.greenSpace = greenSpace;
        this.status = status;
        this.vehicles = new ArrayList<>();
    }
    public boolean isVehicleAssigned(Vehicle vehicle){
        return getVehicles().contains(vehicle);
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate date){
        this.startDate=date;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void getVehicle(int index){
        vehicles.get(index);
    }

    public List<Vehicle> getVehicles(){
        return List.copyOf(vehicles);
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate date){
        this.endDate=date;
    }

    public Status getStatus() {
        return status;
    }

    public String getTask() {
        return task;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public int getDuration() {
        return duration;
    }

    public GreenSpace getGreenSpace(){
        return greenSpace;
    }

    public void setGreenSpace(GreenSpace greenSpace) {
        this.greenSpace = greenSpace;
    }

    public void setStatus(Status status) {this.status = status;}

    @Override
    public String toString() {
        String teamString = (team != null) ? team.toString() : "No team assigned";
        return "Entry{" +
                "team=" + teamString +
                ", vehicles=" + vehicles +
                ", task='" + task + '\'' +
                ", urgency=" + urgency +
                ", duration=" + duration +
                ", greenSpace=" + greenSpace +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

```

## 6. Integration and Demo

Simulate how the `AssignVehicleToEntryController` interacts with the `VehicleRepository` and `AgendaRepository` to assign vehicles to entries:

1. We instantiate the `Repositories` class.
2. We create an `AssignVehicleToEntryController` with the repositories.
3. We add a vehicle to the `VehicleRepository` and an entry to the `AgendaRepository`.
4. We call the `attributeVehicleToEntry()` method of the controller to assign the vehicle to the entry.
5. We print the entry to verify that the vehicle has been assigned.
## 7. Observations

n/a