# CS-320 Software Testing
## Java Service Validation and Unit Testing Project
### Overview
This project demonstrates Java service-layer development and unit testing with JUnit. It containes three independent service modules: Contact Service, Task Service, and Appointment Service. <br><br>
Each module creates objects with specific validation rules, stores them in an in-memory list (in-memory used over database for simplicity of testing purposes), and includes JUnit tests to verify that business requirement are met.<br>
## Services Included
------------------
### Contact Service
The Contact Service manages contact records. Each contact object includes:
- Contact ID
- First Name
- Last Name
- Phone Number
- Address

The service supports:
- Adding contacts with unique IDs
- Deleting contacts by ID
- Updating first name, last name, phone number, and address

Validation rules include:
- Contact ID cannot be null or longer than 10 characters
- First and last name cannot be null or longer than 10 characters
- Phone number must be exactly 10 digits
- Address cannot be null or longer than 30 characters

### Task Service
The Task Service manages task records. Each task includes:
- Task ID
- Task Name
- Task Description

The sservice supports:
- Adding tasks with unique IDs
- Deleting tasks by ID
- Updating task name and task description

Validation rules include:
- Task ID cannot be null or longer than 10 characters
- Task name cannot be null or longer than 20 characters
- Task description cannot be null or longer than 50 characters

### Appointment Service
The Appointment Service manages appointment records. Each appointment includes:
- Appointment ID
- Appointment Date
- Appointment Description

The service supports:
- Adding appointments with unique IDs
- Deleting appointments by ID

Validation rules include:
- Appointment ID cannot be null or longer than 10 characters
- Appointment date cannot be null or in the past
- Appointment description cannot be null or longer than 50 characters

## Unit Testing
JUnit tests were created for each service and object class.<br><br>

The tests verify:
- Valid object creation
- Required field validation
- Boundary limits for field lengths
- Null input handling
- Exception handling with invalid data
- Unique ID generation
- Add and delete functionality
- Update functionality where required

## What This Project Demonstrates
This project demonstrates the ability to:
- Translate software requirements into Java Classes
- Apply validation logic to constructors and setter methods
- Build service classes that manage in-memory data
- Use JUnit to test normal, boundary, and error cases
- Verify exception handling using unit tests
- Organize related service modules into a single testing-focused project

## Technologies Used
- Java
- JUnit 5
- Eclipse IDE
