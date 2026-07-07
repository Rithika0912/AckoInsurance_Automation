Feature: Car Insurance

  Scenario: Verify invalid phone number and pincode validation

    Given User launches Acko website for car insurance
    When User selects Car Insurance
    And User selects Tata Punch Petrol Manual Pure MT vehicle
    And User enters invalid phone number and pincode
    Then Proper validation messages should be displayed
    And close the Browser
