Feature: Main Page
  Background: A user successfully logged in and is on the main page
    Given A user is on the login page
    When A user inputs correct credentials on the login form
    Then the user will be redirect to the main feed
  Scenario: Clicking the create post button brings up a modal
    Given A user is on the main page
    When A user clicks the create post button
    Then A modal pops up
    Given The create post modal is showing
    When A user inputs fields and hits create post button
    Then A new post with the same text entered shows
  Scenario: Clicking on the profile button will redirect to the profile page
    Given A user is on the main page
    When A user clicks on the profile button
    Then A user is taken to their profile