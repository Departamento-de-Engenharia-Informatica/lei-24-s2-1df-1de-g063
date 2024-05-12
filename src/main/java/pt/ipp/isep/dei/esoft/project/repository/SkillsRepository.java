package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * The SkillsRepository class represents a repository for managing skills.
 * It provides methods to add and retrieve skills.
 */
public class SkillsRepository {
    private static SkillsRepository instance; // Singleton instance of SkillsRepository.
    private List<Skill> skills; // List to store skills.

    /**
     * Gets the singleton instance of SkillsRepository.
     *
     * @return The singleton instance of SkillsRepository.
     */
    public static SkillsRepository getInstance() {
        if (instance == null) {
            instance = new SkillsRepository();
        }
        return instance;
    }

    /**
     * Constructs a new SkillsRepository with an empty list of skills.
     */
    public SkillsRepository() {
        skills = new ArrayList<>();
    }

    /**
     * Adds a skill to the repository.
     *
     * @param skill The skill to add.
     */
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    /**
     * Retrieves all skills from the repository.
     *
     * @return A list of all skills.
     */
    public Skill getSkillByName(String skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equalsIgnoreCase(skillName)) {
                return skill;
            }
        }
        // Return null if no skill with the given name is found
        return null;
    }


    public List<Skill> getSkills() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(skills);
    }

}

