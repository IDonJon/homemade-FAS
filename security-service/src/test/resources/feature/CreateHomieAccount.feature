Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a Homie account
    Given I set up the creation of a new homie with POST operation for "/homies"
    When I perform POST homie
    Then  I get a 200 status from the homie service