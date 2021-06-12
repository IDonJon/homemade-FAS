Feature:
  Verify different PUT operations using REST-assured

  Scenario: Verify update recipe
    Given I perform PUT operation for "/recipe"
    And I perform PUT for the recipe number "4"
    Then I get a 200 status