package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Task {
    private String name;
    private String jobTitle;
    private String address;
    private int cell_number;
    private int id_number;
    private String id_doc_type;
    private int ano;
    private int mes;
    private int dia;
    private String email;
    public Task(String Name, String jobTitle, String address, String id_doc_type,
                int cell_number, double id_number, Job job, Skill skill) {

        validateReference(reference);
        this.name = name;
        this.jobTitle = jobTitle;
        this.address = address;
        this.technicalDescription = technicalDescription;
        this.duration = duration;
        this.cost = cost;
        this.taskCategory = taskCategory;
        this.employee = employee;
    }

    private void validateReference(String reference) {
        //TODO: missing from the diagrams
        if (reference == null || reference.isEmpty()) {
            throw new IllegalArgumentException("Reference cannot be null or empty.");
        }
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(reference, employee);
    }


    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Task clone() {
        return new Task(this.reference, this.description, this.informalDescription, this.technicalDescription,
                this.duration, this.cost, this.taskCategory, this.employee);
    }
}