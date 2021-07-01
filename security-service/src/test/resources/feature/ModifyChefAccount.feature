Feature:
  Verify different PUT operations using REST-assured

  Scenario: Verify update account
    Given I set PUT account service api for "/chef"
    And I perform PUT for the chef number "1"
    Then I get a 200 status from modify chef service