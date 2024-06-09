package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Employee class represents an employee in the system.
 * It contains information such as email, name, position, and phone number.
 * <p>
 * This class provides methods to compare employees based on their email,
 * check if an email matches an employee's email, and clone an employee.
 */
public class Employee implements Serializable {
    private final String email;
    private String name;
    private String position;
    private String phone;

    /**
     * Constructs an Employee object with the specified email.
     *
     * @param email the email of the employee
     */
    public Employee(String email) {
        this.email = email;
    }

    /**
     * Checks if this employee is equal to another object.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    /**
     * Generates a hash code for this employee based on its email.
     *
     * @return the hash code value for this employee
     */
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     * Checks if the given email matches the email of this employee.
     *
     * @param email the email to check
     * @return true if the given email matches this employee's email, false otherwise
     */
    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }

    /**
     * Clones the current employee.
     *
     * @return A clone of the current employee instance
     */
    public Employee clone() {
        return new Employee(this.email);
    }
}
