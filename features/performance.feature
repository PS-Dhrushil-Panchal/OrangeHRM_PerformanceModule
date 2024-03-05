Feature: Employee Report Generation

  Background: 
    Given User is on LoginPage
    When User enter valid username and password
    And click on Login button
    Then User is redirected to Homepage of OrangeHRM

  @Performance
  Scenario: Generate report with valid employee name and department
    Given the user is on the report generation page
    When the user enters a valid "employee name" and "department"
    And clicks on the generate report button
    Then a report for the specified employee and department is displayed

  @Performance
  Scenario: Attempt to generate report with invalid employee name
    Given the user is on the report generation page
    When the user enters an invalid "employee name" and a valid "department"
    And clicks on the generate report button
    Then reports of all the employee are displayed

  @Performance
  Scenario: Attempt to generate report with empty input fields
    Given the user is on the report generation page
    When the user does not enter any data into the input fields
    And clicks on the generate report button
    Then all the records available till now will be displayed

  @Performance
Scenario: Generate report with invalid input of dates
  Given the user is on the report generation page
  When User enters "FromDate" and "ToDate" invalid
  And clicks on the generate report button
  Then error should be generated of invalid dates
    | FromDate   | ToDate     | error                          |
    | 					 | 2023-01-01 | To date should be after from date |
    | 2024/01/01 | 2024/03/01 | Should be a valid date in yyyy-dd-mm format|
    | 29-01-2024 | 24-01-2024 | Should be a valid date in yyyy-dd-mm format|
