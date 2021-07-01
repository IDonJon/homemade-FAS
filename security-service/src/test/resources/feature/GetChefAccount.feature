Feature:
  Verify different GET operations using REST-assured

  Scenario: Get Chef
    Given I set GET chef service api endpoint
    When I get a chef by performing GET operation for the chef number "1"
    Then I should see the chef name as "gaston acurio"