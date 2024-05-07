package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Collaborator {
    private final String name;
    private final String adress;
    private final String email;
    private final String phoneNumber;
    private final String idType;
    private final String idNumber;
    private final LocalDate birthDate;
    private final LocalDate admissionDate;
    private final String job;
    private List<Skill> skill;

    public Collaborator(String name, String adress, String email, String phoneNumber, String idType, String idNumber, LocalDate birthDate, LocalDate admissionDate, String job) {
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idType = idType;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.admissionDate = admissionDate;
        this.job = job;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator that = (Collaborator) o;
        return Objects.equals(idNumber, that.idNumber) && Objects.equals(name, that.name) && Objects.equals(adress, that.adress) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(idType, that.idType) && Objects.equals(birthDate, that.birthDate) && Objects.equals(admissionDate, that.admissionDate) && Objects.equals(job, that.job);
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idType='" + idType + '\'' +
                ", idNumber=" + idNumber +
                ", birthDate=" + birthDate +
                ", admissionDate=" + admissionDate +
                ", job='" + job + '\'' +
                '}';
    }

}