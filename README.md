[![Java CI with Maven](https://github.com/akshaymungekar95/DistilledAutomationTask/actions/workflows/maven.yml/badge.svg)](https://github.com/akshaymungekar95/DistilledAutomationTask/actions/workflows/maven.yml)



# Distilled UI Automation Task

# Framework details:
### Java-based test automation framework built on top of Selenium WebDriver, JUnit, Cucumber and Maven.

### Tools:
-   Java
-   Selenium WebDriver
-   JUnit (TDD)
-   Cucumber (BDD) / Gherkin
-   Maven
-   Log4j

## The Problem
User search properties for sale in Dublin(County) and filter the results based on garage keyword.
Validate the search results after applying the filter, and open a specificresult to check the presence of "garage" keyword on that advert.

## Table of Contents

- [Framework Structure](#framework-structure)
- [Pre-requisites](#pre-requisites)
- [Getting Started](#getting-started)
- [Writing Tests](#writing-tests)
- [Report Generation](#report-generation)

## Framework Structure

The framework follows a Page Object Model structure, including the following main components:

- **resources:** Configuration files for log4j and config.properties file.
- **scripts:** Shell script for installing chrome on target GitHub Actions CI Server (ubuntu in this case).
- **src/test/java/enums:** Browser names reference.
- **src/test/java/features:** Feature file to execute the scenarios.
- **src/test/java/pageObjects:** Web element locators and action methods based on the individual pages.
- **src/test/java/pageObjects/BasePage:** Initializes WebDriver instance using PageFactory.
- **src/test/java/stepDefinitions:** Implements steps for the feature scenarios and asserts them accordingly.
- **src/test/java/stepDefinitions/ServiceHooks:** setup and tearDown Methods to run code before and after each scenario.
- **src/test/java/testBase:** Configuration methods to configure browser drivers, load properties.
- **src/test/java/testRunner:** Configure Cucumber test execution configuration.
- **pom.xml:** Defines project dependencies, configurations, and build settings for managing and running Cucumber tests.
- **target:** Location of generated reports (cucumber-reports) in html and json format.


## Pre-requisites

Before you begin, make sure you have the following prerequisites installed:

- Java Development Kit (JDK) 11 or higher
- Maven
- Updated Web Browsers - Chrome, Firefox

## Getting Started,

1. Clone this repository to your local machine.
git clone https://github.com/akshaymungekar95/DistilledAutomationTask.git

## For executing tests on browser,


2.1 Navigate to the project's root directory,
```cd DistilledAutomationTask/src/test/java/stepDefinitions/ServiceHooks.java```

2.2 Update the following line,
```testBase.selectBrowser(Browsers.HEADLESS.name()); ```
	TO
	``` testBase.selectBrowser(Browsers.CHROME.name()); ```
				   
2.3 Execute the following command,
	```mvn clean install```
	
## For executing tests on headless mode,
3.1 Navigate to the project's root directory,
```cd DistilledAutomationTask```

3.2  Execute the following command,
```mvn clean install```
	
## Writing Tests

Write your test scenarios in feature files under src/test/java/features. 
Follow the Gherkin language for clear and readable scenarios.
```
Feature: Daft Website Keyword Filtering

  Background:
    Given user navigates to Daft homepage url

  Scenario Outline: Validate the search results after applying the "garage" keyword filter
    When user searches for county "<county>" in the input field
    And user clicks on the desired location from the dropdown suggestions
    Then search results should be displayed for this location
    When user clicks on the filter option and applies the "<filter>" filter
    Then search results should be displayed for the filter
    Examples:
      | county | filter |
      | Dublin | garage |
	  
Implement step definitions in Java under src/test/java/stepDefinitions.
Each step in the scenario should have a corresponding step definition.
		
   @Given("user navigates to Daft homepage url")
    public void user_navigates_to_daft_homepage_url() throws InterruptedException {
        logger.info("Navigating to url");
        hp=new HomePage(driver);
        hp.navigateToHomepage(TestBase.url);
    }

    @When("user searches for county {string} in the input field")
    public void user_searches_for_county_in_the_input_field(String location) throws InterruptedException {
        hp = new HomePage(driver);
        hp.enterDesiredLocation(location);
    }
```
## Report Generation
Test results will be stored in the target/cucumber-reports directory.
In the case of test failures, a screen-shot of the UI at the point of failure is embedded into the report.

Sample Cucumber Report:

<img src = "https://github.com/akshaymungekar95/DistilledAutomationTask/blob/master/images/Cucumber_report.png" title = "cucumber-html-report"/>