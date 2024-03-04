Feature: Login into portal

Background:
Given User is on LoginPage



@Performance

Scenario: User login with invalid username and password


When User enter invalid credentials
And click on Login button
Then User gets "Invalid credentials" message and access to portal is denied

@Performance

Scenario: User login with valid username and password

When User enter valid username and password
And click on Login button
Then User is redirected to Homepage of OrangeHRM

