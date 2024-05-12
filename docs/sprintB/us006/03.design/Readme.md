# US006 - Create a Task

## 3. Design - User Story Realization

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID                                       | Question: Which class is responsible for...                | Answer                    | Justification (with patterns)                                                                                 |
|:-----------------------------------------------------|:-----------------------------------------------------------|:--------------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1 : Requests to register a vehicle             | ... interacting with the actor?                           | RegisterVehicleUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
|                                                 | ... coordinating the US?                                  | RegisterVehicleController | Controller                                                                                                    |
| Step 2  : Requests data                            | ... displaying the from for the actor to input data? | RegisterVehicleUI         | Pure Fabrication                                                                                              |
| Step 3 : Types requested data                      | ...saving the inputted data?                              | RegisterVehicleUI         | Pure Fabrication                                                                                              |
| Step 4  : show all data registered for confirmation | ...display all the information before submitting?         | RegisterVehicleUI         | Pure Fabrication                                                                                              |
| Step 5  : submits data                             | ... creating the skill object?                            | VehicleRepository         | IE: in the DM SkillRepository has a Skill                                                                     |
|                                                    | ... validating all data (global validation)?              | VehicleRepository                       | IE: knows all its tasks.                                                                                      | 
|                                                 | ... validating all data (local validation)?               | Vehicle               | IE: knows its data.                                                                                           | 
|                                                 | ... saving the register skill?                            | VehicleRepository               | IE: owns all its tasks.                                                                                       | 
| Step 6   : shows operation success                 | ... informing operation success?                          |RegisterVehicleUI              | IE: is responsible for user interactions.                                                                     | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* Organization
* Task

Other software classes (i.e. Pure Fabrication) identified:

* RegisterVehicleUI
* RegisterVehicleController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us006-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us006-sequence-diagram-split-System_Sequence_Diagram__SSD____US006.svg)

**Get Task Category Object**

![Sequence Diagram - Partial - Get Task Category List](svg/us006-sequence-diagram-partial-get-task-category.svg)


**Create Task**

![Sequence Diagram - Partial - Create Task](svg/us006-sequence-diagram-partial-create-task.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us006-class-diagram.svg)