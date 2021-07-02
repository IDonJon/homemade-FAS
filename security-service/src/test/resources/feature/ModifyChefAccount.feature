Feature:
  Verify different PUT operations using REST-assured

  Scenario: Verify update account
    Given I set up the modification of a chef account with PUT operation for "/chef"
    And I perform PUT for the chef number "1"
    Then I get a 200 status from modify chef service