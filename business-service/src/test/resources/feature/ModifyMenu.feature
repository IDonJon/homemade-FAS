Feature:
  Verify different PUT operations using REST-assured

  Scenario: Verify update menu
    Given I perform PUT operation for "/menu"
    And I perform PUT for the menu number "4"
    Then I get a 200 status