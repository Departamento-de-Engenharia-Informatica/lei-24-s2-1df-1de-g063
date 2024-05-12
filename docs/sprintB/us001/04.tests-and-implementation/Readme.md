# US006 - Create a Task 

## 4. Tests 

**Test 1:** This test method, ensureSkillIsCreatedSuccessfully, verifies that a Skill object is created successfully with the provided name, and it checks if the getName() method returns the correct name.

	@Test
    void ensureSkillIsCreatedSuccessfully() {
        Skill skill = new Skill("Java Programming");
        assertEquals("Java Programming", skill.getName());
    }
	

**Test 2:** This test method, ensureSkillNameIsNotNull, ensures that attempting to create a Skill object with a null name results in throwing an IllegalArgumentException.

	 @Test
    void ensureSkillNameIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Skill(null));
    }

**Test 3:** This test method, ensureSkillToStringReturnsName, verifies that the toString() method of the Skill class returns the name of the skill.

	 @Test
    void ensureSkillToStringReturnsName() {
        Skill skill = new Skill("Java Programming");
        assertEquals("Java Programming", skill.toString());
    }

**Test 4:** This test method, testEqualsSameObject, verifies the reflexivity property of the equals() method for the Skill class.

	 @Test
    void testEqualsSameObject() {
        Skill skill = new Skill("Java Programming");
        assertEquals(skill, skill);
    }


**Test 5:** This test method, testEqualsDifferentClass, verifies the behavior of the equals() method when comparing a Skill object with an object of a different class.

	 @Test
    void testEqualsDifferentClass() {
        Skill skill = new Skill("Java Programming");
        assertNotEquals(skill, new Object());
    }

**Test 6:** This test method, testEqualsNull, verifies the behavior of the equals() method when comparing a Skill object with null.

	 @Test
    void testEqualsNull() {
        Skill skill = new Skill("Java Programming");
        assertNotEquals(skill, null);
    }

**Test 7:** This test method, testEqualsDifferentObject, verifies the behavior of the equals() method when comparing two distinct Skill objects with different names.

	@Test
    void testEqualsDifferentObject() {
        Skill skill1 = new Skill("Java Programming");
        Skill skill2 = new Skill("Python Programming");
        assertNotEquals(skill1, skill2);
    }

**Test 8:** This test method, testEqualsSameObjectDifferentName, verifies the behavior of the equals() method when comparing two Skill objects instantiated from the same class but with different names.

	@Test
    void testEqualsSameObjectDifferentName() {
        Skill skill1 = new Skill("Java Programming");
        Skill skill2 = new Skill("Java Programming Advanced");
        assertNotEquals(skill1, skill2);
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class SkillController 

```java
public SkillController() {
    getSkillRepository();
    getAuthenticationRepository();
}

public SkillController(AuthenticationRepository authenticationRepository) {
    this.skillsRepository = SkillsRepository.getInstance();
    this.authenticationRepository = new AuthenticationRepository();
}

public AuthenticationRepository getAuthenticationRepository() {
    if (authenticationRepository == null) {
        Repositories repositories = Repositories.getInstance();

        //Get the AuthenticationRepository
        authenticationRepository = repositories.getAuthenticationRepository();
    }
    return authenticationRepository;
}

public SkillsRepository getSkillRepository() {
    if (skillsRepository == null) {
        Repositories repositories = Repositories.getInstance();


        skillsRepository = repositories.getSkillsRepository();
    }
    return skillsRepository;
}

public Skill createSkill (String skillName) {

    Skill skill = new Skill(skillName);

    return skill;
}


public List<Skill> getSkills() {
    SkillsRepository skillRepository = getSkillRepository();
    return skillRepository.getSkills();
}
```

### Class SkillsRepository

```java
public static SkillsRepository getInstance() {
    if (instance == null) {
        instance = new SkillsRepository();
    }
    return instance;
}

public SkillsRepository() {
    skills = new ArrayList<>();
}

public void addSkill(Skill skill) {
    skills.add(skill);
}

public List<Skill> getSkills() {
    //This is a defensive copy, so that the repository cannot be modified from the outside.
    return List.copyOf(skills);
}
```


## 6. Integration and Demo 

* A new option on the HRM menu options was added.
  * The SkillsRepository is used to store and manage skill data.

* The HRM menu now includes a skill registration feature accessible through the user interface.
    * When users navigate to the skill registration section, they are presented with a form to input the skill name.
* Upon submission, the system verifies the skill name provided by the user:
  * If the name is null or empty, an error message is displayed prompting the user to provide a valid skill name.
  * If the name already exists in the system, an error message is displayed indicating that the skill already exists.
  * If the name is valid and not already in use, the skill is successfully registered, and a success message is displayed.


## 7. Observations

n/a