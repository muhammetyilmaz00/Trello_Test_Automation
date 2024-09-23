# Trello Test Automation

## Overview

This repository contains automated UI and API tests for creating Trello boards. 
The tests are written in Java using Cucumber, JUnit, Maven, RestAssured for the API tests, and Selenium for the UI tests. 
These tests provide confidence in the functionality and reliability of Trello Board creation.

# Tech Stack

* **Cucumber**: A behavior-driven development (BDD) framework that allows for easy test creation and understanding through plain text descriptions.
* **Java:** The primary programming language for writing the test automation code.
* **RestAssured**: A Java library used to perform HTTP requests and validate responses when interacting with RESTful APIs.
* **Selenium**: A web automation tool for testing web applications
* **JUnit**: A popular testing framework for writing and executing test cases.
* **Maven**: A build automation and project management tool for managing project dependencies and building Java-based applications.

## API Documentation

For reference, the API documentation can be found at [Trello API Documentation](https://developer.atlassian.com/cloud/trello/guides/rest-api/api-introduction/).
This resource will provide you with in-depth details about the API endpoints and their functionality.

## How to Run Tests
**Note**: 
You must have a configuration.properties file in the root directory. You must fill "**key**" , "**token**", "**username**" and "**password**" fields in the file.

The **configuration.properties** file will look like this:
```configuration.properties
key = your-api-key-value
token = your-api-token-value
username = your-username-value
password = your-password-value
```

To execute the test suite, follow these steps:

1. Open a command prompt or terminal and navigate to the application's root folder.
2. Run the following command to clean the project and verify the tests:

   `mvn clean verify`
3. If you want to run a specific feature, you can use a feature tag to isolate specific tests. For example:

   `mvn clean verify -q -Dcucumber.filter.tags="@createBoardViaAPI"`

# Test Report

After running the tests, you can access the test report via the following link: [Report Collection](https://reports.cucumber.io/report-collections/9b6317f1-3fd4-4491-af96-ace88edc3f05)

# Improvements

1- Multiple positive and negative UI and API test scenarios for the CRUD operations of 
* BOARDS
* LISTS
* CARDS
* SEARCH

2- Rerun mechanism implementation

3- Upgrade report mechanism