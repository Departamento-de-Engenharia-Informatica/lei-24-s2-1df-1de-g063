package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Collaborator {
    private String email;
    private String name;
    private String address;
    private String cellphone_number;
    private Job job;
    private List<Skill> skills;
    private String birthDate;
    private String IDtype;
    private int taxpayerNumber;
    private int IDNumber;

    public Collaborator(String email, String name, String address, String cellphone_number, Job job, String birthDate, String IDtype, int taxpayerNumber, int IDNumber) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.cellphone_number = cellphone_number;
        this.job = job;
        this.birthDate = birthDate;
        this.IDtype = IDtype;
        this.taxpayerNumber = taxpayerNumber;
        this.IDNumber = IDNumber;
        this.skills = new ArrayList<Skill>();

    }

    public Collaborator(String email, String name, String address, String cellphone_number, Job job, String birthDate, String IDtype, int taxpayerNumber, int IDNumber, List<Skill> skills) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.cellphone_number = cellphone_number;
        this.job = job;
        this.birthDate = birthDate;
        this.IDtype = IDtype;
        this.taxpayerNumber = taxpayerNumber;
        this.IDNumber = IDNumber;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adreess) {
        this.address = adreess;
    }

    public String getCellphone_number() {
        return cellphone_number;
    }

    public void setCellphone_number(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getTaxpayerNumber() {
        return taxpayerNumber;
    }

    public void setTaxpayerNumber(int taxpayerNumber) {
        this.taxpayerNumber = taxpayerNumber;
    }

    public String getIDtype() {
        return IDtype;
    }

    public void setIDtype(String IDtype) {
        this.IDtype = IDtype;
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
        return email.equals(collaborator.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Skill> addSkill(Skill skill) {
        if (this.skills.contains(skill)) {
            throw new IllegalArgumentException("Collaborator already contains the skill");
        }
        if (skill.getSkillValues().contains(null)) {
            throw new IllegalArgumentException("No parameter of the skill cannot be null");
        }
        this.skills.add(skill);


        return this.skills;
    }

    public void removeSkill(Skill skill) {
        if (!this.skills.contains(skill)) {
            throw new IllegalArgumentException("Collaborator does not contain the skill");
        }
        this.skills.remove(skill);
    }

    @Override
    public String toString() {
        StringBuilder skillString = new StringBuilder();

        for (Skill skill : skills) {
            skillString.append("\n    skill='").append(skill.toString()).append("'\n");
        }

        return "Collaborator{\n" +
                "email='" + email + "',\n" +
                "name='" + name + "',\n" +
                "address='" + address + "',\n" +
                "phone='" + cellphone_number + "',\n" +
                job.toString() + "',\n" +
                "birthDate='" + birthDate + "',\n" +
                "IDtype='" + IDtype + "',\n" +
                "taxpayerNumber='" + Integer.toString(taxpayerNumber) + "',\n" +
                "citizenNumber='" + Integer.toString(IDNumber) + "',\n" +
                "Skills:" + (skillString.toString().isEmpty() ? " No skill\n" : skillString) +
                "}\n";
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Collaborator clone() {
        return new Collaborator(this.email, this.name, this.address, this.cellphone_number, this.job, this.birthDate, this.IDtype, this.taxpayerNumber, this.IDNumber, new ArrayList<>(this.skills));
    }
}