Feature: Passenger and tour details page feature
  As a user I a should see Passenger and tour details page feature

  Background:
    Given User is on home page
    And user clicks on Accept All Cookies button
    And User enters "India" on search bar
    When list of "India" tour is displayed
    Then User should select first option India from the list
    And Navigated on "India" Tour page

  Scenario: Validate Date, Department and Passengers details
    Given User book a tour for 2 adults by clicking book online button
    When User click on Date, Departure & Passenger section
    Then Populated details in Date, Departure & Passenger section are valid

  Scenario: Select Accommodation details
    Given User book a tour for 2 adults by clicking book online button
    And User is in Accommodation section.
    And select number required as 1 for Twin room
    When User click on "Select Your Room And Continue" button.
    Then User should navigate on Extra section


  Scenario: Fill Passenger details
    Given User book a tour for 2 adults by clicking book online button
    And User select accommodation as 1 for Twin room
    And User is on Passenger details section
    And User fill passenger details
      | adult1Title | adult1FirstName | adult1LastName | adult1BirthDay | adult1BirthMonth | adult1BirthYear | adult2Title | adult2FirstName | adult2LastName | adult2BirthDay | adult2BirthMonth | adult2BirthYear |
      | Mr          | John            | Taylor         | 3              | March            | 1991            | Mrs         | Annie           | Taylor         | 12             | June             | 1992            |
    And User fill Lead Contact Details
      | mobilePhoneNumber | emailAddress  | AddressLine1    | AddressLine2 | city    | postCode | country        | hearAboutUs |
      | 07712345699       | abc@gmail.com | 2 RockeBy Close | Park Road    | Bristol | RG122NA  | United Kingdom | Email       |
    When User clicks on continue button
    Then User is navigated on Confirm Details page.







