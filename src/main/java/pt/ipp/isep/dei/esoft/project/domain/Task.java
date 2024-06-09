package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Task class represents a task within a project.
 * It contains information such as reference, description, duration, cost, category, and assigned employee.
 */
public class Task implements Serializable {
    private final String reference;
    private String description;
    private String informalDescription;
    private String technicalDescription;
    private int duration;
    private double cost;
    private TaskCategory taskCategory;
    private Employee employee;

    /**
     * Constructs a Task object with the specified details.
     *
     * @param reference           the reference code of the task
     * @param description         the description of the task
     * @param informalDescription the informal description of the task
     * @param technicalDescription the technical description of the task
     * @param duration            the duration of the task
     * @param cost                the cost of the task
     * @param taskCategory        the category of the task
     * @param employee            the employee assigned to the task
     */
    public Task(String reference, String description, String informalDescription, String technicalDescription,
                int duration, double cost, TaskCategory taskCategory, Employee employee) {
        validateReference(reference);
        this.reference = reference;
        this.description = description;
        this.informalDescription = informalDescription;
        this.technicalDescription = technicalDescription;
        this.duration = duration;
        this.cost = cost;
        this.taskCategory = taskCategory;
        this.employee = employee;
    }

    private void validateReference(String reference) {
        if (reference == null || reference.isEmpty()) {
            throw new IllegalArgumentException("Reference cannot be null or empty.");
        }
    }

    /**
     * Checks if this task is equal to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return reference.equals(task.reference) && employee.equals(task.employee);
    }

    /**
     * Generates a hash code for this task.
     *
     * @return the hash code value for this task
     */
    @Override
    public int hashCode() {
        return Objects.hash(reference, employee);
    }

    /**
     * Clones this task.
     *
     * @return a clone of this task
     */
    public Task clone() {
        return new Task(this.reference, this.description, this.informalDescription, this.technicalDescription,
                this.duration, this.cost, this.taskCategory, this.employee);
    }
}
