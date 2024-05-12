package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.ArrayList;
import java.util.List;
/**
 * The SkillsRepository class manages the storage and retrieval of skills.
 * It provides methods to add, retrieve, and get all skills.
 */
public class SkillsRepository {

    private static SkillsRepository instance;
    private List<Skill> skills;

    /**
     * Private constructor to prevent external instantiation.
     */
    public SkillsRepository() {
        skills = new ArrayList<>();
    }

    /**
     * Retrieves the singleton instance of SkillsRepository.
     *
     * @return the instance of SkillsRepository
     */
    public static SkillsRepository getInstance() {
        if (instance == null) {
            instance = new SkillsRepository();
        }
        return instance;
    }

    /**
     * Adds a skill to the repository.
     *
     * @param skill the skill to add
     */
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    /**
     * Retrieves a skill by its name.
     *
     * @param skillName the name of the skill to retrieve
     * @return the skill with the specified name, or null if not found
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

    /**
     * Retrieves a copy of all skills stored in the repository.
     *
     * @return a list of all skills
     */
    public List<Skill> getSkills() {
        // This is a defensive copy to prevent modification of the repository's internal list
        return List.copyOf(skills);
    }
}
