//package pt.ipp.isep.dei.esoft.project.ui.console;
//
//import pt.ipp.isep.dei.esoft.project.application.controller.AgendaController;
//import pt.ipp.isep.dei.esoft.project.application.controller.RegisterCollaboratorController;
//import pt.ipp.isep.dei.esoft.project.domain.Agenda;
//import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
//import pt.ipp.isep.dei.esoft.project.domain.Job;
//import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
//import pt.ipp.isep.dei.esoft.project.repository.JobRepository;
//import pt.ipp.isep.dei.esoft.project.repository.ToDoList;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * User interface for registering collaborators.
// */
//public class AgendaUI implements Runnable {
//    private final AgendaController controller;
//    private final AgendaRepository agendaRepository;
//    private final ToDoList toDoList;
//    private final Scanner scanner;
//
//
//    public RegisterCollaboratorUI() {
//        this.controller = new AgendaController();
//        this.agendaRepository = AgendaRepository.getInstance();
//        this.toDoList = ToDoList.getInstance();
//        this.scanner = new Scanner(System.in);
//    }
//
//    @Override
//    public void run() {
//        System.out.println("\n\n--- Register Collaborator ------------------------");
//        requestData();
//        submitData();
//        printCollaborator();
//    }
//
//    private void requestData() {
//        entry = requestEntry();
//    }
//    private String requestEntry() {
//        List<ToDoList> entrys = toDoList.getToDoList();
//        System.out.println("\n--- Entrys List -------------------------");
//        if (entrys.isEmpty()) {
//            System.out.println("No entrys registered yet.");
//            return "";
//        } else {
//            for (int i = 0; i < entrys.size(); i++) {
//                System.out.printf("%d - %s%n", i + 1, entrys.get(i));
//            }
//            System.out.print("Choose an entry (enter the number): ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            if (choice > 0 && choice <= entrys.size()) {
//                return entrys.get(choice - 1).toString();
//            } else {
//                System.out.println("Invalid choice. Please choose a valid entry.");
//                return requestEntry();
//            }
//        }
//    }
//
//    private void submitData() {
//        entry = controller.registerEntry(entry_agenda);
//        agendaRepository.addEntry_Agenda(entry_agenda);
//    }
//
//    private void printCollaborator() {
//        int contador = 1;
//        List<Agenda> entrys_agenda = agendaRepository.getEntrys_Agenda();
//        System.out.println("\n--- Entrys List -------------------------");
//        for (Agenda entry_agenda : entrys_agenda) {
//            System.out.printf("%d - %s%n", contador, entry_agenda);
//            contador++;
//        }
//    }
//}

