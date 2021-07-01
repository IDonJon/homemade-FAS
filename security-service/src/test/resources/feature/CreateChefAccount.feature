Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a Chef account
    Given I perform POST operation for "/chef"
    And I perform POST message
    Then  I get a 200 status from the message service