package pt.ipp.isep.dei.esoft.project.domain;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Collaborator> members;

    public Team() {
        this.members = new ArrayList<>();
    }



    public List<Collaborator> getMembers() {
        return members;
    }

    public void setMembers(List<Collaborator> members) {
        this.members = members;
    }

    public void addMember(Collaborator member) {
        this.members.add(member);
    }

    public void removeMember(Collaborator member) {
        this.members.remove(member);
    }

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

