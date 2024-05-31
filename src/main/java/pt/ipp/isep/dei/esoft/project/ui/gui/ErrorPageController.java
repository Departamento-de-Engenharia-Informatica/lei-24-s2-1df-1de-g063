package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrorPageController {
    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        errorLabel.setText("An error has occurred.");
    }
}