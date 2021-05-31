Feature:
  Verify different  GET operations using REST-assured

  Scenario:  Verify one author of the message
    Given I perform GET operation for "/post"
    And I perform GET operation for "4"
    Then  I should see the publication name as "zanahoria rayada"