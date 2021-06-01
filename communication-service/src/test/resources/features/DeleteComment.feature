Feature:
  Verify different Delete operations using REST-assured
  
  Scenario: Verify one Author of the Delete
    Given I perform Delete operation for "/comments"
    And I perform Delete for the comment number "1"
    Then  I get a 200 status