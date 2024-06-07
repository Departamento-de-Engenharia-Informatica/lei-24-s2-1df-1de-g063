package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.IOException;
import java.util.Objects;

public class RegisterGreenSpacePageController {
    @FXML
    private ListView<GreenSpace> greenSpaceListView;
    private final RegisterGreenSpaceController controller;

    @FXML
    private TextField nameField;
    @FXML
    private TextField managerField;
    @FXML
    private TextField areaField;
    private GreenSpaceRepository greenSpaceRepository;

    public RegisterGreenSpacePageController() {
        this.controller = new RegisterGreenSpaceController();
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    }

    @FXML
    protected void registerGreenSpace() {
        try {
            String name = nameField.getText();
            if (name == null || name.trim().isEmpty()) {
                showAlert("Name cannot be empty.");
                return;
            }

            if (!name.matches("[a-zA-Z- ]+")) {
                showAlert("Name can only contain letters and hyphens.");
                return;
            }

            String managerName = managerField.getText();
            if (managerName == null || managerName.trim().isEmpty()) {
                showAlert("Manager name cannot be empty.");
                return;
            }

            if (!managerName.matches("[a-zA-Z- ]+")) {
                showAlert("Manager name can only contain letters and hyphens.");
                return;
            }

            double area = Double.parseDouble(areaField.getText());
            if (area <= 0) {
                showAlert("Area must be a positive number.");
                return;
            }

            Size size = getSize(area);
            GreenSpace greenSpace = new GreenSpace(name, area, size, managerName);
            greenSpaceRepository.addGreenSpace(greenSpace);
            System.out.println(greenSpaceRepository.getGreenSpaces());
            greenSpaceListView.getItems().add(greenSpace);
            nameField.clear();
            areaField.clear();
            managerField.clear();
        } catch (NumberFormatException e) {
            showAlert("Invalid input for area. Please enter a positive number.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Size getSize(double area) {
        if (area > 0) {
            if (area < 50.0) {
                return Size.Garden;
            } else if (area <= 200.0) {
                return Size.Medium_Size;
            } else {
                return Size.Large_Size;
            }
        } else {
            throw new NumberFormatException("Area must be a positive integer");
        }
    }

    @FXML
    protected void handleGOBACK (ActionEvent event) {
        try {
            Parent assignTeamPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GSMUI.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(assignTeamPage);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
