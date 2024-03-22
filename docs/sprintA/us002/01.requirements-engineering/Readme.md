# US002 - Register a job. 


## 1. Requirements Engineering

### 1.1. User Story Description

As an Human Resources Manager (HRM), I want to register a job.
### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>   "Some job examples are designer, estimator, gardener, electrician or bricklayer." Different jobs that can be registered.

**From the client clarifications:**

> **Question:** Monetary data is expressed in any particular currency?
>
> **Answer:** Monetary data (e.g. estimated cost of a task) is indicated in POT (virtual currency internal to the platform).

### 1.3. Acceptance Criteria

* **AC1:** Insert a job name.
* **AC2:** The job mustn't be already registered.
* **AC3:** Only as HRM can do this action
* **AC4:** The skill mustn't include special characters or digits. 
* 
### 1.4. Found out Dependencies

* There is no dependencies.

### 1.5 Input and Output Data

**Input Data:**

* Typed data: 
  * one job
  * a confirmation/approval
	
* Selected data:
  * a task category ??? 

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

* The created task stays in a "not published" state in order to distinguish from "published" tasks.