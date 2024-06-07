package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Collaborator in the system.
 * <p>
 * A Collaborator has personal information such as name, address, email, and phone number,
 * as well as identification details including type and number, birth date, admission date,
 * and job position. Additionally, a Collaborator may possess a list of skills relevant to their work.
 */
public class Collaborator implements Serializable {
    private final String name;
    private final String address;
    private final String email;
    private final String phoneNumber;
    private final String idType;
    private final String idNumber;
    private final LocalDate birthDate;
    private final LocalDate admissionDate;
    private final String job;
    private List<Skill> skills;

    /**
     * Constructs a new Collaborator with the specified attributes.
     *
     * @param name          the name of the collaborator
     * @param address       the address of the collaborator
     * @param email         the email address of the collaborator
     * @param phoneNumber   the phone number of the collaborator
     * @param idType        the type of identification document of the collaborator
     * @param idNumber      the number of the identification document of the collaborator
     * @param birthDate     the birth date of the collaborator
     * @param admissionDate the admission date of the collaborator
     * @param job           the job position of the collaborator
     */
    public Collaborator(String name, String address, String email, String phoneNumber, String idType,
                        String idNumber, LocalDate birthDate, LocalDate admissionDate, String job) {
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
     * Retrieves the name of the collaborator.
     *
     * @return the name of the collaborator
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of skills possessed by the collaborator.
     *
     * @return the list of skills
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Sets the list of skills for the collaborator.
     *
     * @param skills the list of skills to set
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * Checks if the collaborator possesses a specific skill.
     *
     * @param skill the skill to check
     * @return true if the collaborator has the skill, false otherwise
     */
    public boolean hasSkill(Skill skill) {
        return skills.contains(skill);
    }

    public String getEmail() {
        return email;
    }

    /**
     * Compares this collaborator to another object for equality.
     * Two collaborators are considered equal if all their attributes match.
     *
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator that = (Collaborator) o;
        return Objects.equals(idNumber, that.idNumber) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(idType, that.idType) && Objects.equals(birthDate, that.birthDate) && Objects.equals(admissionDate, that.admissionDate) && Objects.equals(job, that.job);
    }

    /**
     * Generates a string representation of the collaborator.
     *
     * @return a string representation of the collaborator
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
