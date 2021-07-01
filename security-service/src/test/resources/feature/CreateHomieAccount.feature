Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a Homie account
    Given I perform POST operation for "/homies"
    And I perform POST homie
    Then  I get a 200 status from the homie service