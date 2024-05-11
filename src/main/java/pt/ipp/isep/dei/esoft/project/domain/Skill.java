package pt.ipp.isep.dei.esoft.project.domain;

public class Skill {

    private final String skill_name;


    public Skill(String skill_name) {
        if (skill_name == null) {
            throw new IllegalArgumentException("Skill name cannot be null");
        }
        this.skill_name = skill_name;
    }

    public String getName() {
        return this.skill_name;
    }

    @Override
    public String toString() {
        return skill_name ;
    }
}
