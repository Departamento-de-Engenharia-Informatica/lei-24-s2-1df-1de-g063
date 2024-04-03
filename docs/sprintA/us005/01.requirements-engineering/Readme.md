# US05 - As a HRM, I want to generate a team proposal automatically


## 1. Requirements Engineering

### 1.1. User Story Description

As a Human Resource Manager (HRM), I want to streamline the process of generating team proposals by implementing an automatic generation feature. This functionality will enable me to swiftly compile comprehensive team proposals, incorporating essential details such as team members' roles, skills, and relevant project assignments.
### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	Teams are temporary associations of employees who will carry out a set of tasks in one or more green spaces.

>	When creating multipurpose teams, the number of members and the set of skills that must be covered are crucial.
 

**From the client clarifications:**
> **Question:** What other inputs are needed to generate a team
>
> **Answer:** None, only the number of members and the skills needed
> 
>**Question:** Can a collaborator be in more than one team at the same time?
>
>**Answer:** No

### 1.3. Acceptance Criteria

* **AC1:** The number of members must be given by the HRM
* **AC2:** The skills needed must be given by the HRM
* **AC3:** The HRM should have the option to validate the team generated
* **AC4:** The system should automatically assign team members to specific roles based on their skills and availability.
* **AC5:** The system should provide clear notifications or prompts for any missing or incomplete information required for generating the team proposal.
### 1.4. Found out Dependencies

* Dependencies found in [US001](/docs/sprintA/us001) and US04

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * number of members
    * skills needed

**Output Data:**

* Generated team

### 1.6. System Sequence Diagram (SSD)

![US005-System-Sequence-diagram](/docs/sprintA/us005/01.requirements-engineering/svg/us005-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.svg)
![US005-System-Sequence-diagram2](/docs/sprintA/us005/01.requirements-engineering/svg/us005-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_two.svg)

### 1.7 Other Relevant Remarks

*...