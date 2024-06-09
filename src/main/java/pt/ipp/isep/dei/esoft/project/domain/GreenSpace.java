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
