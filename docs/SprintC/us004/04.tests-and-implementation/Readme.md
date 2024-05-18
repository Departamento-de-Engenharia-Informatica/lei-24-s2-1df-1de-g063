# US004 - Assign Skills to Collaborator

## 4. Tests 

**Test 1:** Ensure a collaborator object is successfully created with all properties initialized correctly.

    @Test
    void ensureCollaboratorIsCreatedSuccessfully() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotNull(collaborator);
    }

**Test 2:** Ensure the list of skills for a collaborator can be modified.

    @Test
    void ensureSkillListIsMutable() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        List<Skill> skills = new ArrayList<>();
        collaborator.setSkills(skills);
        skills.add(new Skill("Java"));
        assertEquals(1, collaborator.getSkills().size());
    }

**Test 3:** Verify that comparing the same object results in equality.

    @Test
    void testEqualsSameObject() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertEquals(collaborator, collaborator);
    }

**Test 4:** Ensure comparing with a different class returns inequality.

    @Test
    void testEqualsDifferentClass() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator, new Object());
    }

**Test 5:** Assert inequality when comparing with null.

    @Test
    void testEqualsNull() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator, null);
    }

**Test 6:** Verify inequality when comparing different collaborator objects.

    @Test
    void testEqualsDifferentObject() {
        Collaborator collaborator1 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        Collaborator collaborator2 = new Collaborator("Jane Smith", "456 Oak St", "jane.smith@example.com",
                "987554321", "cartão de cidadão", "98765432", LocalDate.of(1995, 5, 5),
                LocalDate.now(), "Tester");
        assertNotEquals(collaborator1, collaborator2);
    }

**Test 7:** Assert inequality when comparing the same object with different attribute values.

    @Test
    void testEqualsSameObjectDifferentValues() {
        Collaborator collaborator1 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123-456-7890", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        Collaborator collaborator2 = new Collaborator("John Doe", "456 Oak St", "john.doe@example.com",
                "123556789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator1, collaborator2);
    }

**Test 8:** Ensure equality when comparing two identical collaborator objects.

    @Test
    void testEqualsSameObjectSameValues() {
        Collaborator collaborator1 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        Collaborator collaborator2 = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertEquals(collaborator1, collaborator2);
    }



## 5. Construction (Implementation)

### Class AssignSkillController 

```java
package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.repository.*;

public class AssignSkillController {
    private CollaboratorRepository collaboratorRepository;
    private SkillsRepository skillsRepository;
    private AuthenticationRepository authenticationRepository;
    
    public AssignSkillController(){
        getCollaboratorRepository();
        getSkillsRepository();
        getAuthenticationRepository();
    }
    
    public AssignSkillController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
        this.collaboratorRepository = CollaboratorRepository.getInstance();
    }
    
    public CollaboratorRepository getCollaboratorRepository() {
        if (collaboratorRepository == null) {
            Repositories repositories = Repositories.getInstance();
            collaboratorRepository = repositories.getCollaboratorRepository();
        }
        return collaboratorRepository;
    }
    
    public SkillsRepository getSkillsRepository() {
        if(skillsRepository == null) {
            Repositories repositories = Repositories.getInstance();
            skillsRepository = repositories.getSkillsRepository();
        }
        return skillsRepository;
    }
    
    public AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
}

```


## 6. Integration and Demo 
Let's consider a scenario where we have a system for managing collaborators and their skills. We'll integrate the Collaborator class with a CollaboratorRepository class, and then demonstrate how to add collaborators, retrieve their information, and manipulate their skills.

* We create two Collaborator objects.
* We add these collaborators to the CollaboratorRepository.
* We retrieve all collaborators from the repository and display their information.
* We manipulate the skills of one collaborator (collaborator1) by adding Java and Python skills.
* We display the updated information of collaborator1.


## 7. Observations

n/a