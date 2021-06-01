Feature:
  Verify different  GET operations using REST-assured

  Scenario:  Verify one author of the comment
    Given I perform GET operation for "/comments/id"
    And I perform GET operation for "1"
    Then  I should see the comment as "excellente!"