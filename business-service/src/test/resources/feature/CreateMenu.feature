Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a menu
    Given I perform POST operation for "/menu"
    And I perform POST menu
    Then I get a 200 status
