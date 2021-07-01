Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a Chef account
    Given I perform POST operation for "/chef"
    When I perform POST chef
    Then  I get a 200 status from the chef service