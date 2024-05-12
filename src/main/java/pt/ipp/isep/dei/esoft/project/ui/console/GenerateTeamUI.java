package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.ipp.isep.dei.esoft.project.repository.JobRepository;
import pt.ipp.isep.dei.esoft.project.repository.SkillsRepository;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class GenerateTeamUI implements Runnable {
    private final GenerateTeamController controller;
    private final JobRepository jobRepository;
    private final SkillsRepository skillsRepository;

    private final TeamRepository teamRepository;
    private final Scanner scanner;

    private int maxSize;

    private int minSize;

    private int choice;
    private List<Skill> selectedSkills = new ArrayList<>();

    private boolean error = false;

    private Team teamProposal;

    // Define any additional fields needed to collect team information

    public GenerateTeamUI() {
        this.controller = new GenerateTeamController();
        this.jobRepository = JobRepository.getInstance();
        this.skillsRepository = SkillsRepository.getInstance();
        this.scanner = new Scanner(System.in);
        this.teamRepository = new TeamRepository();
    }

    @Override
    public void run() {
        System.out.println("\n\n--- Generate Team ------------------------");
        // Call methods to collect team information
        requestData();
        // Call method to submit team data

            submitData();
        if(!error){
            printTeam();

        }

    }

    private void requestData() {
        Scanner sc = new Scanner(System.in);

        // Request and validate max team size
        System.out.println("Max team size?");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer value.");
            sc.nextLine(); // Consume invalid input
        }
        maxSize = sc.nextInt();
        sc.nextLine(); // Consume newline character

        // Request and validate min team size
        System.out.println("Min team size?");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer value.");
            sc.nextLine(); // Consume invalid input
        }
        minSize = sc.nextInt();
        sc.nextLine(); // Consume newline character

        // Choose skills from the list
        System.out.println("Choose the skills from the following list:");
        boolean error = printSkillList();
        if (!error) {
            boolean continueSelectingSkills = true;
            selectedSkills.clear();
            while (continueSelectingSkills) {
                // Request and validate skill choice
                int choice;
                System.out.println("Enter the number corresponding to the skill:");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer value.");
                    sc.nextLine(); // Consume invalid input
                }
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline character

                // Validate skill choice
                if (choice < 0 || choice >= skillsRepository.getSkills().size()) {
                    System.out.println("Invalid choice. Please select a number within the range.");
                    continue;
                }

                Skill selectedSkill = skillsRepository.getSkills().get(choice);
                selectedSkills.add(selectedSkill);

                // Ask if user wants to add another skill
                System.out.println("Do you want to add another skill? (yes/no)");
                String input = sc.nextLine().toLowerCase();
                if (!input.equals("yes")) {
                    continueSelectingSkills = false;
                }
            }
            System.out.println(selectedSkills);
        }
    }



    private void submitData() {

        boolean generateAnother = true;
        while (generateAnother) {
            teamProposal = controller.generateTeamProposal(minSize, maxSize, selectedSkills);
            if (teamProposal == null) {
                error = true;
            } else {
                System.out.println("Team proposal generated successfully:");
                printTeam();
                System.out.println("Do you accept this team proposal? (yes/no)");
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("yes")) {
                    TeamRepository.addTeams(teamProposal);
                    System.out.println("Team added to repository.");
                }
            }

            // Ask the user if they want to generate another team
            System.out.println("Do you want to generate another team? (yes/no)");
            String input = scanner.nextLine().toLowerCase();
            if (!input.equals("yes")) {
                generateAnother = false;
            }
        }
    }



    private void printTeam() {
        if(!error){
            System.out.println("Team members: ");
            System.out.println(teamProposal.getMembers());

        }


    }
    private boolean printSkillList() {
        choice = 0;
        List<Skill> skills = skillsRepository.getSkills();
        System.out.println("\n--- Skills List -------------------------");
        if (skills.isEmpty()) {
            System.out.println("No Skills registered yet.");
            return true;
        } else {
            for (Skill skill : skills) {
                System.out.printf("%d - %s%n",choice,skill);
                choice++;
            }
            return false;
        }
    }

    // Implement any additional methods needed to collect team information
}
