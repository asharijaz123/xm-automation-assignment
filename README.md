# Automated Test Framework

Automated Test Framework is a set of guidelines or rules used for creating and designing test cases for NETSOL's future generation products. The framework is comprised of a combination of industry practices and modern tools that are designed to help NETSOL's QA professionals test more efficiently.

The framework includes guidelines to coding standards, singleton classes that drive the entire framework, design patterns, test-data handling methods, object repositories, processes for storing test results, and custom utility functions on how to access external resources.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Technology Stack

* Selenium WebDriver for Web Based UI Automation Testing
* REST Assured for REST API Testing
* Applitool Eyes for Visual Testing
* Java SE 11 for Development
* Apache Maven as Build Tool
* TestNexGen as Test Runner
* Docker for running container images of automated test framework
* IntelliJ IDEA or Eclipse for 

## Framework Layers mapping

1. The Utilities & Resources Layer (L1): base, common, config, constants, listeners, and resources folders
2. The Pages / Microservices Layer (L2): pages and microservices folders
3. The Test Suite Layer (L3): tests, suites

## Running the tests

On your local machine, you can run your tests either using the IntelliJ IDEA or Eclipse IDE or you can also execute the following Apache Maven goal:
For building the project: mvn clean test-compile
For executing tests: mvn clean test-compile failsafe:integration-test -DtestSuite=regression.xml -Denvironment=qa

### Break down into end to end tests

The project contains two packages that contains all the business level test cases:
1. The tests package which further breaks down into feature and regression. Both the feature and regression folders have
separate folders for backend and frontend tests.

2. The suites folder contains three xml files, backend.xml, frontend.xml, and regression.xml to execute API, GUI, and Regression tests respectively.

### Coding Standards Quick Checklist

1. Use Intention Revealing & Searchable Names
2. Always start your Class Name with a Capital letter
3. Always start your Method Name with a verb / verb phrase and camelCase
4. Objects / Instances names should always be in lowercase
5. Use Hungarian notation for variable names
6. Pick One Word per Concept
7. Don’t Pun
8. For object repository classes: use OR_WebpageName e.g. **OR_Login**
   For page classes: use WebpageName e.g. **Login**
9. Your Test Case class must always start with "TEST-" e.g. **TEST_BookingManagement**
10. Every frontend test case must extend SeleniumBase class and every backend test case must extend SpecBase class.

## Git Branching Model

* Create new branch per feature/test - describe it with Azure DevOps ticket + description
* Commit changes often and try to describe them well
* After finishing feature or test create a Pull Request
* Share it with team members for review
* If changes are needed, the author of PR will apply them
* Merge the PR to master

## Deployment

For each microservice repo under otoz, a test folder always contains thanos folder which includes all the test cases required to be executed against the microservice.
Thanos folder will also contain a Dockerfile for executing the test cases in DevOps pipeline.

## Authors

* TAFSEER HAIDER - *Designed and developed the Automated Test Framework* 

## License

This project is copyright under the sole ownership of NETSOL Technologies Inc. NETSOL License - see the [LICENSE.md](LICENSE.md) file for details


