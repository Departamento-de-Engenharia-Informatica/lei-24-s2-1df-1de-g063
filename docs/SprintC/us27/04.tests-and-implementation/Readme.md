# US027 - As a GSM, I need to list all green spaces managed by me

## 4. Tests

**Test 1:** Ensures that the singleton instance of  'GreenSpaceRepository' is correctly retrieved.

    @Test
    void testGetInstance() {
        GreenSpaceRepository firstInstance = GreenSpaceRepository.getInstance();
        GreenSpaceRepository secondInstance = GreenSpaceRepository.getInstance();
        assertSame(firstInstance, secondInstance, "getInstance should return the same instance");
    }


**Test 2:** Verifies that a green space is correctly added to the repository..

    @Test
    void testAddGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        repository.addGreenSpace(greenSpace);
        List<GreenSpace> greenSpaces = repository.getGreenSpaces();
        assertEquals(1, greenSpaces.size(), "Should be one green space in the repository");
        assertTrue(greenSpaces.contains(greenSpace), "Repository should contain the added green space");
    }


**Test 3:** Checks that all green spaces in the repository are correctly retrieved.

    @Test
        void testGetGreenSpaces() {
        GreenSpace greenSpace1 = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        GreenSpace greenSpace2 = new GreenSpace("Riverside Park", 100, Size.Garden,"Tiago");
        repository.addGreenSpace(greenSpace1);
        repository.addGreenSpace(greenSpace2);
        List<GreenSpace> greenSpaces = repository.getGreenSpaces();
        assertEquals(2, greenSpaces.size(), "Should be two green spaces in the repository");
        assertTrue(greenSpaces.contains(greenSpace1), "Repository should contain the first added green space");
        assertTrue(greenSpaces.contains(greenSpace2), "Repository should contain the second added green space");
    }


**Test 4:** Verifies that green spaces managed by a specific manager are correctly retrieved from the repository.

    @Test
    void testGetGreenSpacesByName() {
        GreenSpace greenSpace1 = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        GreenSpace greenSpace2 = new GreenSpace("Riverside Park", 100, Size.Garden,"Tiago");
        repository.addGreenSpace(greenSpace1);
        repository.addGreenSpace(greenSpace2);
        List<GreenSpace> franciscoGreenSpaces = repository.getGreenSpacesByName("Francisco");
        assertEquals(1, franciscoGreenSpaces.size(), "Should be one green space managed by Francisco");
        assertTrue(franciscoGreenSpaces.contains(greenSpace1), "Repository should contain Francisco's green space");
    
        List<GreenSpace> tiagoGreenSpaces = repository.getGreenSpacesByName("Tiago");
        assertEquals(1, tiagoGreenSpaces.size(), "Should be one green space managed by Tiago");
        assertTrue(tiagoGreenSpaces.contains(greenSpace2), "Repository should contain Tiago's green space");
    }


**Test 5:** Ensures that a green space is correctly updated in the repository.

    @Test
    void testSaveGreenSpace() {
        GreenSpace greenSpace = new GreenSpace("Central Park", 100, Size.Garden,"Francisco");
        repository.addGreenSpace(greenSpace);
    
        GreenSpace updatedGreenSpace = new GreenSpace("Central Park", 100, Size.Garden,"Tiago");
        repository.saveGreenSpace(updatedGreenSpace);
    
        List<GreenSpace> greenSpaces = repository.getGreenSpaces();
        assertEquals(1, greenSpaces.size(), "Should be one green space in the repository after update");
        assertEquals("Tiago", greenSpaces.get(0).getManagerName(), "The manager name should be updated to Tiago");
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

### Class GreenSpaceRepository

```java
package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GreenSpaceRepository implements Serializable {
    private final List<GreenSpace> greenSpaces;
    private static GreenSpaceRepository instance;

    /**
     * Constructs a CollaboratorRepository object.
     */
    public GreenSpaceRepository() {
        greenSpaces = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of CollaboratorRepository.
     *
     * @return the singleton instance of CollaboratorRepository
     */
    public static GreenSpaceRepository getInstance() {
        if (instance == null) {
            instance = new GreenSpaceRepository();
        }
        return instance;
    }

    /**
     * Adds a collaborator to the repository.
     *
     * @param greenSpace the collaborator to add
     */
    public void addGreenSpace(GreenSpace greenSpace) {
        greenSpaces.add(greenSpace);
    }

    /**
     * Retrieves all collaborators stored in the repository.
     *
     * @return a list of all collaborators
     */
    public List<GreenSpace> getGreenSpaces() {
        return greenSpaces;
    }

    public List<GreenSpace> getGreenSpacesByName(String managerName) {
        return greenSpaces.stream()
                .filter(greenSpace -> greenSpace.getManagerName().equalsIgnoreCase(managerName))
                .collect(Collectors.toList());
    }

    public void saveGreenSpace(GreenSpace greenSpace) {
        boolean updated = false;
        for (int i = 0; i < greenSpaces.size() && !updated; i++) {
            if (greenSpaces.get(i).equals(greenSpace)) {
                greenSpaces.set(i, greenSpace);
                updated = true;
            }
        }
    }
}


```
### Class GreenSpace

```java
package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

public class GreenSpace implements Serializable {
    private final String name;
    private final double area;
    private final Size size;
    private String managerName;

    public GreenSpace(String name, double area, Size size, String managerName) {
        this.name = name;
        this.area = area;
        this.size = size;
        this.managerName = managerName;
    }

    private void validateGreenSpaceName(String greenSpaceName) {
        if (greenSpaceName.isEmpty()) {
            throw new IllegalArgumentException("The Green Space Name must not be empty");
        }
    }

    public String getName() {
        return name;
    }

    public String getManagerName() {
        return managerName;
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreenSpace that = (GreenSpace) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "GreenSpace{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", size=" + size +
                ", manager name='" + managerName + '\'' +
                '}';
    }
}

```


## 6. Integration and Demo
Searches for the green spaces managed by a specific manager.

## 7. Observations

n/a