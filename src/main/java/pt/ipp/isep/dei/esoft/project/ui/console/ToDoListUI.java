package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.*;
        import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.util.List;
import java.util.Scanner;

public class ToDoListUI implements Runnable {
    private final ToDoListController controller;
    private final ToDoList toDoList;
    private final Scanner scanner;
    private final GreenSpaceRepository greenSpaceRepository;
    private int choice;
    private String name;
    private String task;
    private Urgency urgency;
    private int duration;
    private GreenSpace greenSpace;
    private Status status;

    public ToDoListUI() {
        this.controller = new ToDoListController();
        this.toDoList = Repositories.getInstance().getToDoList();
        this.scanner = new Scanner(System.in);
        this.greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
    }

    @Override
    public void run() {
        System.out.println("\n\n--- Add a new Entry to To-Do List ------------------------");
        requestData();
        submitData();
    }

    private void requestData() {
        this.task = requestTask();
        this.urgency = requestUrgency();
        this.duration = requestDuration();
    }

    private void submitData() {
        // Here you should add the logic to create a new task with the collected data
        // For now, we are just printing the task details
        System.out.println("Task: " + task);
        System.out.println("Urgency: " + urgency);
        System.out.println("Duration: " + duration);
        System.out.println(toDoList.getToDoList());
    }

    private String requestTask() {
        System.out.print("Task: ");
        return scanner.nextLine();
    }

    private Urgency requestUrgency() {
        int choice = 0;
        System.out.println("\n--- Urgency List -------------------------");
        for (Urgency urgency : Urgency.values()) {
            System.out.printf("%d - %s%n", choice, urgency);
            choice++;
        }
        System.out.print("Choose an urgency (0-" + (Urgency.values().length - 1) + "): ");
        int selectedUrgencyIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        return Urgency.values()[selectedUrgencyIndex];
    }

    private int requestDuration() {
        System.out.print("Duration of the task: ");
        return scanner.nextInt();
    }
}
