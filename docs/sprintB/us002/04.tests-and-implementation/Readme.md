# US006 - Create a Task 

## 4. Tests 

**Test 1:** This test method verifies that a Job object is created successfully with the provided name, and it checks if the getName() method returns the correct name.

	 @Test
    void ensureJobIsCreatedSuccessfully() {
        Job job = new Job("Developer Job");
        assertEquals("Developer Job", job.getName());
    }



**Test 2:** This test method ensures that attempting to create a Job object with a null name results in throwing an IllegalArgumentException.

	 @Test
    void ensureJobNameIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Job(null));
    }

**Test 3:** This test method verifies that the toString() method of the Job class returns the name of the job.

	 @Test
    void ensureJobToStringReturnsName() {
        Job job = new Job("Developer Job");
        assertEquals("Developer Job", job.toString());
    }

**Test 4:** This test method, testEqualsSameObject, verifies the reflexivity property of the equals() method for the Job class.

	 @Test
    void testEqualsSameObject() {
        Job job = new Job("Developer Job");
        assertEquals(job, job);
    }

**Test 5:** This test method, testEqualsDifferentClass, verifies the behavior of the equals() method when comparing a Job object with an object of a different class.

	 @Test
    void testEqualsDifferentClass() {
        Job job = new Job("Developer Job");
        assertNotEquals(job, new Object());
    }

**Test 6:** This test method, testEqualsNull, verifies the behavior of the equals() method when comparing a Job object with null.

	 @Test
    void testEqualsNull() {
        Job job = new Job("Developer Job");
        assertNotEquals(job, null);
    }

**Test 7:** This test method, testEqualsDifferentObject, verifies the behavior of the equals() method when comparing two distinct Job objects with different names.

	 @Test
    void testEqualsDifferentObject() {
        Job job1 = new Job("Developer Job");
        Job job2 = new Job("Gardener Job");
        assertNotEquals(job1, job2);
    }

**Test 8:** This test method, testEqualsSameObjectDifferentName, verifies the behavior of the equals() method when comparing two Job objects instantiated from the same class but with different names.

	@Test
    void testEqualsSameObjectDifferentName() {
        Job job1 = new Job("Developer Job");
        Job job2 = new Job("Web Developer Job");
        assertNotEquals(job1, job2);
    }

_It is also recommended to organize this content by subsections._ 


## 5. Construction (Implementation)

### Class RegisterJobController 

```java
public RegisterJobController() {
    getJobRepository();
    getAuthenticationRepository();
}

public RegisterJobController(AuthenticationRepository authenticationRepository) {
    this.jobRepository = JobRepository.getInstance();
    this.authenticationRepository = authenticationRepository;
}

private JobRepository getJobRepository() {
    if (jobRepository == null) {
        Repositories repositories = Repositories.getInstance();


        jobRepository = repositories.getJobRepository();
    }
    return jobRepository;
}

private AuthenticationRepository getAuthenticationRepository() {
    if (authenticationRepository == null) {
        Repositories repositories = Repositories.getInstance();

        //Get the AuthenticationRepository
        authenticationRepository = repositories.getAuthenticationRepository();
    }
    return authenticationRepository;
}


public Job createJob (String jobName) {

    Job job = new Job(jobName);

    return job;
}


```

### Class JobRepository

```java
    public static JobRepository getInstance() {
    if (instance == null) {
        instance = new JobRepository();
    }
    return instance;
}

public JobRepository() {
    this.jobs = new ArrayList<>();
}

public void addJob(Job job) {
    jobs.add(job);
}

public List<Job> getJobs() {
    // This is a defensive copy, so that the repository cannot be modified from the outside.
    return new ArrayList<>(jobs);
}
```


## 6. Integration and Demo 

* A new option on the HRM menu options was added.
    * The JobRepository is used to store and manage job data.

* The HRM menu now includes a job registration feature accessible through the user interface.
    * When users navigate to the job registration section, they are presented with a form to input the job name.
* Upon submission, the system verifies the job name provided by the user:
    * If the name is null or empty, an error message is displayed prompting the user to provide a valid job name.
    * If the name already exists in the system, an error message is displayed indicating that the job already exists.
    * If the name is valid and not already in use, the job is successfully registered, and a success message is displayed.


## 7. Observations

n/a