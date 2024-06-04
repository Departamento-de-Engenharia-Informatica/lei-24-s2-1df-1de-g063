package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.domain.Status;
import pt.ipp.isep.dei.esoft.project.domain.Urgency;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;


public class ToDoListPageController {
    @FXML
    private ListView<Entry> toDoListListView;
    private final ToDoListController toDoListController;

    @FXML
    private TextField taskField;
    @FXML
    private TextField durationField;
    @FXML
    private ChoiceBox<Urgency> selectUrgency;
    @FXML
    private ChoiceBox<GreenSpace> selectGreenSpace;
    private final GreenSpaceRepository greenSpaceRepository;


    public ToDoListPageController() {
        this.toDoListController = new ToDoListController();
        this.greenSpaceRepository = new GreenSpaceRepository();
    }

    @FXML
    protected void registerEntry() {
        try {
            // Get duration
            int duration = Integer.parseInt(durationField.getText());

            // Get task description
            String task = taskField.getText();

            // Get selected urgency
            Urgency urgency = selectUrgency.getValue();

            // Get selected green space
            GreenSpace greenSpace = selectGreenSpace.getValue();

            // Create a new Entry object
            Entry entry = new Entry(task, urgency, duration, greenSpace, Status.pending);

            // Register the entry using the controller
            toDoListController.registerEntry(task, urgency, duration, greenSpace, Status.pending);

            // Update the ListView
            toDoListListView.getItems().add(entry);

            // Clear input fields
            taskField.clear();
            durationField.clear();
            selectUrgency.setValue(null);
            selectGreenSpace.setValue(null);
        } catch (NumberFormatException e) {
            // Handle invalid input for duration
            System.out.println("Invalid input for duration");
        }
    }

    @FXML
    public void initialize() {
        // Initialize urgency choices
        selectUrgency.getItems().setAll(Urgency.values());

        // Initialize green space choices from the repository
        selectGreenSpace.getItems().setAll(greenSpaceRepository.getGreenSpaces());
    }
}
