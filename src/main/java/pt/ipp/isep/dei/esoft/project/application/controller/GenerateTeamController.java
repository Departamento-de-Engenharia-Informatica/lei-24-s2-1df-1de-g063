package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The GenerateTeamController class handles the generation of team proposals based on specified criteria.
 * It interacts with the CollaboratorRepository, SkillsRepository, and TeamRepository.
 * <p>
 * The class provides a method to generate a team proposal with a specified minimum and maximum team size,
 * along with a list of required skills. It ensures that collaborators who are already part of a team
 * are not included in the proposed team.
 * <p>
 * Example usage:
 * <pre>{@code
 * GenerateTeamController controller = new GenerateTeamController();
 * Team teamProposal = controller.generateTeamProposal(minSize, maxSize, requiredSkills);
 * }</pre>
 */
public class GenerateTeamController {
    private final CollaboratorRepository collaboratorRepository;
    private final SkillsRepository skillsRepository;
    private final TeamRepository teamRepository;

    /**
     * Constructs a GenerateTeamController object.
     * Initializes the CollaboratorRepository, SkillsRepository, and TeamRepository attributes.
     */
    public GenerateTeamController() {
        this.collaboratorRepository = CollaboratorRepository.getInstance();
        this.skillsRepository = SkillsRepository.getInstance();
        this.teamRepository = TeamRepository.getInstance();
    }

    /**
     * Generates a team proposal based on specified criteria.
     * Filters collaborators based on required skills and ensures that collaborators who are already part of a team
     * are not included in the proposed team.
     *
     * @param minTeamSize    the minimum size of the team
     * @param maxTeamSize    the maximum size of the team
     * @param requiredSkills the list of required skills
     * @return a Team object representing the proposed team, or null if no suitable team can be formed
     */
    public Team generateTeamProposal(int minTeamSize, int maxTeamSize, List<Skill> requiredSkills) {
        List<Collaborator> allCollaborators = collaboratorRepository.getCollaborators();
        List<Collaborator> filteredCollaborators = filterCollaboratorsBySkills(allCollaborators, requiredSkills);

        if (filteredCollaborators.size() < minTeamSize) {
            System.out.println("Insufficient collaborators available.");
            return null;
        } else if (filteredCollaborators.size() > maxTeamSize) {
            List<Collaborator> selectedCollaborators = selectCollaborators(filteredCollaborators, maxTeamSize);
            Team team = new Team();
            team.setMembers(selectedCollaborators);
            return team;
        } else {
            Team team = new Team();
            team.setMembers(filteredCollaborators);
            return team;
        }
    }

    /**
     * Retrieves a skill by its name from the SkillsRepository.
     *
     * @param name the name of the skill
     * @return the skill if found, null otherwise
     */
    public Skill getSkillByName(String name) {
        return skillsRepository.getSkillByName(name);
    }

    /**
     * Adds the team to the TeamRepository.
     *
     * @param team the team to add
     */
    public void addTeam(Team team) {
        teamRepository.addTeams(team);
    }

    /**
     * Filters collaborators based on the required skills and checks if they are already part of a team.
     *
     * @param collaborators  the list of collaborators to filter
     * @param requiredSkills the list of required skills
     * @return a list of collaborators that meet the required skills and are not part of a team
     */
    private List<Collaborator> filterCollaboratorsBySkills(List<Collaborator> collaborators, List<Skill> requiredSkills) {
        List<Collaborator> filteredCollaborators = new ArrayList<>();
        for (Collaborator collaborator : collaborators) {
            if (!isCollaboratorInTeam(collaborator)) {
                boolean hasAllSkills = true;
                for (Skill requiredSkill : requiredSkills) {
                    if (!collaborator.hasSkill(requiredSkill)) {
                        hasAllSkills = false;
                        break;
                    }
                }
                if (hasAllSkills) {
                    filteredCollaborators.add(collaborator);
                }
            }
        }
        return filteredCollaborators;
    }

    /**
     * Checks if a collaborator is already part of a team.
     *
     * @param collaborator the collaborator to check
     * @return true if the collaborator is part of a team, false otherwise
     */
    private boolean isCollaboratorInTeam(Collaborator collaborator) {
        for (Team team : teamRepository.getTeams()) {
            if (team.getMembers().contains(collaborator)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Selects a subset of collaborators from the list, up to the specified maximum team size.
     *
     * @param collaborators the list of collaborators to select from
     * @param maxTeamSize   the maximum size of the team
     * @return a list of selected collaborators, up to the maximum team size
     */
    private List<Collaborator> selectCollaborators(List<Collaborator> collaborators, int maxTeamSize) {
        return collaborators.subList(0, Math.min(maxTeamSize, collaborators.size()));
    }
}
