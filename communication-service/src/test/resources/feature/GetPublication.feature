Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/publications"
    And I perform GET for the publication number "1"
    Then I should see the publication name as "Nueva Aventura!"