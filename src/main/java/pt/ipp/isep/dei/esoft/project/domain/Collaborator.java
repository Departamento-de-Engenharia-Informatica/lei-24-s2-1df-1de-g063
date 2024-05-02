package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
import java.util.Scanner;

public class Collaborator {
    private String name;
    private String jobTitle;
    private String address;
    private int cellNumber;
    private int idNumber;
    private String idDocType;
    private int year;
    private int month;
    private int day;
    private String email;
    private String skill;

    public Collaborator(String name, int year, int month, int day, String jobTitle, String skill, String address, int cellNumber, int idNumber, String idDocType, String email) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.jobTitle = jobTitle;
        this.address = address;
        this.cellNumber = cellNumber;
        this.idNumber = idNumber;
        this.idDocType = idDocType;
        this.email = email;
    }

    private void validateCollaboratorName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Collaborator name cannot be empty.");
        }
    }

    private void validateCollaboratorAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Collaborator address cannot be empty.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Collaborator)) {
            return false;
        }
        Collaborator collaborator = (Collaborator) o;
        return idNumber == collaborator.idNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }
    public Collaborator clone() {
        return new Collaborator(name, year, month, day, jobTitle, skill, address, cellNumber, idNumber, idDocType, email);
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", address='" + address + '\'' +
                ", cellNumber=" + cellNumber +
                ", idNumber=" + idNumber +
                ", idDocType='" + idDocType + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", email='" + email + '\'' +
                '}';
    }
}
