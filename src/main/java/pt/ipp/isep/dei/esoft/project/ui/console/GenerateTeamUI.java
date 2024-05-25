package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.GenerateTeamController;
import pt.ipp.isep.dei.esoft.project.domain.Skill;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User interface for generating a team proposal based on specified criteria.
 */
public class GenerateTeamUI implements Runnable {
    private final GenerateTeamController controller;
    private final Scanner scanner;
    private int maxSize;
    private int minSize;
    private List<Skill> selectedSkills = new ArrayList<>();
    private boolean error = false;
    private Team teamProposal;

    /**
     * Constructs an instance of GenerateTeamUI.
     */
    public GenerateTeamUI() {
        this.controller = new GenerateTeamController();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the generate team user interface.
     */
    @Override
    public void run() {
        boolean continueGenerating = true;
        while (continueGenerating) {
            System.out.println("\n\n--- Generate Team ------------------------");
            requestData();
            if (!error) {
                submitData();
                if (!error) {
                    controller.printTeams();
                }
            }
            continueGenerating = askGenerateAnotherTeam();
        }
    }

    private void requestData() {
        error = false;
        while (true) {
            System.out.println("Please enter the input in the format: maxSize; minSize; <skill1; skill2; skill3>");

            String input = scanner.nextLine().trim();
            String[] parts = input.split(";");

            if (parts.length != 3) {
                System.out.println("Invalid input format. Please use: maxSize; minSize; <skill1; skill2; skill3>");
                continue;
            }

            try {
                maxSize = Integer.parseInt(parts[0].trim());
                minSize = Integer.parseInt(parts[1].trim());

                if (maxSize < 0 || minSize < 0) {
                    System.out.println("Team sizes cannot be negative.");
                    continue;
                }

                if (maxSize < minSize) {
                    System.out.println("Max team size cannot be smaller than min team size.");
                    continue;
                }

                String skillsPart = parts[2].trim();
                if (!skillsPart.startsWith("<") || !skillsPart.endsWith(">")) {
                    System.out.println("Skills should be enclosed in < >.");
                    continue;
                }

                skillsPart = skillsPart.substring(1, skillsPart.length() - 1).trim();
                String[] skillsArray = skillsPart.split(";");

                selectedSkills.clear();
                boolean validSkills = true;
                for (String skillName : skillsArray) {
                    skillName = skillName.trim();
                    if (!skillName.isEmpty()) {
                        Skill skill = controller.getSkillByName(skillName);
                        if (skill != null) {
                            selectedSkills.add(skill);
                        } else {
                            System.out.printf("Skill '%s' is not recognized.%n", skillName);
                            validSkills = false;
                        }
                    }
                }

                if (validSkills) {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Team sizes must be valid integers.");
            }
        }
    }

    private void submitData() {
        teamProposal = controller.generateTeamProposal(minSize, maxSize, selectedSkills);
        if (teamProposal == null) {
            error = true;
        } else {
            System.out.println("Team proposal generated successfully:");
            printTeam();
            System.out.println("Do you accept this team proposal? (yes/no)");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes")) {
                controller.addTeam(teamProposal);
                System.out.println("Team added to repository.");
            }
        }
    }

    private void printTeam() {
        if (!error) {
            System.out.println("Team members: ");
            System.out.println(teamProposal.getMembers());
        }
    }

    private boolean askGenerateAnotherTeam() {
        System.out.println("Do you want to generate another team? (yes/no)");
        String input = scanner.nextLine().toLowerCase();
        return input.equals("yes");
    }
}
