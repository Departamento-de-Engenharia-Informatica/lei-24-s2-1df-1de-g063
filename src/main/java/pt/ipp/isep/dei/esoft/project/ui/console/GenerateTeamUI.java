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

/**
 * User interface for generating a team proposal based on specified criteria.
 */
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

    /**
     * Constructs an instance of GenerateTeamUI.
     */
    public GenerateTeamUI() {
        this.controller = new GenerateTeamController();
        this.jobRepository = JobRepository.getInstance();
        this.skillsRepository = SkillsRepository.getInstance();
        this.scanner = new Scanner(System.in);
        this.teamRepository = TeamRepository.getInstance();
    }

    /**
     * Runs the generate team user interface.
     */
    @Override
    public void run() {
        System.out.println("\n\n--- Generate Team ------------------------");
        requestData();
        if (!error) {
            submitData();
            if (!error) {
                printTeam();
            }
        }
    }

    private void requestData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Max team size?");
        maxSize = requestIntegerInput(sc);

        System.out.println("Min team size?");
        minSize = requestIntegerInput(sc);

        System.out.println("Choose the skills from the following list:");
        error = printSkillList();
        if (!error) {
            boolean continueSelectingSkills = true;
            selectedSkills.clear();
            while (continueSelectingSkills) {
                int choice = requestIntegerInput(sc);
                if (choice >= 0 && choice < skillsRepository.getSkills().size()) {
                    Skill selectedSkill = skillsRepository.getSkills().get(choice);
                    selectedSkills.add(selectedSkill);
                    System.out.println("Do you want to add another skill? (yes/no)");
                    String input = sc.nextLine().toLowerCase();
                    if (!input.equals("yes")) {
                        continueSelectingSkills = false;
                    }
                } else {
                    System.out.println("Invalid choice. Please select a number within the range.");
                }
            }
            System.out.println(selectedSkills);
        }
    }

    private int requestIntegerInput(Scanner scanner) {
        int value;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer value.");
            scanner.nextLine(); // Consume invalid input
        }
        value = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        return value;
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
            System.out.println("Do you want to generate another team? (yes/no)");
            String input = scanner.nextLine().toLowerCase();
            if (!input.equals("yes")) {
                generateAnother = false;
            }
        }
    }

    private void printTeam() {
        if (!error) {
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
                System.out.printf("%d - %s%n", choice, skill);
                choice++;
            }
            return false;
        }
    }
}
