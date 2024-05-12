package pt.ipp.isep.dei.esoft.project.domain;

/**
 * The Skill class represents a skill within the system.
 * It encapsulates the skill name.
 * <p>
 * Example usage:
 * <pre>{@code
 * Skill skill = new Skill("Java Programming");
 * String skillName = skill.getName();
 * }</pre>
 */
public class Skill {

    private final String skill_name;

    /**
     * Constructs a Skill object with the specified skill name.
     *
     * @param skill_name the name of the skill
     * @throws IllegalArgumentException if the skill name is null
     */
    public Skill(String skill_name) {
        if (skill_name == null) {
            throw new IllegalArgumentException("Skill name cannot be null");
        }
        this.skill_name = skill_name;
    }

    /**
     * Retrieves the name of the skill.
     *
     * @return the name of the skill
     */
    public String getName() {
        return this.skill_name;
    }

    /**
     * Returns a string representation of the skill.
     *
     * @return a string representation of the skill
     */
    @Override
    public String toString() {
        return skill_name;
    }
}

