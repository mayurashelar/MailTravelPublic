Feature: Verify confirm details page
  As a user I should see Verify confirm details page

  Background:
    Given User is on home page
    And user clicks on Accept All Cookies button
    And User enters "India" on search bar
    When list of "India" tour is displayed
    Then User should select first option India from the list
    And Navigated on "India" Tour page

  Scenario: Verify the Confirm Details+BookPage and Verify the Book Now button is enabled
    Given User book a tour for 2 adults by clicking book online button
    And User select accommodation as 1 for Twin room
    And User is on Passenger details section
    And User fill passenger details
      | adult1Title | adult1FirstName | adult1LastName | adult1BirthDay | adult1BirthMonth | adult1BirthYear | adult2Title | adult2FirstName | adult2LastName | adult2BirthDay | adult2BirthMonth | adult2BirthYear |
      | Mr          | John            | Taylor         | 3              | March            | 1991            | Mrs         | Annie           | Taylor         | 12             | June             | 1992            |
    And User fill Lead Contact Details
      | mobilePhoneNumber | emailAddress  | AddressLine1    | AddressLine2 | city    | postCode | country        | hearAboutUs |
      | 07712345699       | abc@gmail.com | 2 RockeBy Close | Park Road    | Bristol | RG122NA  | United Kingdom | Email       |
    And User clicks on continue button
    When User is navigated on Confirm Details page.
    Then "Confirm Details + Book" text is appear
    And Book Now button is enabled


