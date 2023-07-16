Feature: Book Online page feature
  AS a user I should see Book Online page feature

  Background:
    Given User is on home page
    And user clicks on Accept All Cookies button
    And User enters "India" on search bar
    When list of "India" tour is displayed
    Then User should select first option India from the list
    And Navigated on "India" Tour page

  Scenario: Book next available tour
    Given User select next available date
    And select the 2 adults and validate the price
    And make a note of departure selection
    When user click on Book Online button
    Then tour booking details page should be displayed

  Scenario: User should not see the Please select your departure date text after the date selection
    Given "Please select your departure date" text is displayed before selecting date
    When User select next available date
    Then "Please select your departure date" text" should not be displayed.


