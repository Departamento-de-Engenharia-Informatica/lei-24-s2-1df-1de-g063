# US001 - Register a skill 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID                                   | Question: Which class is responsible for...       | Answer           | Justification (with patterns)                                                                                 |
|:-------------------------------------------------|:--------------------------------------------------|:-----------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1: Asks to register a new skill.   		       | 	... interacting with the actor?                  | SkillUI          | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		                                          | 	... coordinating the US?                         | SkillController  | Controller                                                                                                    |
| Step 2: Request data (name of the skill) 			  		 | 	displaying the form for the actor to input data? | SkillUI          | IE: is responsible for user                                                                                   |
| Step 3: Types requested data 			  		             | ... temporarily keeping the inputted data?        | SkillUI          | IE: is responsible for temporarily.                                                                           |
| 			  		                                          | ...validates the data (input restrictions)        | SkillUI          | IE: temporarily knows the input data                                                                          |
| 			  		                                          | ... validates the data (duplicated or not)        | SkillsRepository | Information Expert: knows all skills.                                                                         |
| Step 4: displays operation success   		          | ... informing operation success? 			              | SkillUI          | IE: is responsible for user                                                                                   | 

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Skill

Other software classes (i.e. Pure Fabrication) identified:

* SkillsRepository
* SkillUI  
* SkillController


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative one is adopted.**_

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](svg/us006-sequence-diagram-full.svg)

### Split Diagrams

The following diagram shows the same sequence of interactions between the classes involved in the realization of this user story, but it is split in partial diagrams to better illustrate the interactions between the classes.

It uses Interaction Occurrence (a.k.a. Interaction Use).

![Sequence Diagram - split](svg/us006-sequence-diagram-split.svg)

**Get Task Category List Partial SD**

![Sequence Diagram - Partial - Get Task Category List](svg/us006-sequence-diagram-partial-get-task-category-list.svg)

**Get Task Category Object**

![Sequence Diagram - Partial - Get Task Category Object](svg/us006-sequence-diagram-partial-get-task-category.svg)

**Get Employee**

![Sequence Diagram - Partial - Get Employee](svg/us006-sequence-diagram-partial-get-employee.svg)

**Create Task**

![Sequence Diagram - Partial - Create Task](svg/us006-sequence-diagram-partial-create-task.svg)

## 3.3. Class Diagram (CD)

![Class Diagram](svg/us006-class-diagram.svg)