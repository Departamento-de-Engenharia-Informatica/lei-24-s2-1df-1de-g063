package pt.ipp.isep.dei.esoft.project.domain;

public class Skill {

    private final String skill_name;


    public Skill(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getName() {
        return this.skill_name;
    }

    public Skill clone() {
        return new Skill(this.skill_name);
    }

    @Override
    public String toString() {
        return skill_name;
    }


}
