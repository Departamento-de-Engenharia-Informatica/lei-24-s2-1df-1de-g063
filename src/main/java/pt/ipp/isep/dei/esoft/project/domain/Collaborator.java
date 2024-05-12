package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Collaborator {
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

    public Collaborator(String name, String adress, String email, String phoneNumber, String idType, String idNumber, LocalDate birthDate, LocalDate admissionDate, String job) {
        this.name = name;
        this.address = adress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.idType = idType;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.admissionDate = admissionDate;
        this.job = job;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getName(){ return name;}

    public boolean hasSkill(Skill skill){
        for (Skill s : skills) {
            if (s.equals(skill)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborator that = (Collaborator) o;
        return Objects.equals(idNumber, that.idNumber) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(idType, that.idType) && Objects.equals(birthDate, that.birthDate) && Objects.equals(admissionDate, that.admissionDate) && Objects.equals(job, that.job);
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
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