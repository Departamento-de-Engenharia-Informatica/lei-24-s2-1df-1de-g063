package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.application.session.UserSession;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.GreenSpaceRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;


import java.util.List;
import java.util.Scanner;

public class ToDoListUI implements Runnable{
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

    }

    private void submitData() {
        System.out.println(toDoList.getToDoList());
    }

    private String requestTask() {
        System.out.print("Task: ");
        return scanner.nextLine();
    }

    private int requestUrgency() {
        choice = 0;
        System.out.println("\n--- Urgency List -------------------------");
        System.out.println(urgency);
        for (Urgency urgency1 : urgency) {
            System.out.printf("%d - %s%n", choice, urgency1);
            choice++;
        }
        return scanner.nextInt();
    }

    private String requestDuration() {
        System.out.print("Duration of the task: ");
        return scanner.nextLine();
    }

}

