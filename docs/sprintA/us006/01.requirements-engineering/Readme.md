# US006 - Register a vehicle 


## 1. Requirements Engineering

### 1.1. User Story Description

As a Vehicle Park Manager (VMP) I want to register a vehicle

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>	"Este tipo de viatura pode ser apenas para passageiros ou misto, ligeiras ou pesadas, com ou sem caixa aberta.
Em termos de m ́aquinas, a MS possui tractores, retroescavadoras e máquinas giratórias, corta-relvas, entre outros. Os equipamentos podem ser muito diversos, como pulverizadores, plataformas elevat ́orias, motosserras, motorro ̧cadoras, sopradores, es- cadas, cisternas e alfaias diversas que podem ser acopladas aos tractores, como por exemplo: grades de discos, capinadoras, escarificadores." 



**From the client clarifications:**

> **Question:** 
>
> **Answer:** 


### 1.3. Acceptance Criteria

* **AC1:** A car must be entered
* **AC2:** The car must not already be registered.
* **AC3:** The VMP must insert a code to perform this operation as he is the only one with the power to do it.
* **AC4:** The attributes that should be used to describe a vehicle are: Make, Model, Type, Tare, Gross Weight, Current Kms, Registration Date, Acquisition Date and Overhaul Frequency (in Kms).

### 1.4. Found out Dependencies

* US07 (register a vehicle for servicing) and US08 (list the vehicles that need to be serviced) depend directly on US06 (register a vehicle) because in order to register a vehicle for servicing and which vehicles need to be serviced, it is necessary to have the vehicles registered.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * a reference
    * an access code
    * a vehicle
    * vehicle characteristics
* Selected data:
    * a task category 

**Output Data:**

* List of existing task categories
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**



![System Sequence Diagram - Alternative One](/docs/sprintA/us006/01.requirements-engineering/svg/us006-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.SVG)


### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.