# US004 


## 1. Requirements Engineering

### 1.1. User Story Description

HRM intends to assign one or more competences to an employee

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	Each task is characterized by having a unique reference per organization, a designation, an informal and a technical description, an estimated duration and cost, as well as a task category. 

>	As long as it is not published, access to the task is exclusive to the employees of the respective organization. 

**From the client clarifications:**

> **Question:** Which is the unit of measurement used to estimate duration?
>
> **Answer:** Duration is estimated in days.

> **Question:** Monetary data is expressed in any particular currency?
>
> **Answer:** Monetary data (e.g. estimated cost of a task) is indicated in POT (virtual currency internal to the platform).

### 1.3. Acceptance Criteria

* **AC1:** All required fields must be filled in.
* **AC2:** The employee and the competence must be already registred. 
* **AC3:** The employee cannot already have that competence assigned to him.
* **AC4:** The HRM must insert a code to perform this operation as he is the only one with the power to do it.


### 1.4. Found out Dependencies

* There is a dependency on US004 as US001 and US003 must be functional.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * an employee
    * a competence 
    * a code
    * confirmation of the operation
	
* Selected data:
    * a task category 

**Output Data:**

* List of information inserted
* Confirmation of the operation
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.