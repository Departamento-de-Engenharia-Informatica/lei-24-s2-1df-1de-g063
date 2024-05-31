# US023 - As a GSM, I want to assign a Team to an entry in the Agenda.


## 1. Requirements Engineering

### 1.1. User Story Description
As a Green Space Manager (GSM), I want to have the ability to assign a specific team to an 
entry in the agenda so that the responsibilities for that entry are clearly defined and managed by 
the appropriate team.

### 1.2. Customer Specifications and Clarifications

**From the client clarifications:**
> **Question:** Can an Agenda entry have more than one team assigned to it?
>
> **Answer:** No.
>
> **Question:** Can a Team be assigned to multiple entrys?
>
> **Answer:** yes.

**From the specifications document:**

> The GSM should be able to assign a team to an entry in the Agenda.
>
> A message must be sent to all team members informing them about the assignment.
>
> Different email services can send the message, and these services must be defined through a configuration file.

### 1.3. Acceptance Criteria

* **AC1:** A message must be sent to all team members informing
  them about the assignment.
* **AC2:** Different email services can send the message. These services must be defined through a configuration file to allow the use
  of different platforms (e.g. Gmail, DEI’s email service, etc.).

### 1.4. Found out Dependencies

* **Dependencies found in US03** - *As an HRM, I want to register a collaborator with a job and fundamental characteristics*, there must exist collaborators.
* **Dependencies found in US01** - *As a Human Resources Manager (HRM), I want to register skills that a collaborator may have*, there must be skills registered before assigning a team with those set of skills.
* **Dependencies found in US04** - *HRM intends to assign one or more competences to an employee*, there must be skills assigned to an employee, otherwise, the system cannot create a team based on the skills provided.
* **Dependencies found in US05** - *As an HRM, I want to generate a team proposal*, as there need to exist teams in order to choose them.
* **Dependencies found in US21** - *As a GSM, I want to add a new entry to the To-Do List*,because the entries need to be created first.
* **Dependencies found in US22** - *As a GSM, I want to add a new entry in the Agenda*, as those entries need to be added to the agenda in order to be chosen from.

### 1.5 Input and Output Data

**Input Data:**

* Selected data:
  * Entry
  * Teams
  
**Output Data:**
  * (In)Success of the operation

### 1.6. System Sequence Diagram (SSD) 

![]

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us008-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* On the assignment the check-up list isn't mentioned, so I skipped the "from the specification document" point.