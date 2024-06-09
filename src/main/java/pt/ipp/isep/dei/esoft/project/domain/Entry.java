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
