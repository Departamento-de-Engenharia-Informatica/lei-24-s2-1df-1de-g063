package pt.ipp.isep.dei.esoft.project.ui.console;

/**
 * The DevTeamUI class provides a simple console-based user interface to display information about the development team.
 * It prints out the names and email addresses of the team members.
 * <p>
 * Example usage:
 * <pre>{@code
 * DevTeamUI devTeamUI = new DevTeamUI();
 * devTeamUI.run();
 * }</pre>
 * The output will display the names and email addresses of the development team members.
 */
public class DevTeamUI implements Runnable {

    /**
     * Constructs a DevTeamUI object.
     */
    public DevTeamUI() {

    }

    /**
     * Displays information about the development team.
     * Prints the names and email addresses of the team members to the console.
     */
    public void run() {
        System.out.println("\n");
        System.out.println("--- DEVELOPMENT TEAM -------------------");
        System.out.println("  Francisca Teixeira - 1231119@isep.ipp.pt");
        System.out.println("  Francisco Alves    - 1231200@isep.ipp.pt");
        System.out.println("  Gabriel Silva      - 1231786@isep.ipp.pt");
        System.out.println("  Hugo Silva         - 1231122@isep.ipp.pt");
        System.out.println("  José Oliveira      - 1231154@isep.ipp.pt");
        System.out.println("\n");
    }
}
