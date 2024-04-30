# US006 - Create a Task 

## 3. Design - User Story Realization 

### 3.1. Rationale

_**Note that SSD - Alternative One is adopted.**_

| Interaction ID | Question: Which class is responsible for... | Answer               | Justification (with patterns)                                                                                 |
|:-------------  |:--------------------- |:---------------------|:--------------------------------------------------------------------------------------------------------------|
| Step 1  		 |	... interacting with the actor? | GenerateTeamProposalUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 |	... coordinating the US? | TeamProposalController | Controller                                                                                                    |
| 			  		 |	... instantiating a new Collaborator? | TeamProposalController         | Creator (Rule 1): in the DM TeamProposalController has a Collaborator.                                                          |
| 			  		 | ... knowing the user using the system?  | UserSession          | IE: cf. A&A component documentation.                                                                          |
| 			  		 |							 | TeamProposalController         | IE: knows/has its own Collaborators                                                                               |
| 			  		 |							 | Collaborator             | IE: knows its own data (e.g. number)                                                                           |
| Step 2  		 |	... interacting with the actor? | GenerateTeamProposalUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 |	... coordinating the US? | TeamProposalController | Controller                                                                                                    |
| 			  		 |	... instantiating a new Collaborator? | TeamProposalController         | Creator (Rule 1): in the DM TeamProposalController has a Collaborator.                                                          |
| 			  		 | ... knowing the user using the system?  | UserSession          | IE: cf. A&A component documentation.                                                                          |
| 			  		 |							 | TeamProposalController         | IE: knows/has its own Collaborators                                                                               |
| 			  		 |							 | Collaborator             | IE: knows its own data (e.g. number)                                                                           |
| Step 3  		 |	...saving the inputted data? | Collaborator                 | IE: object created in step 1 has its own data.                                                                |
| Step 4  		 |	...knowing the skill categories to show? | TeamProposalController               | IE: Skill Categories are defined by the Administrators.                                                        |
| Step 5  		 |	... saving the selected category? | Collaborator                 | IE: object created in step 1 is classified in one Category.                                                   |
| Step 6  		 |	... interacting with the actor? | GenerateTeamProposalUI         | Pure Fabrication: there is no reason to assign this responsibility to any existing class in the Domain Model. |
| 			  		 |	... coordinating the US? | TeamProposalController | Controller                                                                                                    |
| 			  		 |	... instantiating a new Collaborator? | TeamProposalController         | Creator (Rule 1): in the DM TeamProposalController has a Collaborator.                                                          |
| 			  		 | ... knowing the user using the system?  | UserSession          | IE: cf. A&A component documentation.                                                                          |
| 			  		 |							 | TeamProposalController         | IE: knows/has its own Collaborators                                                                               |
| 			  		 |							 | Collaborator             | IE: knows its own data (e.g. number)                                                                           |
| Step 7  		 |	... validating all data (local validation)? | Collaborator                 | IE: owns its data.                                                                                            | 
| 			  		 |	... validating all data (global validation)? | TeamProposalController         | IE: knows all its Collaborators.                                                                                      | 
| 			  		 |	... saving the created task? | TeamProposalController         | IE: owns all its Collaborators.                                                                                       | 
| Step 8  		 |	... informing operation success?| GenerateTeamProposalUI         | IE: is responsible for user interactions.                                                                     |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

* Collaborator
* Skill
* TeamProposal

Other software classes (i.e. Pure Fabrication) identified: 

* GenerateTeamProposalUI
* TeamProposalController
* CollaboratorRepository
* SkillRepository
* TeamProposalRepository


## 3.2. Sequence Diagram (SD)

_**Note that SSD - Alternative Two is adopted.**_

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