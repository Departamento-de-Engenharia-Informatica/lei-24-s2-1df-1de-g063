package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.Date;

public class Entry {
    private final String task;
    private final Urgency urgency;
    private final int duration;
    private GreenSpace greenSpace;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;

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
