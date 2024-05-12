package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Skill;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillsRepositoryTest {

    @Test
    void ensureSkillsRepositoryIsSingleton() {
        SkillsRepository instance1 = SkillsRepository.getInstance();
        SkillsRepository instance2 = SkillsRepository.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void ensureSkillsRepositoryIsInitializedWithEmptyList() {
        SkillsRepository skillsRepository = SkillsRepository.getInstance();
        List<Skill> skills = skillsRepository.getSkills();
        assertTrue(skills.isEmpty());
    }

    @Test
    void ensureAddSkillAddsSkillToList() {
        SkillsRepository skillsRepository = SkillsRepository.getInstance();
        Skill skill = new Skill("Java Programming");
        skillsRepository.addSkill(skill);
        List<Skill> skills = skillsRepository.getSkills();
        assertTrue(skills.contains(skill));
    }

}
