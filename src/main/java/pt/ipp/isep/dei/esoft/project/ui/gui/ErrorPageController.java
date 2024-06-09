package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The ErrorPageController class controls the error page GUI.
 * It initializes the error label with an error message.
 */
public class ErrorPageController {

    @FXML
    private Label errorLabel;

    /**
     * Initializes the error page.
     * Sets the error label text to indicate that an error has occurred.
     */
    @FXML
    public void initialize() {
        errorLabel.setText("An error has occurred.");
    }
}
