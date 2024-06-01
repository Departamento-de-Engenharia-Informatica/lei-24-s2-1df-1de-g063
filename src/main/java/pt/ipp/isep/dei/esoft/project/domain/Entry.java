package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.List;

public class Entry {
    private final String task;
    private final Urgency urgency;
    private final int duration;
    private GreenSpace greenSpace;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;

   private List<Vehicle> vehicles;
    private Team team;

    public Entry(String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        this.task = task;
        this.urgency = urgency;
        this.duration = duration;
        this.greenSpace = greenSpace;
        this.status = status;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate date){
        this.startDate=date;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void getVehicle(int index){
        vehicles.get(index);
    }

    public List<Vehicle> getVehicles(){
        return List.copyOf(vehicles);
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate date){
        this.endDate=date;
    }

    public Status getStatus() {
        return status;
    }

    public String getTask() {
        return task;
    }
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public Urgency getUrgency() {
        return urgency;
    }

    public int getDuration() {
        return duration;
    }

    public GreenSpace getGreenSpace(){
        return greenSpace;
    }

    public void setGreenSpace(GreenSpace greenSpace) {
        this.greenSpace = greenSpace;
    }

    public void setStatus(Status status) {this.status = status;}

    @Override
    public String toString() {
        return "Entry{" +
                "task='" + task + '\'' +
                ", urgency=" + urgency +
                ", duration=" + duration +
                ", greenSpace=" + greenSpace +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
