# US024 - As a GSM, I want to Postpone an entry in the Agenda to a specific future date.


## 1. Requirements Engineering

### 1.1. User Story Description

As a Green Space Manager, responsible for managing the green spaces in charge of the organization, I want to postpone an entry in the Agenda previously registered to a specific date.

### 1.2. Customer Specifications and Clarifications

**From the client clarifications:**

> **Question:**
>
> **Answer:**

### 1.3. Acceptance Criteria

* **AC1:** Only a GSM can do this.
* **AC2:** A task must be already created in order to postpone it.
* **AC3:** The system should only allow the GSM to postpone a task.

### 1.4. Found out Dependencies

* There is a dependency on "US022 - As a GSM, I want to add a new entry in the Agenda." because we need to have an entry in order to postpone it.

### 1.5 Input and Output Data

**Input Data:**
  *The desired date.

* Typed data:
  * Tap a key to generate a list with the already registered entries in the Agenda.
  * Number of the desired entry.

* Selected data:
  * An entry from the Agenda.

**Output Data:**

* List of entries from the Agenda.
* The date request.
* The (in)success of the operation.

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us008-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* 