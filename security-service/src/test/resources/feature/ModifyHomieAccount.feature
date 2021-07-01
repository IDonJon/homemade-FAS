Feature:
  Verify different PUT operations using REST-assured

  Scenario Outline: Verify update homie
    Given I set PUT account service api for "/homie"
    And I perform PUT for the homie number "1"
    Then I get a 200 status from modify homie service
    Examples: