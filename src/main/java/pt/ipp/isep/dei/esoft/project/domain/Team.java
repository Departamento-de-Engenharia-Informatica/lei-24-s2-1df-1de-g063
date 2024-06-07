package pt.ipp.isep.dei.esoft.project.domain;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Team class represents a team within the system.
 * It encapsulates a list of collaborators as its members.
 * <p>
 * Example usage:
 * <pre>{@code
 * Team team = new Team();
 * team.addMember(collaborator1);
 * team.addMember(collaborator2);
 * System.out.println(team);
 * }</pre>
 */
public class Team implements Serializable {

    private List<Collaborator> members;

    /**
     * Constructs an empty Team object with no members.
     */
    public Team() {
        this.members = new ArrayList<>();
    }

    /**
     * Retrieves the list of members in the team.
     *
     * @return the list of members in the team
     */
    public List<Collaborator> getMembers() {
        return members;
    }

    /**
     * Sets the list of members in the team.
     *
     * @param members the list of members to set
     */
    public void setMembers(List<Collaborator> members) {
        this.members = members;
    }

    /**
     * Adds a member to the team.
     *
     * @param member the collaborator to add to the team
     */
    public void addMember(Collaborator member) {
        this.members.add(member);
    }

    /**
     * Removes a member from the team.
     *
     * @param member the collaborator to remove from the team
     */
    public void removeMember(Collaborator member) {
        this.members.remove(member);
    }

    /**
     * Returns a string representation of the team, listing its members.
     *
     * @return a string representation of the team
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Members:\n");
        for (Collaborator member : members) {
            sb.append("- ").append(member.getName()).append("\n");
        }
        return sb.toString();
    }
}
