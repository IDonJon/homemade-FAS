Feature:
  Verify different Delete operations using REST-assured

  Scenario: Verify one author of the delete
    Given I perform Delete operation for
    And I perform Delete for the recipe number "4"
    Then  I get a 200 status