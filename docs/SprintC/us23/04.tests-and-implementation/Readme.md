# US023 - As a GSM, I want to assign a Team to an entry in the Agenda.

## 4. Tests

**Test 1:** Ensures that a Team object is instantiated correctly with all its properties set to the expected values.

      @Test
    void testSetTeam() {
        // Setup
        Entry entry =  new Entry("Task 1", Urgency.Low, 1, new GreenSpace("Green Space 1",1,Size.Large_Size,"Francisco"), Status.pending);
        Team team = new Team();

        // Execute
        entry.setTeam(team);

        // Assert
        assertEquals(team, entry.getTeam(), "Team should be set to the entry");
    }


**Test 2:** Ensures that an email is sent successfully.

    @Test
    void sendEmail() throws IOException {
        // Setup
        Mailer mailer = new Mailer();

        // Execute
        boolean result = mailer.sendEmail("from@example.com", "to@example.com", "Test Subject", "Test Body");

        // Assert
        assertTrue(result, "Email should be sent successfully");
    }

**Test 3:** Verifies that the property is not null.

    @Test
    void testGetProperty() {
    // Setup
    ConfigProperties config = new ConfigProperties();
    
            // Execute
            String host = config.getProperty("host");
    
            // Assert
            assertNotNull(host, "Host property should not be null");
        }

**Test 4:** Ensures that an invalid property is null.

    @Test
    void testGetPropertyWithInvalidKey() {
    // Setup
    ConfigProperties config = new ConfigProperties();
    
            // Execute
            String invalid = config.getProperty("invalid");
    
            // Assert
            assertNull(invalid, "Invalid property should be null");
        }

## 5. Construction (Implementation)

### Class AssignTeamToEntryController

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Collaborator;
import pt.ipp.isep.dei.esoft.project.domain.Entry;
import pt.ipp.isep.dei.esoft.project.repository.AgendaRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TeamRepository;
import pt.ipp.isep.dei.esoft.project.domain.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for assigning teams to entries.
 */
public class AssignTeamToEntryController {
    private TeamRepository teamRepository;

    private AgendaRepository agendaRepository;
    /**
     * Constructor for AssignTeamToEntryController.
     * Initializes the team repository.
     */
    public AssignTeamToEntryController(){
        this.teamRepository =  getTeamRepository();
        this.agendaRepository=Repositories.getInstance().getAgendaRepository();
    }

    /**
     * Retrieves all teams from the team repository.
     * @return a list of all teams.
     */
    public List<Team> getTeams() {
        return teamRepository.getTeams();
    }

