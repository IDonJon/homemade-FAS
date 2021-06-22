Feature:
  Verify different GET operations using REST-assured

Scenario: Post a Publication
    Given I perform POST operation for "/messages"
    And I perform POST message
    Then  I get a 200 status from the message service