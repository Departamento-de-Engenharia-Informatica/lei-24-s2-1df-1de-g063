# US006 - As an FM, I wish to register a vehicle including Brand, Model, Type, Tare, Gross Weight, Current Km, Register Date, Acquisition Date, Maintenance/Check-up Frequency (in Kms)


## 1. Requirements Engineering

### 1.1. User Story Description

As a Vehicle and Equipment Fleet Manager (VFM) I want to register a vehicle.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

> "This type of vehicle can be passenger only or mixed,
light or heavy, vans or trucks with open or closed boxes.
As for machines, MS has tractors, backhoe loaders and rotating machines, lawn mowers,
between others. The equipment can be very diverse, such as sprayers, elevators
platforms, chainsaws, brush cutters, blowers, ladders, cisterns and the various elements
that can be attached to tractors, such as disc harrows, weeders, aerators and scarifiers."



**From the client clarifications:**

> **Question:** 
>
> **Answer:** 


### 1.3. Acceptance Criteria

* **AC1:** The system should allow the VFM to register a vehicle.
* **AC2:** The system should provide a form for the Vehicle and Equipment Fleet Manager to input details of a new vehicle, including Brand, Model, Type, Tare, Gross Weight, Current Km, Register Date, Acquisition Date, Maintenance/Check-up Frequency (in Kms), and a description.
* **AC3:** Once the vehicle registration is successful the system should store the vehicle details.

### 1.4. Found out Dependencies

* US07 (register a vehicle for servicing) and US08 (list the vehicles that need to be serviced) depend directly on US06 (register a vehicle) because in order to register a vehicle for servicing and which vehicles need to be serviced, it is necessary to have the vehicles registered.

### 1.5 Input and Output Data

**Input Data:**

* Typed data:
    * Vehicle details
    * vehicle description

* Selected data:
    * None

**Output Data:**

* Success/Failure status of the vehicle registration operation

### 1.6. System Sequence Diagram (SSD)

**_Other alternatives might exist._**



![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)


### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.