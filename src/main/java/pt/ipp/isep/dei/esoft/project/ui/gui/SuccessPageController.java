package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;
import pt.isep.lei.esoft.auth.domain.model.UserRole;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

public class SuccessPageController {
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        String email = ApplicationSession.getInstance().getCurrentSession().getUserEmail();
        welcomeLabel.setText("Welcome, " + email + "!");
    }
}