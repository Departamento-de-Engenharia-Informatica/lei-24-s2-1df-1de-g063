package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollaboratorRecordRepository {
    public boolean getCollaboratorRecordRepository;
    private List<Collaborator> collaboratorList;
    private Object collaboratorRecordRepository;

    public CollaboratorRecordRepository() {
        collaboratorList = new ArrayList<>();
    }

    /**
     * This method returns an exsiting Task Category by its description.
     *
     * @return The task category.
     * @throws IllegalArgumentException if the task category does not exist, which should never happen.
     */

    public Optional<Collaborator> add(Collaborator collaborator) {

        Optional<Collaborator> newCollaborator = Optional.empty();
        boolean operationSuccess = false;

        if (validateCollaborator(collaborator)) {
            newCollaborator = Optional.of(collaborator.clone());
            operationSuccess = collaboratorList.add(newCollaborator.get());
        }

        if (!operationSuccess) {
            newCollaborator = Optional.empty();
        }

        return newCollaborator;
    }

    private boolean validateCollaborator(Collaborator collaborator) {
        return false;
    }

    private boolean validateTaskCategory(Collaborator collaborator) {
        boolean isValid = !collaboratorList.contains(collaborator);
        return isValid;
    }


    public List<Collaborator> getCollaboratorList() {
        //This is a defensive copy, so that the repository cannot be modified from the outside.
        return List.copyOf(collaboratorList);
    }

    public Object getCollaboratorRecordRepository() {
        return collaboratorRecordRepository;
    }

    public void setCollaboratorRecordRepository(Object collaboratorRecordRepository) {
        this.collaboratorRecordRepository = collaboratorRecordRepository;
    }

}
