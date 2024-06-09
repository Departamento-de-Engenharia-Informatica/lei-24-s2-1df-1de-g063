# US029 - As a Collaborator, I want to record the completion of a task

## 4. Tests

**Test 1:** Ensures that an entry can be added to the repository.

    @Test
    void testAddEntry() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
    
        // Execute
        repository.addEntry(entry);
    
        // Assert
        List<Entry> entries = repository.getEntries();
        assertTrue(entries.contains(entry), "Entry should be added to the repository");
    }


**Test 2:** Ensures that entries can be retrieved from the repository.

    @Test
    void testGetEntries() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        repository.addEntry(entry);
        
        // Execute
        List<Entry> entries = repository.getEntries();
        
        // Assert
        assertTrue(entries.contains(entry), "Entries should be retrieved from the repository");
    }



**Test 3:** Ensures that an entry can be updated in the repository.

    @Test
    void testUpdateEntry() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        repository.addEntry(entry);
    
        // Update the properties of the existing entry
        entry.setGreenSpace(new GreenSpace("Green Space 2",2, Size.Medium_Size,"Francisco"));
        entry.setStatus(Status.completed);
    
        // Execute
        repository.updateEntry(entry);
    
        // Assert
        List<Entry> entries = repository.getEntries();
        assertTrue(entries.contains(entry), "Entry should be updated in the repository");
    }



**Test 4:**  Ensures that entries with a specified status can be retrieved from the repository.

    @Test
    void testGetEntriesWithStatus() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry1 = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        Entry entry2 = new Entry("Task 2", Urgency.Low, 3, new GreenSpace("Green Space 2",2, Size.Medium_Size,"Francisco"), Status.completed);
        repository.addEntry(entry1);
        repository.addEntry(entry2);
    
        // Execute
        List<Entry> entries = repository.getEntriesWithStatus(Status.completed);
    
        // Assert
        assertTrue(entries.contains(entry2), "Entries with the specified status should be retrieved from the repository");
        assertFalse(entries.contains(entry1), "Entries with a different status should not be retrieved from the repository");
    }


**Test 5:** Ensures that the singleton instance of AgendaRepository is correctly retrieved.

    @Test
    void testGetInstance() {
        // Execute
        AgendaRepository instance1 = AgendaRepository.getInstance();
        AgendaRepository instance2 = AgendaRepository.getInstance();
    
        // Assert
        assertSame(instance1, instance2, "Instances should be the same");
    }



**Test 6:** Ensures that an entry can be retrieved from the repository by index.

    @Test
    void testGetEntriesByIndex() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        repository.addEntry(entry);
    
        // Execute
        Entry result = repository.getEntries(0);
    
        // Assert
        assertEquals(entry, result, "Entry should be retrieved from the repository by index");
    }


**Test 7:** Ensures that an exception is thrown when retrieving an entry by an out-of-bounds index.

    @Test
    void testGetEntriesByIndexOutOfBounds() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
    
        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> repository.getEntries(0), "Should throw IndexOutOfBoundsException for invalid index");
    }



**Test 8:** Ensures that the agenda can be retrieved from the repository.

    @Test
    void testGetAgenda() {
        // Setup
        AgendaRepository repository = new AgendaRepository();
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        repository.addEntry(entry);
    
        // Execute
        List<Entry> entries = repository.getAgenda();
    
        // Assert
        assertTrue(entries.contains(entry), "Agenda should be retrieved from the repository");
    }



## 5. Construction (Implementation)

### Class TaskAssignedToCollaboratorController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class responsible for managing tasks assigned to a collaborator.
 */
public class TaskAssignedToCollaboratorController {
    private AgendaRepository agendaRepository;
    private String managerName;

    /**
     * Constructs a TaskAssignedToCollaboratorController with the specified manager name.
     *
     * @param managerName the name of the manager
     */
    public TaskAssignedToCollaboratorController(String managerName) {
        this.agendaRepository = Repositories.getInstance().getAgendaRepository(); // Assuming AgendaRepository is a singleton
        this.managerName = managerName;
    }

    /**
     * Retrieves a list of entries between the specified start and end dates,
     * filtered by status and assigned team member's name.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @param status    the status of the entries to filter by
     * @param name      the name of the team member
     * @return a list of entries matching the criteria
     */
    public List<Entry> getEntriesBetweenDates(LocalDate startDate, LocalDate endDate, String status, String name) {
        return agendaRepository.getEntries().stream()
                .filter(entry -> entry.getStatus() == Status.valueOf(status))
                .filter(entry -> entry.getTeam().getMembers().stream()
                        .anyMatch(member -> member.getName().equals(name)))
                .filter(entry -> !entry.getStartDate().isBefore(startDate) && !entry.getEndDate().isAfter(endDate))
                .sorted(Comparator.comparing(Entry::getStartDate))
                .collect(Collectors.toList());
    }
}
```

### Class AgendaRepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AgendaRepository implements Serializable {
    private List<Entry> agenda;
    private static AgendaRepository instance;

    public AgendaRepository() {
        agenda = new ArrayList<>();
    }

    public static AgendaRepository getInstance() {
        if (instance == null) {
            instance = new AgendaRepository();
        }
        return instance;
    }

    public void addEntry(Entry entry) {
        agenda.add(entry);
    }

    public List<Entry> getEntries() {
        return List.copyOf(agenda);
    }

    public Entry getEntries(int index) {
        if (index >= 0 && index < agenda.size()) {
            return agenda.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    public List<Entry> getAgenda() {
        return List.copyOf(agenda);
    }

    public void updateEntry(Entry updatedEntry) {
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).equals(updatedEntry)) {
                agenda.set(i, updatedEntry);
                return;
            }
        }
    }

    public List<Entry> getEntriesWithStatus(Status status) {
        return  getEntries().stream()
                .filter(entry -> entry.getStatus() == Status.valueOf(String.valueOf(status)))
                .sorted(Comparator.comparing(Entry::getStatus))
                .collect(Collectors.toList());
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
Changes the status of the Entry to completed.

## 7. Observations

n/a