package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * The Collaborator class represents a collaborator in a project.
 * A collaborator is a person who is involved in a project and possesses certain attributes.
 */
public class Collaborator {
    private final String name; // The name of the collaborator.
    private final String address; // The address of the collaborator.
    private final String email; // The email address of the collaborator.
    private final String phoneNumber; // The phone number of the collaborator.
    private final String idType; // The type of identification of the collaborator (e.g., passport, ID card).
    private final String idNumber; // The identification number of the collaborator.
    private final LocalDate birthDate; // The birth date of the collaborator.
    private final LocalDate admissionDate; // The date of admission of the collaborator to the project.
    private final String job; // The job title or role of the collaborator in the project.
    private List<Skill> skill; // The skills possessed by the collaborator.

    /**
     * Constructs a new Collaborator with the specified attributes.
     *
     * @param name           The name of the collaborator.
     * @param address        The address of the collaborator.
     * @param email          The email address of the collaborator.
     * @param phoneNumber    The phone number of the collaborator.
     * @param idType         The type of identification of the collaborator.
     * @param idNumber       The identification number of the collaborator.
     * @param birthDate      The birth date of the collaborator.
     * @param admissionDate  The date of admission of the collaborator to the project.
     * @param job            The job title or role of the collaborator in the project.
     */
    public Collaborator(String name, String address, String email, String phoneNumber, String idType, String idNumber, LocalDate birthDate, LocalDate admissionDate, String job) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idType = idType;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.admissionDate = admissionDate;
        this.job = job;
    }

    /**
     * Gets the list of skills possessed by the collaborator.
     *
     * @return The list of skills.
     */
    public List<Skill> getSkill() {
        return skill;
    }

    /**
     * Sets the list of skills possessed by the collaborator.
     *
     * @param skill The list of skills to set.
     */
    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator that = (Collaborator) o;
        return Objects.equals(idNumber, that.idNumber) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(idType, that.idType) && Objects.equals(birthDate, that.birthDate) && Objects.equals(admissionDate, that.admissionDate) && Objects.equals(job, that.job);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "Collaborator{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idType='" + idType + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", birthDate=" + birthDate +
                ", admissionDate=" + admissionDate +
                ", job='" + job + '\'' +
                '}';
    }
}
