Feature:
  Verify different Delete operations using REST-assured

  Scenario: Verify one Author of the Delete
    Given I perform Delete operation for
    And I perform Delete for the message number "18"
    Then  I get a 200 status