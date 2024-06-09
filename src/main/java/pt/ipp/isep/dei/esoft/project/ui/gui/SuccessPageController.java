package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.ipp.isep.dei.esoft.project.application.session.ApplicationSession;

/**
 * The SuccessPageController class controls the success page UI.
 */
public class SuccessPageController {
    @FXML
    private Label welcomeLabel;

    /**
     * Initializes the controller.
     */
    @FXML
    public void initialize() {
        String email = ApplicationSession.getInstance().getCurrentSession().getUserEmail();
        welcomeLabel.setText("Welcome, " + email + "!");
    }
}
