# US021 - As a GSM, I want to add a new entry to the To-Do List.

## 4. Tests

**Test 1:** Ensures that when a Vehicle object is initially created, its maintenance status is null.


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


**Test 2:** This test checks if a Vehicle object is correctly assigned to an Entry object. It asserts that the vehicle is assigned to the entry.

    @Test
    void testIsVehicleAssigned() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        Vehicle vehicle = new Vehicle("Toyota", "Corolla", 1000, 2000, 10000, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000);
        entry.addVehicle(vehicle);

        // Execute & Assert
        assertTrue(entry.isVehicleAssigned(vehicle), "Vehicle should be assigned to the entry");
    }

**Test 3:** This test checks if a Team object is correctly set to an Entry object. It asserts that the team is set to the entry.

    @Test
    void testSetTeam() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        Team team = new Team();

        // Execute
        entry.setTeam(team);

        // Assert
        assertEquals(team, entry.getTeam(), "Team should be set to the entry");
    }

**Test 4:** This test checks if a start date is correctly set to an Entry object. It asserts that the start date is set to the entry.

    @Test
    void testSetStartDate() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        LocalDate startDate = LocalDate.now();

        // Execute
        entry.setStartDate(startDate);

        // Assert
        assertEquals(startDate, entry.getStartDate(), "Start date should be set to the entry");
    }

**Test 5:**  This test checks if an end date is correctly set to an Entry object. It asserts that the end date is set to the entry.

    @Test
    void testSetEndDate() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        LocalDate endDate = LocalDate.now();

        // Execute
        entry.setEndDate(endDate);

        // Assert
        assertEquals(endDate, entry.getEndDate(), "End date should be set to the entry");
    }
**Test 6:** This test checks if the task of an Entry object is correctly retrieved. It asserts that the retrieved task matches the expected task.

    @Test
    void testGetTask() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals("Task 1", entry.getTask());
    }

**Test 7:** This test checks if the urgency of an Entry object is correctly retrieved. It asserts that the retrieved urgency matches the expected urgency.

    @Test
    void testGetUrgency() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals(Urgency.Low, entry.getUrgency());
    }

**Test 8:** This test checks if the duration of an Entry object is correctly retrieved. It asserts that the retrieved duration matches the expected duration.

    @Test
    void testGetDuration() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals(1, entry.getDuration());
    }

**Test 9:** This test checks if the green space of an Entry object is correctly retrieved. It asserts that the retrieved green space matches the expected green space.

    @Test
    void testGetGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco");
        Entry entry = new Entry("Task 1", Urgency.Low, 1, greenSpace, Status.pending);
        assertEquals(greenSpace, entry.getGreenSpace());
    }

**Test 10:** This test checks if a green space is correctly set to an Entry object. It asserts that the green space is set to the entry.

    @Test
    void testSetGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco");
        Entry entry = new Entry("Task 1", Urgency.Low, 1, null, Status.pending);
        entry.setGreenSpace(greenSpace);
        assertEquals(greenSpace, entry.getGreenSpace());
    }

**Test 11:** This test checks if the status of an Entry object is correctly retrieved. It asserts that the retrieved status matches the expected status.

    @Test
    void testGetStatus() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        assertEquals(Status.pending, entry.getStatus());
    }

**Test 12:** This test checks if a status is correctly set to an Entry object. It asserts that the status is set to the entry.

    @Test
    void testSetStatus() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        entry.setStatus(Status.completed);
        assertEquals(Status.completed, entry.getStatus());
    }

**Test 13:** This test checks if the toString method of an Entry object returns the expected string representation. It asserts that the returned string matches the expected string.

    @Test
    void testToString() {
        Entry entry = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1, Size.Large_Size,"Francisco"), Status.pending);
        String expectedString = "Entry{" +
                "team=No team assigned" +
                ", vehicles=[]" +
                ", task='Task 1'" +
                ", urgency=Low" +
                ", duration=1" +
                ", greenSpace=GreenSpace{name='Green Space 1', area=1.0, size=Large_Size, manager name='Francisco'}" +
                ", status=pending" +
                ", startDate=null" +
                ", endDate=null" +
                '}';
        assertEquals(expectedString, entry.toString());
    }


## 5. Construction (Implementation)

### Class ToDoListController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.SerializationUtil;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The ToDoListController class manages the interactions with the to-do list of entries.
 * It allows for the registration of new entries and retrieval of the to-do list.
 * <p>
 * This class provides methods to access the AuthenticationRepository and ToDoList,
 * ensuring that instances of these repositories are properly initialized.
 * It is responsible for handling to-do list entry registration and retrieval.
 */
public class ToDoListController{
    private ToDoList toDoList;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a ToDoListController object.
     * Initializes the AuthenticationRepository and ToDoList attributes.
     */
    public ToDoListController() {
        getToDoList();
        getAuthenticationRepository();
    }

