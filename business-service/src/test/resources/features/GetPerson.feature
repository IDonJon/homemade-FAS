Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/post"
    And I perform GET for the recipe number "4"
    Then I should see the recipe name as "papa rellena"