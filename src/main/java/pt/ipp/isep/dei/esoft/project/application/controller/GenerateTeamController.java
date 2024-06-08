package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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
    private  CollaboratorRepository collaboratorRepository;
    private  SkillsRepository skillsRepository;
    private  TeamRepository teamRepository;

    private List<Collaborator> lastSelectedCollaborators = null;

    /**
     * Constructs a GenerateTeamController object.
     * Initializes the CollaboratorRepository, SkillsRepository, and TeamRepository attributes.
     */
    public GenerateTeamController() {
        this.collaboratorRepository = getCollaboratorRepository();
        this.skillsRepository = getSkillsRepository();
        this.teamRepository = getTeamRepository();
    }
    private CollaboratorRepository getCollaboratorRepository(){
        if(collaboratorRepository == null){
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }
    private SkillsRepository getSkillsRepository(){
        if(skillsRepository == null){
            Repositories repositories = Repositories.getInstance();
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }
    private TeamRepository getTeamRepository(){
        if(teamRepository == null){
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
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
        List<Collaborator> allCollaborators = CollaboratorRepository.getInstance().getCollaborators();
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
    public Skill getSkillByName(String skillName) {
    List<Skill> skills = SkillsRepository.getInstance().getSkills();
    for (Skill skill : skills) {
        if (skill.getName().trim().equalsIgnoreCase(skillName.trim())) {
            return skill;
        }
    }
    // Return null if no skill with the given name is found
    return null;
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
        List<Collaborator> selectedCollaborators;
        do {
            Collections.shuffle(collaborators);

            selectedCollaborators = collaborators.subList(0, Math.min(maxTeamSize, collaborators.size()));
        } while (selectedCollaborators.equals(lastSelectedCollaborators));
        lastSelectedCollaborators = new ArrayList<>(selectedCollaborators);
        return selectedCollaborators;
    }
    public void printTeams() {
        List<Team> teams = teamRepository.getTeams();
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("-----------------");
            System.out.println("Team number: " + i);
            System.out.println(teams.get(i));
            System.out.println("-----------------");
        }
    }
}
