Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a recipe
    Given I perform POST operation for "/recipe"
    And I perform POST recipe
    Then  I get a 200 status