package pt.ipp.isep.dei.esoft.project.domain;

public class Skill {

    private final String skill_name;

    public Skill(String skill_name) {
        this.skill_name = skill_name;
    }

    public Skill clone() {
        return new Skill(this.skill_name);
    }
}
