# US022 - As a GSM, I want to add a new entry in the Agenda.

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

### Class AgendaController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;

import java.io.Serializable;

/**
 * Controller class for managing the agenda and related tasks.
 * This class provides methods to access the ToDoList, AgendaRepository,
 * and AuthenticationRepository.
 */
public class AgendaController {

    private ToDoList toDoList;
    private AgendaRepository agendaRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Default constructor.
     * Initializes the controller and ensures all repositories are available.
     */
    public AgendaController() {
        getToDoList();
        getAgendaRepository();
        getAuthenticationRepository();
    }

    /**
     * Constructor with an AuthenticationRepository parameter.
     * Initializes the ToDoList and sets the provided AuthenticationRepository.
     *
     * @param authenticationRepository The authentication repository to use.
     */
    public AgendaController(AuthenticationRepository authenticationRepository) {
        this.toDoList = ToDoList.getInstance();
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Gets the ToDoList instance.
     * If the ToDoList is not already initialized, it retrieves it from the repositories.
     *
     * @return The ToDoList instance.
     */
    public ToDoList getToDoList() {
        if (toDoList == null) {
            Repositories repositories = Repositories.getInstance();
            toDoList = repositories.getToDoList();
        }
        return toDoList;
    }

    /**
     * Gets the AgendaRepository instance.
     * If the AgendaRepository is not already initialized, it retrieves it from the repositories.
     *
     * @return The AgendaRepository instance.
     */
    public AgendaRepository getAgendaRepository() {
        if (agendaRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agendaRepository = repositories.getAgendaRepository();
        }
        return agendaRepository;
    }

    /**
     * Gets the AuthenticationRepository instance.
     * If the AuthenticationRepository is not already initialized, it retrieves it from the repositories.
     *
     * @return The AuthenticationRepository instance.
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
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

/**
 * Repository class for managing entries in an agenda.
 */
public class AgendaRepository implements Serializable {
    private List<Entry> agenda;
    private static AgendaRepository instance;

    /**
     * Constructs a new AgendaRepository.
     */
    public AgendaRepository() {
        agenda = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of AgendaRepository.
     *
     * @return the instance of AgendaRepository
     */
    public static AgendaRepository getInstance() {
        if (instance == null) {
            instance = new AgendaRepository();
        }
        return instance;
    }

    /**
     * Adds an entry to the agenda.
     *
     * @param entry the entry to add
     */
    public void addEntry(Entry entry) {
        agenda.add(entry);
    }

    /**
     * Retrieves a copy of all entries in the agenda.
     *
     * @return a list of all entries in the agenda
     */
    public List<Entry> getEntries() {
        return List.copyOf(agenda);
    }

    /**
     * Retrieves the entry at the specified index in the agenda.
     *
     * @param index the index of the entry to retrieve
     * @return the entry at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Entry getEntries(int index) {
        if (index >= 0 && index < agenda.size()) {
            return agenda.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Retrieves a copy of all entries in the agenda.
     *
     * @return a list of all entries in the agenda
     */
    public List<Entry> getAgenda() {
        return List.copyOf(agenda);
    }

    /**
     * Updates an existing entry in the agenda.
     *
     * @param updatedEntry the updated entry
     */
    public void updateEntry(Entry updatedEntry) {
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).equals(updatedEntry)) {
                agenda.set(i, updatedEntry);
                return;
            }
        }
    }

    /**
     * Retrieves a list of entries with the specified status.
     *
     * @param status the status of the entries to retrieve
     * @return a list of entries with the specified status
     */
    public List<Entry> getEntriesWithStatus(Status status) {
        return getEntries().stream()
                .filter(entry -> entry.getStatus() == status)
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
Simulate how the AgendaController interacts with the AgendaRepository to store and retrieve entries.


* We instantiate the Agenda.
* We create a AgendaController with the repositories.
* We add an entry to the repository and set its status to scheduled.

## 7. Observations

n/a