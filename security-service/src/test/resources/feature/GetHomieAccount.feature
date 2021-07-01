Feature:
  Verify different GET operations using REST-assured

  Scenario: Get Homie
    Given I set GET homie service api endpoint
    When I get a homie by performing GET operation for the homie number "1"
    Then I should see the homie name as "luis ramirez"