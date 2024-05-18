# US03 - Register a Collaborator 

## 4. Tests 

**Test 1:** Ensures that the Collaborator class's constructor works as expected, creating a Collaborator object with the provided parameters without any errors. 

	@Test
    void ensureCollaboratorIsCreatedSuccessfully() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotNull(collaborator);
    }
	

**Test 2:** Ensures that the Collaborator class allows for the addition of skills to a collaborator's profile and that the size of the skill list is correctly updated after adding a new skill. 

	    @Test
    void ensureSkillListIsMutable() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        List<Skill> skills = new ArrayList<>();
        collaborator.setSkill(skills);
        skills.add(new Skill("Java"));
        assertEquals(1, collaborator.getSkill().size());
    }

**Test 3:** This test verifies that the equals() method properly evaluates to true when comparing the same object instance

    @Test
    void testEqualsSameObject() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertEquals(collaborator, collaborator);
    }

**Test 4:** The expectation here is that the equals() method within the Collaborator class properly handles the comparison with an instance of a different class and returns false, as objects of different classes are not considered equal according to the default implementation of the equals() method.

    @Test
    void testEqualsDifferentClass() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator, new Object());
    }

**Test 5:** This test verifies that the equals() method behaves correctly when compared with a null reference.

    @Test
    void testEqualsNull() {
        Collaborator collaborator = new Collaborator("John Doe", "123 Main St", "john.doe@example.com",
                "123456789", "cartão de cidadão", "12345678", LocalDate.of(1990, 1, 1),
                LocalDate.now(), "Developer");
        assertNotEquals(collaborator, null);
    }

**Test 6:** This unit test, named testEqualsDifferentObject, examines the behavior of the equals() method within the Collaborator class when comparing two different Collaborator objects.

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

**Test 7:** This test ensures that the equals() method correctly handles comparisons between Collaborator objects with different attribute values.

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

**Test 8:** Verifies the behavior of the equals() method within the Collaborator class when comparing two instances of Collaborator objects with identical attributes and values.

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

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class RegisterCollaboratorController 

```java
public RegisterCollaboratorController() {
    getJobRepository();
    getAuthenticationRepository();
    getCollaboratorRepository();
}

public RegisterCollaboratorController(AuthenticationRepository authenticationRepository) {
    this.jobRepository = JobRepository.getInstance();
    this.authenticationRepository = authenticationRepository;
}

private JobRepository getJobRepository() {
    if (jobRepository == null) {
        Repositories repositories = Repositories.getInstance();

        //Get the TaskCategoryRepository
        jobRepository = repositories.getJobRepository();
    }
    return jobRepository;
}

public CollaboratorRepository getCollaboratorRepository() {
    if (collaboratorRepository == null) {
        Repositories repositories = Repositories.getInstance();

        //Get the TaskCategoryRepository
        collaboratorRepository = repositories.getCollaboratorRepository();
    }
    return collaboratorRepository;
}


private AuthenticationRepository getAuthenticationRepository() {
    if (authenticationRepository == null) {
        Repositories repositories = Repositories.getInstance();

        //Get the AuthenticationRepository
        authenticationRepository = repositories.getAuthenticationRepository();
    }
    return authenticationRepository;
}

public Collaborator registerCollaborator(String name, String adress, String email, String phoneNumber, String idType, String idNumber, LocalDate birthDate, LocalDate admissionDate, String job) {

    return new Collaborator(name, adress, email, phoneNumber, idType, idNumber, birthDate, admissionDate, job);
}

```

### Class CollaboratorRepository

```java
public CollaboratorRepository(){
    collaborators = new ArrayList<Collaborator>();
}

public static CollaboratorRepository getInstance() {
    if (instance == null) {
        instance = new CollaboratorRepository();
    }
    return instance;
}

public void addCollaborator(Collaborator collaborator){
    collaborators.add(collaborator);
}

public List<Collaborator> getCollaborators() {
    return collaborators;
}

public void saveCollaborator(Collaborator collaborator) {
    boolean updated = false;
    for (int i = 0; i < collaborators.size() && !updated; i++) {
        if (collaborators.get(i).equals(collaborator)) {
            collaborators.set(i, collaborator);
            updated = true;
        }
    }
}
```


## 6. Integration and Demo 

* A new option on the HRM menu options was added.
    * The Collaborator is used to store and manage collaborator's data.
* The HRM menu now includes a Collaborator registration feature accessible through the user interface.
    * When users navigate to the collaborator registration section, they are presented with a form to input all the requested information about the collaborator, one or more skills and one job to be assigned to him.

* Upon submission, the system verifies collaborator's information provided by the user:
  * If any of the collaborator's information is null or empty, an error message is displayed prompting the user to provide valid information.
  * If the collaborator already exists in the system, an error message is displayed indicating that the collaborator already exists.
  * If the collaborator is valid, the collaborator is successfully registered, and a success message is displayed.


## 7. Observations

n/a