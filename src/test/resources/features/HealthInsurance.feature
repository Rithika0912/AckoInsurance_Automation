Feature: Extract Health Insurance Menu Items

  Scenario: Get all health insurance menu items

    Given User launches Acko website for health insurance
    When User clicks on Products
    And User retrieves Health Insurance menu items
    Then Display menu items
    And Save menu items to Excel
    And Navigate back to home page


