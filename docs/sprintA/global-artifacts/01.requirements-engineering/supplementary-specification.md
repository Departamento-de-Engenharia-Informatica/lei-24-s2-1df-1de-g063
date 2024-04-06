# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:  
&nbsp; &nbsp; (i) are common across several US/UC;  
&nbsp; &nbsp; (ii) are not related to US/UC, namely: Audit, Reporting and Security._

The Managers must be able to store specific data, only the one required for their function, in specific groups (jobs, skills, etc.). 
The Managers must be able to modify the stored information.
The managers must be able to create independent groups of information.

 


## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._

The main user of the program are the Managers. 
The Managers will use it to store and modify data. 
The Managers through out the usage of the program must find confirmation steps to assure the good functionality of the program, they will also find a question in every step offering help in order to make the usage of the program easier. The confirmation steps will appear as "warnings" and the help questions will come before the confirmation (as the user is using).


## Reliability

_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

In case of failure storing the data the user will be given the option to start over.
All the dates must be in the dd-mm-aaaa format.
For every name stored in the system there can only be 6 names inserted and it cannot contain any digit or special character.
An acceptable system failure will occur in the event of the user forcing the system to store information in a format not supported, what will happen nis that the user will have to repeat the action until it´s in a supported format.

## Performance

_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

The system must have a fast response and start-up time. The time to recover from failures, errors or crashes must be fast as well.

## Supportability

_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._

The system should be designed with built-in testing capabilities to facilitate unit testing, integration testing, and system testing.
The system architecture should allow for easy adaptation to future changes in requirements or technologies.
Code should be well-documented and structured to facilitate maintenance by future developers.
The system should allow administrators to configure settings such as user permissions and system preferences easily.
The system installation process should be straightforward and well-documented.

## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

The system must be developed using Java.

### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

Java is the required language for coding.
The system must ensure data integrity through proper database management and transaction handling.
The system should not exceed predefined resource limits such as maximum memory allocation and CPU usage.

### Interface Constraints

_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._

(The Domain modules and SSD must be in .svg and .puml. Use cases must be on markdown (.md). The code must be writen in java and the compiled program in .jar .)

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

The system should be deployable on standard computer hardware commonly used in office environments, including desktops and laptops.