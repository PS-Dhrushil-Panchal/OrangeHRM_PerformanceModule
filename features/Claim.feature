Feature: Submit Claims

  Background: 
    Given User is on LoginPage
    When User enter valid username and password
    And click on Login button
    Then User is redirected to Homepage of OrangeHRM

  @claim
  Scenario: creating claim by entering valid details
    Given User has click on submit claim buttom
    When user input require data into input fields
    And click on create button
    Then Submit claim page should open

  @claim
  Scenario: submitting claim by adding expences
    Given user has create claim without adding expense
    When user click on add expense button
    Then a form for adding expense details should open
    When user add require details inn form
    And click on save button
    And click on submit button
    Then claim amount should be updated.

  #@claim
  Scenario: submitting claim without entering require informatio
    Given user has click on submit claim buton
    When user does not input in require field
    And click on create button
    Then "Require" error message should be displayed.
