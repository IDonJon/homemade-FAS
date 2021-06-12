Feature:
  Verify different GET all operations using REST-assured

  Scenario: Verify one author of the get all
    Given I perform GET operation for the "/menus"
    And I perform GET all menus
    Then I get "4" menus as a result