package pt.ipp.isep.dei.esoft.project.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Collaborator {
    private String email;
    private String name;
    private String address;
    private String phone;
    private Job job;
    private List<Skill> skills;
    private String birthDate;
    private String IDtype;
    private int taxpayerNumber;
    private int citizenNumber;
    public Collaborator(String email, String name, String address, String phone, Job job, String birthDate, String IDtype, int taxpayerNumber, int citizenNumber, List<Skill> skills) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.job = job;
        this.birthDate = birthDate;
        this.IDtype = IDtype;
        this.taxpayerNumber = taxpayerNumber;
        this.citizenNumber = citizenNumber;
        this.skills = skills;
    }

    public Collaborator(String email, String name, String address, int phone, String job, String birthDate, String iDtype, String taxpayerNumber, int citizenNumber, String skills, int admissionDate) {
    }


//    public Collaborator(String email, String name, String address, int phone, String job, String birthDate, String IDtype, String taxpayerNumber, int citizenNumber, int skills, int admissionDate) {
//        this.email = email;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//        this.job = job;
//        this.skills = (List<Skill>) skills;
//        this.birthDate = birthDate;
//        this.IDtype = IDtype;
//        this.taxpayerNumber = taxpayerNumber;
//        this.citizenNumber = citizenNumber;
//
//
//    }
//
//    public Collaborator(String email, String name, String address, String phone, Job job, String birthDate, String IDtype, int taxpayerNumber, int citizenNumber, List<Skill> skills) {
//        this.email = email;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//        this.job = job;
//        this.birthDate = birthDate;
//        this.IDtype = IDtype;
//        this.taxpayerNumber = taxpayerNumber;
//        this.citizenNumber = citizenNumber;
//        this.skills = skills;
//    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(int citizenNumber) {
        this.citizenNumber = citizenNumber;
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
        if (skill.getSkill().contains(null)) {
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
                "phone='" + phone + "',\n" +
                job.toString() + "',\n" +
                "birthDate='" + birthDate + "',\n" +
                "IDtype='" + IDtype + "',\n" +
                "taxpayerNumber='" + Integer.toString(taxpayerNumber) + "',\n" +
                "citizenNumber='" + Integer.toString(citizenNumber) + "',\n" +
                "Skills:" + (skillString.toString().isEmpty() ? " No skill\n" : skillString) +
                "}\n";
    }

    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Collaborator clone() {
        return new Collaborator(this.email, this.name, this.address, this.phone, this.job, this.birthDate, this.IDtype, this.taxpayerNumber, this.citizenNumber, new ArrayList<>(this.skills));
    }
}