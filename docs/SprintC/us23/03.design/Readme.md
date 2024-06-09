# US023 - As a Green Space Manager, I want to assign a team to an entry

## 3. Design - User Story Realization

### 3.1. Rationale

| Interaction ID                              | Question: Which class is responsible for...                | Answer                              | Justification (with patterns)               |
|:--------------------------------------------|:-----------------------------------------------------------|:------------------------------------|:--------------------------------------------|
| Step 1: Request to assign team to entry     | ... interacting with the actor?                            | AssignTeamToEntryUI                 | IE - is responsible for user interactions.  |
|                                             | ... coordinating the US?                                   | AssignTeamToEntryController         | Controller                                  |
| Step 2: Retrieves list of teams             | ... generating the list of teams?                          | TeamRepository                      | Information Expert                          |
| Step 3: Selects team                        | ... keeping the selected team?                             | AssignTeamToEntryUI                 | IE - is responsible for user interactions.  |
| Step 4: Retrieves list of entries           | ... generating the list of entries?                        | AgendaRepository                    | Information Expert                          |
| Step 5: Selects entry                       | ... keeping the selected entry?                            | AssignTeamToEntryUI                 | IE - is responsible for user interactions.  |
|                                             | ... updating the entry with the assigned team?             | Entry                               | Information Expert                          |
|                                             | ... sending the email notification?                        | Mailer                              | Pure Fabrication                            |
| Step 8: Displays success or failure message | ... interacting with the actor?                            | AssignTeamToEntryUI                 | IE - is responsible for user interactions.  |

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are:

* Team promoted to Team
* Entry promoted to Entry
* Agenda promoted to AgendaRepository

Other software classes (i.e. Pure Fabrication) identified:

* AssignTeamToEntryUI
* AssignTeamToEntryController
* Repositories
* TeamRepository
* Organization
* OrganizationRepository
* Mailer

## 3.2. Sequence Diagram (SD)

### Full Diagram

This diagram shows the full sequence of interactions between the classes involved in the realization of this user story.

![Sequence Diagram - Full](/docs/SprintC/us23/03.design/svg/us023-sequence-diagram-full.png)

## 3.3. Class Diagram (CD)

![Class Diagram](/docs/SprintC/us23/03.design/svg/us023-class-diagram.svg)