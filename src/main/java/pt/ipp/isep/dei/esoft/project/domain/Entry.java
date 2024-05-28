package pt.ipp.isep.dei.esoft.project.domain;

public class Entry {
    private final String task;
    private final Urgency urgency;
    private final int duration;
    private GreenSpace greenSpace;
    private Status status;

    public Entry(String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        this.task = task;
        this.urgency = urgency;
        this.duration = duration;
        this.greenSpace = greenSpace;
        this.status = status;
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
        return "{" +
                "task='" + task + '\'' +
                ", urgency=" + urgency +'\''+
                ", duration=" + duration +'\''+
                ", greenSpace=" + greenSpace +'\''+
                ", status=" + status +'\''+
                '}';
    }
}
