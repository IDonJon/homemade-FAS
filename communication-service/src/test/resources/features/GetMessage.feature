Feature:
  Verify different  GET operations using REST-assured

  Scenario:  Verify one author of the message
    Given I perform GET operation for "/messages/id"
    And I perform GET operation for "1"
    Then  I should see the message as "hola!"