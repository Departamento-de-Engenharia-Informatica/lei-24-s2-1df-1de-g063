# US004 -  As an HRM, I want to assign one or more skills to a collaborator


## 1. Requirements Engineering

### 1.1. User Story Description

This user story intends to choose an employee and to give this chosen employee new competences.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	"Thus, an employee has a main occupation (profession) and a set of skills that enable him/her to carry out/assume certain tasks/responsibilities, for example: driving vehicles of different types (e.g. light, heavy), operating machinery such as backhoes or tractors; pruning trees; applying phytopharmaceuticals." 

**From the client clarifications:**

> **Question:** How to only allow the HRM to make this action?
>
> **Answer:** (The client did not answer my question)
### 1.3. Acceptance Criteria

* **AC1:** The system should allow the HRM to assign one or more skills to a collaborator.
* **AC2:** The employee cannot already have that competence assigned to him.

### 1.4. Found out Dependencies

* There is a dependency on US004 as US001 and US003 must be functional.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * an employee
    * a competence

**Output Data:**

  * List of information inserted
    * Confirmation of the operation
    * (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![us004-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.svg](svg/us004-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.svg)

### 1.7 Other Relevant Remarks
