package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addTaskCategories();
        addOrganization();
        addUsers();
    }

    private void addOrganization() {
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("employee@this.app"));
        organization.addEmployee(new Employee("hrm@this.app"));
        organizationRepository.add(organization);
    }

    private void addTaskCategories() {

        //get task category repository
        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }


    private void addUsers() {
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_HRM, AuthenticationController.ROLE_HRM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_GSM, AuthenticationController.ROLE_GSM);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_EMPLOYEE, AuthenticationController.ROLE_EMPLOYEE);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_VFM, AuthenticationController.ROLE_VFM);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_EMPLOYEE);

        authenticationRepository.addUserWithRole("Human Resource Manager", "hrm@this.app", "hrm",
                AuthenticationController.ROLE_HRM);

        authenticationRepository.addUserWithRole("Vehicle and Equipment Fleet Manager", "vfm@this.app","vfm",
                AuthenticationController.ROLE_VFM);
        authenticationRepository.addUserWithRole("Green Spaces Manager", "gsm@this.app","gsm",
                AuthenticationController.ROLE_GSM);

// Create more Collaborator objects
        Collaborator collaborator1 = new Collaborator("Gabriel Silva", "123 Street", "gabsilvatex@gmail.com", "1234567890", "passaporte", "br123456", LocalDate.of(1980, 1, 1), LocalDate.of(2020, 1, 1), "Developer");
        Collaborator collaborator2 = new Collaborator("Jane Smith", "456 Avenue", "janesmith@this.app", "0987654321", "passaporte", "br123456", LocalDate.of(1985, 2, 2), LocalDate.of(2020, 2, 2), "Tester");
        Collaborator collaborator3 = new Collaborator("Bob Johnson", "789 Boulevard", "bobjohnson@this.app", "1122334455", "passaporte", "br123456", LocalDate.of(1990, 3, 3), LocalDate.of(2020, 3, 3), "Manager");
        Collaborator collaborator4 = new Collaborator("Alice Williams", "1010 Street", "alicewilliams@this.app", "1212121212", "passaporte", "br123456", LocalDate.of(1981, 4, 4), LocalDate.of(2020, 4, 4), "Developer");
        Collaborator collaborator5 = new Collaborator("Charlie Brown", "2020 Avenue", "charliebrown@this.app", "1313131313", "passaporte", "br123456", LocalDate.of(1982, 5, 5), LocalDate.of(2020, 5, 5), "Tester");
        Collaborator collaborator6 = new Collaborator("David Johnson", "3030 Boulevard", "davidjohnson@this.app", "1414141414", "passaporte", "br123456", LocalDate.of(1983, 6, 6), LocalDate.of(2020, 6, 6), "Manager");

// Create a list of all collaborators
        List<Collaborator> allCollaborators = new ArrayList<>(Arrays.asList(collaborator1, collaborator2, collaborator3, collaborator4, collaborator5, collaborator6));

// Shuffle the list to distribute the collaborators randomly
        Collections.shuffle(allCollaborators);

// Split the shuffled list into three lists
        List<Collaborator> collaboratorsList1 = new ArrayList<>(allCollaborators.subList(0, 2));
        List<Collaborator> collaboratorsList2 = new ArrayList<>(allCollaborators.subList(2, 4));
        List<Collaborator> collaboratorsList3 = new ArrayList<>(allCollaborators.subList(4, 6));

// Create three Team objects and add the collaborators from each list to a team
        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();

        team1.setMembers(collaboratorsList1);
        team2.setMembers(collaboratorsList2);
        team3.setMembers(collaboratorsList3);
        // Create a TeamRepository
        TeamRepository teamRepository = Repositories.getInstance().getTeamRepository();

// Add the teams to the repository
        teamRepository.addTeams(team1);
        teamRepository.addTeams(team2);
        teamRepository.addTeams(team3);
    }
}