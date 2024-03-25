# US007 - As an FM, I wish to register a vehicle’s check-up.


## 1. Requirements Engineering

### 1.1. User Story Description

As a Fleet Manager responsible for overseeing the maintenance and condition of 
vehicles within the organization, I need a feature that allows me to quickly register
vehicles check-up result.

### 1.2. Customer Specifications and Clarifications  FALTA ISTO

**From the specifications document:**

>	Each task is characterized by having a unique reference per organization, a designation, an informal and a technical description, an estimated duration and cost, as well as a task category. 

>	As long as it is not published, access to the task is exclusive to the employees of the respective organization. 

**From the client clarifications:**

> **Question:** Which attributes will you need for the vehicle's check-up?
>
> **Answer:** Plate number, date, kms at checkup.

### 1.3. Acceptance Criteria

* **AC1:** The system should provide a feature for the Fleet Manager (FM) to register a vehicle's check-up.
* **AC2:** When the Fleet Manager (FM) initiates the registration process for a vehicle's check-up, the system interface should prompt the FM to provide
the unique identification (ID) of the vehicle undergoing the check-up, the date when the check-up was performed, 
the updated kilometers after the check-up and the check-up results.
* **AC3:** After the FM submits the required information, the system should validate the input data.
* **AC4:** In case of any errors during the registration process, the system should display appropriate error messages to the FM, indicating the nature of the issue and any corrective actions required.

### 1.4. Found out Dependencies FALTA VER

*

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * unique identification(ID) of the vehicle
    * the date when the check-up was performed
    * the updated kilometers after the check-up
	
* Selected data:
    * a task category 

**Output Data:**

* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us006-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.