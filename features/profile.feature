Feature: Profile Page
  Background: A user successfully logged in and is on the main page
    Given A user is on the login page
    When A user inputs correct credentials on the login form
    Then the user will be redirect to the main feed
    Given A user is on the main page
    When A user clicks on the profile button
    Then A user is taken to their profile

  Scenario: A user updates their profile first and last name
    Given A user is on their profile page
    When A user clicks on the update button and updates their profile
    Then The updated information displays on their profile
