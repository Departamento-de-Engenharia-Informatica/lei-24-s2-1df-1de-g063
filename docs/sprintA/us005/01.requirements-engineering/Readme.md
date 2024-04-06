# US005 - As a HRM, I want to generate a team proposal automatically


## 1. Requirements Engineering

### 1.1. User Story Description

As a Human Resource Manager (HRM), I want to streamline the process of generating team proposals by implementing an automatic generation feature. This functionality will enable me to swiftly compile comprehensive team proposals, incorporating essential details such as team members' roles, skills, and relevant project assignments.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>"Teams are temporary associations of employees who will carry out a set of tasks in one or more green spaces." this part from the assignment helps understanding what the client means by creating a team, it's an useful form of contextualization.

>"When creating multipurpose teams, the number of members and the set of skills that must be covered are crucial." this sentence already defines two important Acceptance Criteria.
 

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
* **AC6:** The system should provide clear notification in case of insufficient collaborators to make the team needed.
### 1.4. Found out Dependencies

* Dependencies found in [US01 - As a Human Resources Manager (HRM), I want to register skills that a collaborator may have](/docs/sprintA/us001), there must be skills registered before asking a team with those set of skills
* Dependencies also found in [US04 - HRM intends to assign one or more competences to an employee](/docs/sprintA/us004), there must be skills assigned to an employee, otherwise the system cannot create a team based on the skills provided

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * number of members
    * skills needed

**Output Data:**

* Generated team

### 1.6. System Sequence Diagram (SSD)

![US005-System-Sequence-diagram1](/docs/sprintA/us005/01.requirements-engineering/svg/us005-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

*...