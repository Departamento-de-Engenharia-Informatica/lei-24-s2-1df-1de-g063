package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;

import javax.crypto.spec.PSource;

public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private final AuthenticationController ctrl;

    public LoginController() {
        this.ctrl = new AuthenticationController();
    }

    @FXML
    protected void handleLogin(ActionEvent event) throws Exception {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean success = ctrl.doLogin(username, password);
        if (success) {
            String userType = ctrl.getUsernameFromEmail(username); // Get the user type
            String uiPath = ctrl.getUIPath(userType); // Get the path to the FXML file

            Stage stage = (Stage) usernameField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(uiPath));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(userType+" UI");
            stage.show();
            System.out.println(userType+"UI");
        } else {
            Alert alert  = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }

    }
}