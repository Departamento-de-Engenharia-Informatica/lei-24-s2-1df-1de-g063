package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ToDoListController;
import pt.ipp.isep.dei.esoft.project.domain.GreenSpace;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.ToDoList;

import java.util.List;
import java.util.Scanner;

public class ToDoListUI implements Runnable{
    private final ToDoListController controller;
    private final ToDoList toDoList;
    private final Scanner scanner;

    public ToDoListUI() {
        this.controller = new ToDoListController();
        this.toDoList = Repositories.getInstance().getToDoList();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("\n\n--- Add a new Entry to To-Do List ------------------------");
        requestData();
        submitData();
        printGreenSpace();
    }

    private void requestData() {

    }

    private void submitData() {

    }

    private void printGreenSpace() {
        int contador = 1;
        List<GreenSpace> greenSpaces = greenSpaceRepository.getGreenSpaces();
        System.out.println("\n--- Green Spaces List -------------------------");
        for (GreenSpace greenSpace : greenSpaces) {
            System.out.printf("%d - %s%n", contador, greenSpace);
            contador++;
        }
    }
}

