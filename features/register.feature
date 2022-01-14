Feature: Register Page
  Scenario: A user registers
  Given a user is on the register page
  When a user inputs their information and clicks submit
  Then a user is redirected to the login page
  Scenario: A user logs in using their newly registered info
    Given A user is now on the login page
    When A user inputs new credentials on the login form
    Then the user will now be redirect to the main feed
