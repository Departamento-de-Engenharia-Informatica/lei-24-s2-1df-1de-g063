package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.GreenSpaceListController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterGreenSpaceController;
import pt.ipp.isep.dei.esoft.project.domain.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.MergeSort;
import pt.ipp.isep.dei.esoft.project.domain.SelectionSort;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class GetManagerGreenSpaceController {

    @FXML
    private TextField nameField;

    @FXML
    private Button backButton;

    @FXML
    private Label labelGreenSpaceList;

    @FXML
    private ListView<GreenSpace> listOfGreenSpaces;

    private GreenSpaceListController controller;
    private RegisterGreenSpaceController registerController;

    @FXML
    public void initialize() {
        controller = new GreenSpaceListController();
        registerController = new RegisterGreenSpaceController();
    }

    @FXML
    public void loadGreenSpaces() {
        try {
            String name = nameField.getText();
            if (name == null || name.isEmpty()) {
                showAlert("Input Error", "Please enter a collaborator name.");
                return;
            }

            GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
            List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpacesByName(name);

            if (greenSpaces == null || greenSpaces.isEmpty()) {
                showAlert("No Results", "No green spaces found for the provided name.");
                return;
            }

            sortGreenSpaces(greenSpaces);

            listOfGreenSpaces.getItems().setAll(FXCollections.observableArrayList(greenSpaces));

        } catch (Exception e) {
            showAlert("Error", "Failed to load green spaces: " + e.getMessage());
        }
    }

    @FXML
    private List<GreenSpace> sortGreenSpaces(List<GreenSpace> greenSpaces) {
        String algorithm = getSortingAlgorithm();
        switch (algorithm) {
            case "SelectionSort":
                new SelectionSort().selectionSortListGreenSpaces(greenSpaces);
                break;
            case "MergeSort":
                new MergeSort().mergeSortGreenSpaces(greenSpaces);
                break;
            case "BubbleSort":
                new BubbleSort().bubbleSortListGreenSpaces(greenSpaces);
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting algorithm specified");
        }
        return greenSpaces;
    }

    @FXML
    private String getSortingAlgorithm() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Configuration file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
        return properties.getProperty("sorting.algorithm", "MergeSort");
    }

    @FXML
    public void goBack() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
