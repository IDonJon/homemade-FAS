Feature:
  Verify different PUT operations using REST-assured

  Scenario: Verify update homie
    Given I set up the modification of a homie account with PUT operation for "/homie"
    And I perform PUT for the homie number "1"
    Then I get a 200 status from modify homie service