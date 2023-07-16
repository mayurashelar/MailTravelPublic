Feature: Search page feature
  As a user I should see Search page feature

  Background:
    Given User is on home page
    And user clicks on Accept All Cookies button

  Scenario: Search functionality
    Given User enters "India" on search bar
    When list of "India" tour is displayed
    Then User should select first option India from the list
    And Navigated on "India" Tour page
    And User clicks on Book Online button


