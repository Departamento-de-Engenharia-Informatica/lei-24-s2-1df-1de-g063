# US020 - As a Green Space Manager (GSM), I want to register a green space.

## 4. Tests

**Test 1:** Ensures that a GreenSpace object is instantiated correctly with all its properties set to the expected values.

    @Test
    void getName() {
    GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
    String expectedName = "Park1";
    assertEquals(expectedName, greenSpace.getName());
    }

**Test 2:** Ensures that when a GreenSpace object is initially created, its manager name is correctly set.

    @Test
    void getManagerName() {
        GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        String expectedManagerName = "Francisco";
        assertEquals(expectedManagerName, greenSpace.getManagerName());
    }

**Test 3:** Ensures that when a GreenSpace object is initially created, its area is correctly set.

    @Test
    void getArea() {
        GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        double expectedArea = 100.0;
        assertEquals(expectedArea, greenSpace.getArea());
    }

**Test 4:** Ensures that the equals method of a GreenSpace object works correctly.

    @Test
    void testEquals() {
        GreenSpace greenSpace1 = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        GreenSpace greenSpace2 = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        GreenSpace greenSpace3 = new GreenSpace("Park2", 200.0, Size.Large_Size, "Francisco");

        assertEquals(greenSpace1, greenSpace2); // Test for two equal GreenSpaces
        assertNotEquals(greenSpace1, greenSpace3); // Test for two different GreenSpaces
        assertNotEquals(greenSpace1, null); // Test for comparison with null
        assertNotEquals(greenSpace1, new Object()); // Test for comparison with different type of object
    }

**Test 5:** Ensures that the toString method of a GreenSpace object works correctly.

    @Test
    void testToString() {
        GreenSpace greenSpace = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        String expectedString = "GreenSpace{name='Park1', area=100.0, size=Large_Size, manager name='Francisco'}";
        assertEquals(expectedString, greenSpace.toString());
    }




## 5. Construction (Implementation)

### Class RegisterGreenSpaceController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Size;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

/**
 * The RegisterGreenSpaceController class manages the registration of green spaces.
 * It interacts with the GreenSpaceRepository and AuthenticationRepository.
 */
public class RegisterGreenSpaceController {
    private GreenSpaceRepository greenSpaceRepository;
    private AuthenticationRepository authenticationRepository;

    /**
     * Constructs a RegisterGreenSpaceController object and initializes the repositories.
     */
    public RegisterGreenSpaceController() {
        getAuthenticationRepository();
        getGreenSpaceRepository();
    }

    /**
     * Constructs a RegisterGreenSpaceController object with a specified AuthenticationRepository.
     *
     * @param authenticationRepository the authentication repository to use
     */
    public RegisterGreenSpaceController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    /**
     * Retrieves the green space repository instance. If it is not already initialized, initializes it.
     *
     * @return the green space repository instance
     */
    public GreenSpaceRepository getGreenSpaceRepository() {
        if (greenSpaceRepository == null) {
            Repositories repositories = Repositories.getInstance();
            greenSpaceRepository = repositories.getGreenSpaceRepository();
        }
        return greenSpaceRepository;
    }

    /**
     * Retrieves the authentication repository instance. If it is not already initialized, initializes it.
     *
     * @return the authentication repository instance
     */
    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    /**
     * Registers a new green space with the specified details.
     *
     * @param name       the name of the green space
     * @param area       the area of the green space
     * @param size       the size category of the green space
     * @param managerName the name of the manager responsible for the green space
     * @return the newly registered GreenSpace object
     */
    public GreenSpace registerGreenSpace(String name, double area, Size size, String managerName) {
        return new GreenSpace(name, area, size, managerName);
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

/**
 * The GreenSpaceRepository class represents a repository for managing GreenSpace objects.
 * It provides methods for adding, retrieving, and updating green spaces.
 */
public class GreenSpaceRepository implements Serializable {
    private final List<GreenSpace> greenSpaces;
    private static GreenSpaceRepository instance;

    /**
     * Constructs a GreenSpaceRepository object.
     */
    public GreenSpaceRepository() {
        greenSpaces = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of GreenSpaceRepository.
     *
     * @return the singleton instance of GreenSpaceRepository
     */
    public static GreenSpaceRepository getInstance() {
        if (instance == null) {
            instance = new GreenSpaceRepository();
        }
        return instance;
    }

    /**
     * Adds a green space to the repository.
     *
     * @param greenSpace the green space to add
     */
    public void addGreenSpace(GreenSpace greenSpace) {
        greenSpaces.add(greenSpace);
    }

    /**
     * Retrieves all green spaces stored in the repository.
     *
     * @return a list of all green spaces
     */
    public List<GreenSpace> getGreenSpaces() {
        return greenSpaces;
    }

    /**
     * Retrieves green spaces by manager name.
     *
     * @param managerName the manager's name to filter green spaces
     * @return a list of green spaces managed by the specified manager
     */
    public List<GreenSpace> getGreenSpacesByName(String managerName) {
        return greenSpaces.stream()
                .filter(greenSpace -> greenSpace.getManagerName().equalsIgnoreCase(managerName))
                .collect(Collectors.toList());
    }

    /**
     * Saves a green space by updating it in the repository.
     *
     * @param greenSpace the green space to save
     */
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

/**
 * Represents a Green Space.
 * <p>
 * A Green Space is an area of land that is mainly covered by grass, trees, or other vegetation.
 * </p>
 */
public class GreenSpace implements Serializable {
    /**
     * The name of the Green Space.
     */
    private final String name;

    /**
     * The area of the Green Space in square meters.
     */
    private final double area;

    /**
     * The size of the Green Space.
     */
    private final Size size;

    /**
     * The name of the manager responsible for the Green Space.
     */
    private String managerName;

    /**
     * Constructs a new GreenSpace with the specified name, area, size, and manager name.
     *
     * @param name        the name of the Green Space
     * @param area        the area of the Green Space
     * @param size        the size of the Green Space
     * @param managerName the name of the manager responsible for the Green Space
     */
    public GreenSpace(String name, double area, Size size, String managerName) {
        this.name = name;
        this.area = area;
        this.size = size;
        this.managerName = managerName;
    }

    /**
     * Validates the Green Space name.
     *
     * @param greenSpaceName the name of the Green Space
     * @throws IllegalArgumentException if the Green Space name is empty
     */
    private void validateGreenSpaceName(String greenSpaceName) {
        if (greenSpaceName.isEmpty()) {
            throw new IllegalArgumentException("The Green Space Name must not be empty");
        }
    }

    /**
     * Gets the name of the Green Space.
     *
     * @return the name of the Green Space
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name of the manager responsible for the Green Space.
     *
     * @return the name of the manager
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Gets the area of the Green Space.
     *
     * @return the area of the Green Space
     */
    public double getArea() {
        return area;
    }

    /**
     * Checks if this GreenSpace is equal to another object.
     *
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreenSpace that = (GreenSpace) o;
        return Objects.equals(name, that.name);
    }

    /**
     * Returns a string representation of the GreenSpace.
     *
     * @return a string representation of the GreenSpace
     */
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
Simulate how the RegisterGreenSpaceController interacts with the GreenSpaceRepository to register a green space:


* We instantiate the GreenSpaceRepository.
* We create a RegisterGreenSpaceController with the repositories.
* We add a green space to the repository and set its manager name.


## 7. Observations

n/a