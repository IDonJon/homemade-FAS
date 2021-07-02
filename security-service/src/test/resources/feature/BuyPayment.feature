Feature:
  Verify different POST operations using REST-assured

  Scenario: Create a Payment account
    Given I set up the creation of a new payment with POST operation for "/payments"
    When I perform POST payment
    Then  I get a 200 status from the payment service