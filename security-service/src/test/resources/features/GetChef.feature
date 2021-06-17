Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one Chef of the post
    Given I perform GET operation for "/chefs"
    And I perform GET for the recipe number "2"
    Then I should see the Chef name as "Juan Lopez"