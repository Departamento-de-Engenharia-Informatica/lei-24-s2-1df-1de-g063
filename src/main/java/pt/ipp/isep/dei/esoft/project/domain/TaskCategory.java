package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a category for tasks.
 */
public class TaskCategory implements Serializable {

    private final String description;

    /**
     * Constructs a new TaskCategory with the specified description.
     *
     * @param description the description of the task category
     */
    public TaskCategory(String description) {
        this.description = description;
    }

    /**
     * Compares this TaskCategory to another object for equality.
     * Two TaskCategories are considered equal if their descriptions match.
     *
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TaskCategory)) {
            return false;
        }
        TaskCategory that = (TaskCategory) o;
        return description.equals(that.description);
    }

    /**
     * Generates a hash code for this TaskCategory.
     *
     * @return the hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    /**
     * Retrieves the description of the task category.
     *
     * @return the description of the task category
     */
    public String getDescription() {
        return description;
    }

    /**
     * Creates a clone of the current task category.
     *
     * @return A clone of the current task category.
     */
    public TaskCategory clone() {
        return new TaskCategory(this.description);
    }
}