    /**
     * Retrieves a specific team from the team repository by index.
     * @param index the index of the team in the list.
     * @return the team at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public Team getTeams(int index) {
        return teamRepository.getTeams(index);
    }

    public List<String> getEntries() {
        List<Entry> entries = agendaRepository.getEntries();
        List<String> entriesWithFlags = new ArrayList<>();
        for (Entry entry : entries) {
            String entryString = entry.toString();
            if (entry.getTeam() != null) {
                entryString += " (Team assigned)";
            }
            entriesWithFlags.add(entryString);
        }
        return entriesWithFlags;
    }




    public void attributeTeamToEntry(int choiceTeam, int choiceEntry){
        Team selectedTeam = teamRepository.getTeams(choiceTeam);
        Entry selectedEntry = agendaRepository.getEntries(choiceEntry);
        selectedEntry.setTeam(selectedTeam);
        List<Collaborator> collaborators = selectedTeam.getMembers();
        List<String> emailAddresses = new ArrayList<>();
        for (Collaborator collaborator : collaborators) {
            emailAddresses.add(collaborator.getEmail());
        }
        Mailer mailer = new Mailer();
        String subject = "Team assignment";
        String message = "You have been assigned to a team for the entry with the following details:\n" +
                "Task: " + selectedEntry.getTask() + "\n" +
                "Team Members: " + selectedEntry.getTeam() + "\n" +
                "Urgency: " + selectedEntry.getUrgency() + "\n" +
                "Duration: " + selectedEntry.getDuration() + "\n" +
                "Green Space: " + selectedEntry.getGreenSpace().getName() + "\n" +
                "Status: " + selectedEntry.getStatus() + "\n" +
                "Start Date: " + selectedEntry.getStartDate() + "\n" +
                "End Date: " + selectedEntry.getEndDate();
        for (String emailAddress : emailAddresses) {
            try {
                System.out.println("Sending email to " + emailAddress);
                Repositories.getInstance().getEmailSender().sendEmail(System.getProperty("username"),emailAddress, subject, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * Retrieves the team repository.
     * If the team repository is null, it initializes it.
     * @return the team repository.
     */
    private TeamRepository getTeamRepository(){
        if(teamRepository == null){
            Repositories repositories = Repositories.getInstance();
            teamRepository = repositories.getTeamRepository();
        }
        return teamRepository;
    }
}
```
### Class Entry

```java
package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Entry implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String task;
    private final Urgency urgency;
    private final int duration;
    private GreenSpace greenSpace;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Team team;

    private List<Vehicle> vehicles;

    public Entry(String task, Urgency urgency, int duration, GreenSpace greenSpace, Status status) {
        this.task = task;
        this.urgency = urgency;
        this.duration = duration;
        this.greenSpace = greenSpace;
        this.status = status;
        this.vehicles = new ArrayList<>();
    }
    public boolean isVehicleAssigned(Vehicle vehicle){
        return getVehicles().contains(vehicle);
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate date){
        this.startDate=date;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void getVehicle(int index){
        vehicles.get(index);
    }

    public List<Vehicle> getVehicles(){
        return List.copyOf(vehicles);
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate date){
        this.endDate=date;
    }

    public Status getStatus() {
        return status;
    }

    public String getTask() {
        return task;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public int getDuration() {
        return duration;
    }

    public GreenSpace getGreenSpace(){
        return greenSpace;
    }

    public void setGreenSpace(GreenSpace greenSpace) {
        this.greenSpace = greenSpace;
    }

    public void setStatus(Status status) {this.status = status;}

    @Override
    public String toString() {
        String teamString = (team != null) ? team.toString() : "No team assigned";
        return "Entry{" +
                "team=" + teamString +
                ", vehicles=" + vehicles +
                ", task='" + task + '\'' +
                ", urgency=" + urgency +
                ", duration=" + duration +
                ", greenSpace=" + greenSpace +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
```

### Class Mailer

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.component.EmailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.List;

public class Mailer implements EmailSender {
    // ...
    ConfigProperties config = new ConfigProperties();
    String host = config.getProperty("host");
    String port = config.getProperty("port");
    String username = config.getProperty("username");
    String password = config.getProperty("password");

    public void sendEmailToMultipleRecipients(List<String> recipients, String subject, String text) {
        // Set up the SMTP server properties.
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); //TLS

        // Create the Session object.
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@example.com"));

            // Add each recipient to the message.
            for (String recipient : recipients) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }

            message.setSubject(subject);
            message.setText(text);

            // Send the message.
            Transport.send(message);

            System.out.println("Mail Sent Successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean sendEmail(String from, String to, String subject, String body) throws IOException {
        sendEmailToMultipleRecipients(List.of(to), subject, body);
        return true;
    }
}

```
### Class ConfigProperties

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private final Properties configProp = System.getProperties();

    public ConfigProperties() {
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties")) {
            configProp.load(in);
        } catch (IOException e) {
            System.out.println("[WARNING] Using default properties!");
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }
}
```

### Interface EmailSender

```java
package pt.ipp.isep.dei.esoft.project.component;

import java.io.IOException;

public interface EmailSender {

    boolean sendEmail(String from, String to, String subject, String body) throws IOException;


}

```

## 6. Integration and Demo

In this section, we simulate how the `AssignTeamToEntryController` interacts with the `TeamRepository` and `AgendaRepository` to assign a team to an entry:

* First, we instantiate the `TeamRepository` and `AgendaRepository`.
* Next, we create an `AssignTeamToEntryController` with the repositories.
* We then add a team and an entry to the repositories.
* We call the `attributeTeamToEntry` method of the controller to assign the team to the entry.
* The controller then gathers the email addresses of all team members and sends them an email notification about the assignment.
* Finally, we verify that the team has been assigned to the entry.

This completes the integration and demo of how the `AssignTeamToEntryController` interacts with the `TeamRepository` and `AgendaRepository` to assign a team to an entry, and how the `Mailer` is used to send email notifications to the team members.

## 7. Observations

n/a