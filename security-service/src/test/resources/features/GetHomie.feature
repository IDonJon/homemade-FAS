Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/homies"
    And I perform GET for the homie number "3"
    Then I should see the recipe name as "Sara Sanchez"