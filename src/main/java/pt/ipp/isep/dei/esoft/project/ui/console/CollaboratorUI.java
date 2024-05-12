package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CollaboratorController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRecordRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Optional;
import java.util.List;

public class CollaboratorUI implements Runnable{
    Scanner scan = new Scanner(System.in);

    private final CollaboratorController collaboratorController;
    private final CollaboratorRecordRepository collaboratorRecordRepository;
    private String email;
    private String name;
    private String address;
    private int phone;
    private String job;
    private String skills;
    private String birthDate;
    private String admissionDate;
    private String IDtype;
    private int taxpayerNumber;
    private int citizenNumber;

    public CollaboratorUI(CollaboratorController collaboratorController) {
        this.collaboratorController = collaboratorController;
        collaboratorController = new CollaboratorController();
        collaboratorRecordRepository = new CollaboratorRecordRepository(); // Instantiated JobRepository
    }

    private CollaboratorController getController() {
        return collaboratorController;
    }

    public void run() {
        System.out.println("\n\n--- Register Collaborator ------------------------");
        requestData();
        submitData();
        printVehicles(); // Added printing jobs after submitting data
    }

    private void requestData() {
        name = requestName();
        email = requestEmail();
        job = requestJob();
        skills = requestSkills();
        phone = (int) requestPhone();
        taxpayerNumber = (int) requestTax();
        citizenNumber = (int) requestCitizen();
        birthDate = requestBirthday();
        admissionDate = requestAdmissionDate();
        IDtype = requestIDtype();

    }

    private LocalDate requestDate(String prompt) {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);
            String input = scan.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy:");
            }
        }

        return date;
    }
    private String requestJob(){
        System.out.println("Job: ");
        return scan.nextLine();
    }
    private String requestSkills(){
        System.out.println("Skills: ");
        return scan.nextLine();
    }

    private String requestName() {
        System.out.println("Name: ");
        return scan.nextLine();
    }

    private String requestEmail() {
        System.out.println("Email: ");
        return scan.nextLine();
    }

    private double requestPhone() {
        System.out.println("Phone: ");
        return scan.nextInt();
    }

    private double requestTax() {
        System.out.println("Taxpayer Number: ");
        return scan.nextInt();
    }

    private double requestCitizen() {
        System.out.println("Citizen Number: ");
        int citizen = scan.nextInt();
        scan.nextLine();
        return citizen;
    }

    private String requestBirthday() {
        System.out.println("Register Birthday: ");
        return scan.nextLine();
    }

    private String requestAdmissionDate() {
        System.out.println("Admission Date: ");
        return scan.nextLine();
    }

    private String requestIDtype() {
        System.out.println("ID type: ");
        return scan.nextLine();
    }

    private void submitData() {
        Optional<Collaborator> collaborator = getController().RegisterCollaborator(email, name, address, phone, job, skills, birthDate, IDtype, taxpayerNumber, citizenNumber, admissionDate);

        if (collaborator.isPresent()) {
            System.out.println("\nCollaborator successfully registered!");
            collaboratorRecordRepository.addCollaborator(collaborator.get()); // Adding the registered vehicle to the repository
        } else {
            System.out.println("\nCollaborator not registered!");
        }
    }


    private void printVehicles() {
        List<Collaborator> collaborators = collaboratorRecordRepository.getCollaborators();
        System.out.println("\n--- Collaborators List -------------------------");
        if (collaborators.isEmpty()) {
            System.out.println("No collaborators registered yet.");
        } else {
            for (Collaborator collaborator : collaborators) {
                System.out.println(collaborator);
            }
        }
    }
}
