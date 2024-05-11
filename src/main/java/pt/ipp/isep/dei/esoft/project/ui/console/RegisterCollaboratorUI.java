package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterCollaboratorController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Job;
import pt.ipp.isep.dei.esoft.project.repository.CollaboratorRepository;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class RegisterCollaboratorUI implements Runnable{
    Scanner scan = new Scanner(System.in);

    private final RegisterCollaboratorController controller;
    private final CollaboratorRepository collaboratorRepository;
    private final JobRepository jobRepository;
    private String name;
    private String adress;
    private String email;
    private String phoneNumber;
    private String idType;
    private String idNumber;
    private LocalDate birthDate;
    private LocalDate admissionDate;
    private String job;
    private Collaborator collaborator;

    public RegisterCollaboratorUI() {
        controller = new RegisterCollaboratorController();
        collaboratorRepository = CollaboratorRepository.getInstance();
        this.jobRepository = JobRepository.getInstance();
    }

    private RegisterCollaboratorController getController() {
        return controller;
    }
    public void run() {
        System.out.println("\n\n--- Register Collaborator ------------------------");
        requestData();
        submitData();
        printCollaborator();
    }

    private void requestData(){
        name = requestName();
        adress = requestAdress();
        email = requestEmail();
        phoneNumber = requestPhoneNumber();
        idType = requestIdType();
        idNumber = requestIdNumber(idType);
        birthDate = requestDate("Collaborator Birthdate: ");
        admissionDate = requestDate("Collaborator Admission Date: ");
        job = requestJob();
    }

    private String requestName() {
        System.out.print("Collaborator name: ");
        return scan.nextLine();
    }

    private String requestAdress() {
        System.out.print("Collaborator adress: ");
        return scan.nextLine();
    }

    private String requestEmail() {
        System.out.print("Collaborator email: ");
        return scan.nextLine();
    }

    private String requestPhoneNumber() {
        String phoneNumber;
        boolean isValid = false;

        do {
            System.out.print("Collaborator phone number (9 digits only): ");
            phoneNumber = scan.nextLine();

            if (phoneNumber.matches("[0-9]+") && phoneNumber.length() == 9) {
                isValid = true;
            } else {
                System.out.println("Invalid phone number. Please enter 9 digits only.");
            }
        } while (!isValid);

        return phoneNumber;
    }

    private String requestIdType() {
        String idType;

        do {
            System.out.print("Collaborator ID type (Cartão de cidadão/Passaporte): ");
            idType = scan.nextLine().trim().toLowerCase();

            if (idType.equals("cartão de cidadão") || idType.equals("passaporte")) {
                return idType;
            } else {
                System.out.println("Invalid ID type. Please enter either 'Cartão de cidadão' or 'Passaporte'.");
            }
        } while (true);
    }

    private String requestIdNumber(String idType) {
        String idNumber;
        boolean isValid;

        do {
            System.out.print("Collaborator ID number: ");
            idNumber = scan.nextLine().trim();

            if (idType.equals("cartão de cidadão")) {
                isValid = idNumber.matches("\\d{8}");
            } else if (idType.equals("passaporte")) {
                isValid = idNumber.matches("[a-zA-Z]{2}\\d{6}");
            } else {
                isValid = false;
            }

            if (!isValid) {
                System.out.println("Invalid ID number. Please enter a valid ID number.");
            }
        } while (!isValid);

        return idNumber;
    }

    private LocalDate requestDate(String prompt) {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            String input = scan.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy/mm/dd:");
            }
        }

        return date;
    }

    private String requestJob() {
        List<Job> jobs = jobRepository.getJobs();
        System.out.println("\n--- Jobs List -------------------------");
        if (jobs.isEmpty()) {
            System.out.println("No jobs registered yet.");
            return "";
        } else {
            for (int i = 0; i < jobs.size(); i++) {
                System.out.printf("%d - %s%n", i + 1, jobs.get(i));
            }
            System.out.print("Choose a job (enter the number): ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice > 0 && choice <= jobs.size()) {
                return jobs.get(choice - 1).toString();
            } else {
                System.out.println("Invalid choice. Please choose a valid job.");
                return requestJob();
            }
        }
    }


    private void submitData() {
        collaborator = controller.registerCollaborator(name, adress, email, phoneNumber, idType, idNumber, birthDate, admissionDate, job);
        collaboratorRepository.addCollaborator(collaborator);
    }

    private void printCollaborator() {
        int contador = 1;
        List<Collaborator> collaborators = collaboratorRepository.getCollaborators();
        System.out.println("\n--- Collaborators List -------------------------");
        for (Collaborator collaborator : collaborators) {
            System.out.printf("%d - %s%n",contador,collaborator);
            contador++;
        }
    }

}
