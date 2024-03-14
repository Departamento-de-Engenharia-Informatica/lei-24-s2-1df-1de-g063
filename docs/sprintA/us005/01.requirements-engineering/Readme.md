# US05 - Generate a team


## 1. Requirements Engineering

### 1.1. User Story Description

As a HRM, I want to generate a team proposal automatically.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	Teams are temporary associations of employees who will carry out a set of tasks in one or more green spaces.

>	When creating multipurpose teams, the number of members and the set of skills that must be covered are crucial.
 

**From the client clarifications:**
> **Question:** What inputs are needed to generate a team
>
> **Answer:** To be answered

> **Question:** What are the specific challenges or pain points that HRMs currently face when creating team proposals manually?
>
> **Answer:** To be answered

> **Question:** Will this feature be HRM restricted or can the HRM give the inputs to any user
>
> **Answer:** To be answered

>**Question:** Are there any dependencies or relationships between certain skills that need to be considered when forming teams?
>
>**Answer:** To be answered

>**Question:** What kind of reporting or feedback mechanisms would be helpful for HRMs to validate and evaluate the proposed team compositions?
>
>**Answer:** To be Answered

### 1.3. Acceptance Criteria

* **AC1:** The number of members must be given by the HRM
* **AC2:** The skills needed must be given by the HRM

### 1.4. Found out Dependencies

* Currently not found

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * number of members
    * skills needed
    * to be answered...

**Output Data:**

* Generated team

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us006-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.