package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;
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
        addGreenSpaces();
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
        //TODO: add bootstrap Task Categories here

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

    private void addGreenSpaces(){
        GreenSpaceRepository greenSpaceRepository = Repositories.getInstance().getGreenSpaceRepository();
        GreenSpace greenSpace1 = new GreenSpace("Park",250, Size.Garden,"Paulo");
        GreenSpace greenSpace2 = new GreenSpace("Garden",1904,Size.Large_Size, "Carlos");

        greenSpaceRepository.addGreenSpace(greenSpace1);
        greenSpaceRepository.addGreenSpace(greenSpace2);
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
        Collaborator collaborator1 = new Collaborator("Gabriel Silvinha", "123 Street", "ze.rafa.oliveira@gmail.com", "1234567890", "passaporte", "br123456", LocalDate.of(1980, 1, 1), LocalDate.of(2020, 1, 1), "Developer");
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

        //add entry to repository

        Entry entry1 = new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        Entry entry2 = new Entry("Task 2", Urgency.Medium, 2, new GreenSpace("Green Space 2",2,Size.Medium_Size,"Francisco"),Status.pending);
        Entry entry3 = new Entry("Task 2", Urgency.Medium, 2, new GreenSpace("Green Space 2",2,Size.Medium_Size,"Francisco"),Status.pending);
        Entry entry4 = new Entry("Task 2", Urgency.Medium, 2, new GreenSpace("Green Space 2",2,Size.Medium_Size,"Francisco"),Status.pending);
        ToDoList toDoList = Repositories.getInstance().getToDoList();
        toDoList.addEntry(entry1);
        toDoList.addEntry(entry2);
        toDoList.addEntry(entry3);
        toDoList.addEntry(entry4);

        Entry entry5 = new Entry("Task 3", Urgency.Low, 1, new GreenSpace("Green Space 3",1,Size.Large_Size,"Francisco"), Status.scheduled);
        Entry entry6 = new Entry("Task 4", Urgency.Low, 1, new GreenSpace("Green Space 4",1,Size.Large_Size,"Francisco"), Status.scheduled);
        Entry entry7 = new Entry("Task 4", Urgency.Low, 1, new GreenSpace("Green Space 4",1,Size.Large_Size,"Francisco"), Status.scheduled);
        AgendaRepository agenda = Repositories.getInstance().getAgendaRepository();
        agenda.addEntry(entry5);
        agenda.addEntry(entry6);
        agenda.addEntry(entry7);

        //add team to entry

//        entry1.setTeam(team1);
//        entry2.setTeam(team2);
//        entry3.setTeam(team3);
//        entry4.setTeam(team1);
//        entry5.setTeam(team2);
//        entry6.setTeam(team3);
//        entry7.setTeam(team1);

        //add date to entry

        entry1.setStartDate(LocalDate.of(2020, 1, 1));
        entry1.setEndDate(LocalDate.of(2020, 1, 4));
        entry2.setStartDate(LocalDate.of(2021, 1, 1));
        entry2.setEndDate(LocalDate.of(2021, 1, 4));
        entry3.setStartDate(LocalDate.of(2022, 1, 5));
        entry3.setEndDate(LocalDate.of(2022, 1, 7));
        entry4.setStartDate(LocalDate.of(2023, 1, 1));
        entry4.setEndDate(LocalDate.of(2023, 1, 5));
        entry5.setStartDate(LocalDate.of(2024, 1, 1));
        entry5.setEndDate(LocalDate.of(2024, 1, 4));
        entry6.setStartDate(LocalDate.of(2025, 1, 1));
        entry6.setEndDate(LocalDate.of(2025, 1, 4));
        entry7.setStartDate(LocalDate.of(2026, 1, 1));
        entry7.setEndDate(LocalDate.of(2026, 1, 4));


        //add vehicle to repository

        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 1000, 2000, 10000, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000);
        Vehicle vehicle2 = new Vehicle("Peugeot", "do aço", 1000, 2000, 10000, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 1), 10000);

        VehicleRepository vehicleRepository = Repositories.getInstance().getVehicleRepository();
        vehicleRepository.addVehicle(vehicle1);
        vehicleRepository.addVehicle(vehicle2);

    }
}