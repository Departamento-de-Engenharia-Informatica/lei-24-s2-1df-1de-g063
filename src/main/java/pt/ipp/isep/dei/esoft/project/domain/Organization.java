package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * The Organization class represents an organization in the system.
 * It contains information such as VAT number, employees, tasks, and vehicles.
 * <p>
 * This class provides methods to manage employees, tasks, and vehicles within the organization,
 * including creating tasks, adding employees, and cloning the organization.
 */
public class Organization implements Serializable {
    private final String vatNumber;
    private final List<Employee> employees;
    private final List<Task> tasks;
    private String name;
    private String website;
    private String phone;
    private String email;
    private final List<Vehicle> vehicles;

    /**
     * Constructs an Organization object with the specified VAT number.
     *
     * @param vatNumber The VAT number of the organization, which serves as its identity.
     */
    public Organization(String vatNumber) {
        this.vatNumber = vatNumber;
        employees = new ArrayList<>();
        tasks = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    /**
     * Checks if an employee works for the organization.
     *
     * @param employee The employee to be checked.
     * @return True if the employee works for the organization.
     */
    public boolean employs(Employee employee) {
        return employees.contains(employee);
    }

    /**
     * Creates a new task for the organization.
     *
     * @param reference            The reference of the task.
     * @param description          The description of the task.
     * @param informalDescription  The informal description of the task.
     * @param technicalDescription The technical description of the task.
     * @param duration             The duration of the task.
     * @param cost                 The cost of the task.
     * @param taskCategory         The task category of the task.
     * @param employee             The employee responsible for the task.
     * @return An optional containing the created task, if successful, or an empty optional otherwise.
     */
    public Optional<Task> createTask(String reference, String description, String informalDescription,
                                     String technicalDescription, int duration, double cost,
                                     TaskCategory taskCategory, Employee employee) {
        Optional<Task> optionalValue = Optional.empty();
        Task task = new Task(reference, description, informalDescription, technicalDescription, duration, cost,
                taskCategory, employee);
        if (addTask(task)) {
            optionalValue = Optional.of(task);
        }
        return optionalValue;
    }

    /**
     * Adds a task to the organization's task list.
     *
     * @param task The task to be added.
     * @return True if the task was added successfully.
     */
    private boolean addTask(Task task) {
        boolean success = false;
        if (validate(task)) {
            success = tasks.add(task.clone());
        }
        return success;
    }

    /**
     * Validates a task, checking for duplicates.
     *
     * @param task The task to be validated.
     * @return True if the task is valid.
     */
    private boolean validate(Task task) {
        return tasksDoNotContain(task);
    }

    /**
     * Checks if the organization's task list contains a specific task.
     *
     * @param task The task to be checked.
     * @return True if the task is not in the list of tasks.
     */
    private boolean tasksDoNotContain(Task task) {
        return !tasks.contains(task);
    }

    /**
     * Checks if any employee in the organization has a specific email.
     *
     * @param email The email to be checked.
     * @return True if any employee in the organization has the specified email.
     */
    public boolean anyEmployeeHasEmail(String email) {
        for (Employee employee : employees) {
            if (employee.hasEmail(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the organization is equal to another object.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization that = (Organization) o;
        return vatNumber.equals(that.vatNumber);
    }

    /**
     * Generates a hash code for the organization based on its VAT number.
     *
     * @return The hash code value for the organization.
     */
    @Override
    public int hashCode() {
        return Objects.hash(vatNumber);
    }

    /**
     * Adds an employee to the organization.
     *
     * @param employee The employee to be added.
     * @return True if the employee was added successfully.
     */
    public boolean addEmployee(Employee employee) {
        boolean success = false;
        if (validateEmployee(employee)) {
            success = employees.add(employee);
        }
        return success;
    }

    /**
     * Validates an employee, checking for duplicates.
     *
     * @param employee The employee to be validated.
     * @return True if the employee is valid.
     */
    private boolean validateEmployee(Employee employee) {
        return employeesDoNotContain(employee);
    }

    /**
     * Checks if the organization's employee list contains a specific employee.
     *
     * @param employee The employee to be checked.
     * @return True if the employee is not in the list of employees.
     */
    private boolean employeesDoNotContain(Employee employee) {
        return !employees.contains(employee);
    }

    /**
     * Clones the organization.
     *
     * @return A clone of the current organization instance.
     */
    public Organization clone() {
        Organization clone = new Organization(this.vatNumber);
        clone.name = this.name;
        clone.website = this.website;
        clone.phone = this.phone;
        clone.email = this.email;

        for (Employee employee : this.employees) {
            clone.employees.add(employee.clone());
        }

        for (Task task : this.tasks) {
            clone.tasks.add(task.clone());
        }

        return clone;
    }
}
