package pt.ipp.isep.dei.esoft.project.domain;

public class Entry {
    private final String task;
    private final Urgency urgency;
    private final int duration;
    private GreenSpace greenSpace;

    public Entry(String task, Urgency urgency, int duration, GreenSpace greenSpace) {
        this.task = task;
        this.urgency = urgency;
        this.duration = duration;
        this.greenSpace = greenSpace;
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
}
