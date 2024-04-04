# US03- As a HRM, I want to register an employee with a profession and key attributes.


## 1. Requirements Engineering

### 1.1. User Story Description

The user story involves the task of adding a new employee to the system, capturing essential details such as personal information, job role, and any other pertinent attributes necessary for their registration.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	"MS has a wide range of employees who carry out the most varied tasks in the context of green space management. Some examples of professions are: planner, estimator, gardener, electrician or bricklayer. Thus, an employee has a main occupation (profession) and a set of skills that enable them to perform/take on certain tasks/responsibilities, for example: driving different types of vehicles (e.g. light, heavy), operating machinery such as backhoes or tractors; pruning trees; applying phytopharmaceuticals." 


**From the client clarifications:**

> **Question:** Is there any limit to the number of employees per profession?
>
> **Answer:** 

> **Question:** Do I have to show an approval message?
>
> **Answer:** 

### 1.3. Acceptance Criteria

* **AC1:** name, birthdate, admission date, address, contact info (mobile and email), ID doc type and respective number should be provided by HRM.
* **AC2:** The profession and the atributes have to be already registred.
* **AC3:** The employee cannot be registered yet.

### 1.4. Found out Dependencies

* There is a dependency on US003 as US001 and US002 must be functional in order to perform what this US is asking.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * a name
    * a profession 
    * an attibute
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

![us003-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.png](svg%2Fus003-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.png)


### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.