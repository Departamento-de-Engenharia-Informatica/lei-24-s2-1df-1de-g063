package pt.ipp.isep.dei.esoft.project.ui.console;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import pt.ipp.isep.dei.esoft.project.application.controller.AssignSkillController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.ArrayList;
import java.util.List;

public class AssignSkillPageController {

    private final AssignSkillController controller;
    private final CollaboratorRepository collaboratorRepository;
    private final SkillsRepository skillsRepository;

    @FXML
    private ComboBox<Collaborator> collaboratorComboBox;

    @FXML
    private ComboBox<Skill> skillComboBox;

    @FXML
    private ListView<Skill> selectedSkillsListView;

    public AssignSkillPageController() {
        controller = new AssignSkillController();
        collaboratorRepository = CollaboratorRepository.getInstance();
        skillsRepository = SkillsRepository.getInstance();
    }

    public void init() {
        collaboratorComboBox.setItems(FXCollections.observableArrayList(collaboratorRepository.getCollaborators()));
        skillComboBox.setItems(FXCollections.observableArrayList(skillsRepository.getSkills()));
    }

    @FXML
    private void addSkill() {
        Skill selectedSkill = skillComboBox.getValue();
        if (selectedSkill != null && !selectedSkillsListView.getItems().contains(selectedSkill)) {
            selectedSkillsListView.getItems().add(selectedSkill);
        }
    }

    @FXML
    private void submitData() {
        Collaborator selectedCollaborator = collaboratorComboBox.getValue();
        if (selectedCollaborator == null) {
            System.out.println("No collaborator selected.");
            return;
        }

        List<Skill> selectedSkills = new ArrayList<>(selectedSkillsListView.getItems());

        List<Skill> existingSkills = selectedCollaborator.getSkills();
        if (existingSkills != null) {
            existingSkills.addAll(selectedSkills);
        } else {
            selectedCollaborator.setSkills(selectedSkills);
        }

        System.out.println(selectedCollaborator.getSkills());
    }
}
