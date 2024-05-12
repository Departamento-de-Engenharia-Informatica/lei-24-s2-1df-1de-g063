package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The Skill class represents a specific skill that a collaborator may possess.
 * Each skill has a unique name.
 */
public class Skill {

    private final String skill_name; // The name of the skill.

    /**
     * Constructs a new Skill with the specified name.
     *
     * @param skill_name The name of the skill. It cannot be changed.
     * @throws IllegalArgumentException if the skill name is null.
     */
    public Skill(String skill_name) {
        if (skill_name == null) {
            throw new IllegalArgumentException("Skill name cannot be null");
        }
        this.skill_name = skill_name;
    }

    /**
     * Gets the name of the skill.
     *
     * @return The name of the skill.
     */
    public String getName() {
        return this.skill_name;
    }

    /**
     * Returns a string representation of the skill.
     *
     * @return A string representation of the skill.
     */
    @Override
    public String toString() {
        return skill_name;
    }
}
