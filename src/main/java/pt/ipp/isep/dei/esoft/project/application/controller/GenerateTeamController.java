package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

public class GenerateTeamController {
    private final CollaboratorRepository collaboratorRepository;
    private final SkillsRepository skillsRepository;

    private final TeamRepository teamRepository;

    public GenerateTeamController() {
        this.collaboratorRepository = CollaboratorRepository.getInstance();
        this.skillsRepository = SkillsRepository.getInstance();
        this.teamRepository = TeamRepository.getInstance();
    }

    public Team generateTeamProposal(int minTeamSize, int maxTeamSize, List<Skill> requiredSkills) {
        // Get all available collaborators
        List<Collaborator> allCollaborators = collaboratorRepository.getCollaborators();

        // Filter collaborators based on required skills
        List<Collaborator> filteredCollaborators = filterCollaboratorsBySkills(allCollaborators, requiredSkills);

        // Filter collaborators based on job roles

        // Limit team size to minTeamSize and maxTeamSize
        if (filteredCollaborators.size() < minTeamSize) {
            // Handle case where not enough collaborators with required skills are available
            System.out.println("Insufficient collaborators available.");
            return null;
        } else if (filteredCollaborators.size() > maxTeamSize) {
            // Randomly select collaborators to meet maxTeamSize
            List<Collaborator> selectedCollaborators = selectCollaborators(filteredCollaborators, maxTeamSize);
            // Create a Team object and return it
            Team team = new Team();
            team.setMembers(selectedCollaborators);
            return team;
        } else {
            // Create a Team object and return it
            Team team = new Team();
            team.setMembers(filteredCollaborators);
            return team;
        }
    }


    private List<Collaborator> filterCollaboratorsBySkills(List<Collaborator> collaborators, List<Skill> requiredSkills) {
        List<Collaborator> filteredCollaborators = new ArrayList<>();
        for (Collaborator collaborator : collaborators) {
            // Check if collaborator is already part of a team
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

    private boolean isCollaboratorInTeam(Collaborator collaborator) {
        for (Team team : teamRepository.getTeams()) {
            if (team.getMembers().contains(collaborator)) {
                return true;
            }
        }
        return false;
    }



    private List<Collaborator> selectCollaborators(List<Collaborator> collaborators, int maxTeamSize) {
        return collaborators.subList(0, maxTeamSize);
    }
}

