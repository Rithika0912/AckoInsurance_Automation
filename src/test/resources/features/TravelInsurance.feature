Feature: Travel Insurance

  Scenario: Verify travel insurance flow

    Given User launches Acko application
    When User selects travel insurance
    And User enters travel country
    Then Travel plans should be displayed