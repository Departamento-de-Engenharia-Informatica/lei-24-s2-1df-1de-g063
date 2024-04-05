# US02 - As an HRM, I want to register a job that a collaborator need to have


## 1. Requirements Engineering

### 1.1. User Story Description

As a Human Resources Manager (HRM),who is responsible for managing human resources, teams needed on ongoing projects and defining the skills of the employees, I want to register a job.
### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>   "Some job examples are designer, estimator, gardener, electrician or bricklayer." Different jobs that can be registered.

**From the client clarifications:**

> **Question:** 
>
> **Answer:** 

### 1.3. Acceptance Criteria

* **AC1:** Insert a job name.
* **AC2:** The skill mustn't have special characters or digits.
* **AC3:** The job mustn't be already registered.
* **AC4:** Only as HRM can do this action.

### 1.4. Found out Dependencies

* There is no dependencies.

### 1.5 Input and Output Data

**Input Data:**

* Typed data: 
  * one job
  * a confirmation/approval
	
* Selected data:

  *

**Output Data:**

* The registered job
* The success (or not) of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us006-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* The client only answered the question relative to special characters and digits to the US01(Register a skill), but I chose to apply that AC to this US too.