Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a Payment account
    Given I perform POST operation for "/payments"
    And I perform POST payment
    Then  I get a 200 status from the payment service