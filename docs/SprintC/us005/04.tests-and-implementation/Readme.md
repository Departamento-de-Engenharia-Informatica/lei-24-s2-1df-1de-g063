# US005 - Generate a Team Proposal

## 4. Tests 

**Test 1:** Test adding a member to a team.

    @Test
    public void testAddMember() {
        team.addMember(collaborator1);
        assertEquals(1, team.getMembers().size());
        assertEquals(collaborator1, team.getMembers().get(0));
    }

**Test 2:** Test removing a member from a team.

    @Test
    public void testRemoveMember() {
        team.addMember(collaborator1);
        team.addMember(collaborator2);
        assertEquals(2, team.getMembers().size());

        team.removeMember(collaborator1);
        assertEquals(1, team.getMembers().size());
        assertEquals(collaborator2, team.getMembers().get(0));
    }

**Test 3:** Test the toString() method of the team class.

    @Test
    public void testToString() {
        team.addMember(collaborator1);
        team.addMember(collaborator2);

        String expected = "Members:\n" +
                "- John Doe\n" +
                "- Jane Smith\n";
        assertEquals(expected, team.toString());
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class CreateTaskController 

```java

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

```


## 6. Integration and Demo 

Let's consider a scenario where we have a Team class that manages members.

* We create a Team object named "Development Team".
* We create two Collaborator objects.
* We add these collaborators to the team.
* We display the team's information before and after removing a member.


## 7. Observations

n/a