    /**
     * Constructs a ToDoListController object with a specified authentication repository.
     *
     * @param authenticationRepository the authentication repository
     */
    public ToDoListController(AuthenticationRepository authenticationRepository) {
        this.toDoList = ToDoList.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the authentication repository.
     * Initializes the repository if it is not already initialized.
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Retrieves the to-do list.
     * Initializes the list if it is not already initialized.
     *
     * @return the to-do list
     */
    public ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    /**
     * Registers a new entry in the to-do list.
     *
     * @param task      the task description
     * @param urgency   the urgency of the task
     * @param duration  the estimated duration of the task
     * @param greenSpace the green space related to the task
     * @param status    the status of the task
     * @return the registered entry
     */
    public Entry registerEntry(String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        return new Entry(task, urgency, duration, greenSpace, status);
    }
}


```

### Class ToDoList

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.Status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a repository for managing a to-do list of project entries.
 */
public class ToDoList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Entry> toDoList;
    private static ToDoList instance;

    /**
     * Constructs a new ToDoList object.
     * Initializes the to-do list as an empty ArrayList.
     */
    public ToDoList() {
        toDoList = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of the ToDoList.
     *
     * @return The singleton instance of the ToDoList.
     */
    public static ToDoList getInstance() {
        if (instance == null) {
            instance = new ToDoList();
        }
        return instance;
    }

    /**
     * Adds an entry to the to-do list.
     *
     * @param entry The entry to add.
     */
    public void addEntry(Entry entry) {
        toDoList.add(entry);
    }

    /**
     * Retrieves a copy of the to-do list.
     *
     * @return A copy of the to-do list.
     */
    public List<Entry> getToDoList() {
        return List.copyOf(toDoList);
    }

    /**
     * Retrieves entries with a specific status from the to-do list.
     *
     * @param status The status of entries to retrieve.
     * @return A list of entries with the specified status.
     */
    public List<Entry> getEntriesWithStatus(Status status) {
        return getToDoList().stream()
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

/**
 * Represents an entry in a project schedule.
 * An entry consists of a task, urgency, duration, associated green space, status, start and end dates,
 * team assigned, and vehicles assigned.
 */
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

    /**
     * Constructs an Entry object with the specified task, urgency, duration, green space, and status.
     *
     * @param task     The task description.
     * @param urgency  The urgency level of the task.
     * @param duration The duration of the task.
     * @param greenSpace The green space associated with the task.
     * @param status   The status of the task.
     */
    public Entry(String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        this.task = task;
        this.urgency = urgency;
        this.duration = duration;
        this.greenSpace = greenSpace;
        this.status = status;
        this.vehicles = new ArrayList<>();
    }

    /**
     * Checks if a vehicle is assigned to this entry.
     *
     * @param vehicle The vehicle to check.
     * @return True if the vehicle is assigned, false otherwise.
     */
    public boolean isVehicleAssigned(Vehicle vehicle) {
        return getVehicles().contains(vehicle);
    }

    /**
     * Gets the start date of the entry.
     *
     * @return The start date.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the entry.
     *
     * @param date The start date to set.
     */
    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    /**
     * Adds a vehicle to the list of vehicles assigned to this entry.
     *
     * @param vehicle The vehicle to add.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Retrieves a vehicle at the specified index from the list of vehicles assigned to this entry.
     *
     * @param index The index of the vehicle to retrieve.
     * @return The vehicle at the specified index.
     */
    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }

    /**
     * Gets an unmodifiable list of vehicles assigned to this entry.
     *
     * @return The list of vehicles.
     */
    public List<Vehicle> getVehicles() {
        return List.copyOf(vehicles);
    }

    /**
     * Gets the end date of the entry.
     *
     * @return The end date.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the entry.
     *
     * @param date The end date to set.
     */
    public void setEndDate(LocalDate date) {
        this.endDate = date;
    }

    /**
     * Gets the status of the entry.
     *
     * @return The status of the entry.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets the task description.
     *
     * @return The task description.
     */
    public String getTask() {
        return task;
    }

    /**
     * Gets the team assigned to this entry.
     *
     * @return The team assigned to this entry, or null if no team is assigned.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets the team assigned to this entry.
     *
     * @param team The team to assign to this entry.
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Gets the urgency level of the task.
     *
     * @return The urgency level.
     */
    public Urgency getUrgency() {
        return urgency;
    }

    /**
     * Gets the duration of the task.
     *
     * @return The duration of the task.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the green space associated with this entry.
     *
     * @return The green space associated with this entry.
     */
    public GreenSpace getGreenSpace() {
        return greenSpace;
    }

    /**
     * Sets the green space associated with this entry.
     *
     * @param greenSpace The green space to associate with this entry.
     */
    public void setGreenSpace(GreenSpace greenSpace) {
        this.greenSpace = greenSpace;
    }

    /**
     * Sets the status of the entry.
     *
     * @param status The status to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the entry.
     *
     * @return A string representation of the entry.
     */
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
Simulate how the ToDoListController interacts with the ToDoList to store and retrieve entries.


* We instantiate the ToDoList.
* We create a ToDoListController with the repositories.
* We add an entry to the repository and set its status to scheduled.

## 7. Observations

n/a