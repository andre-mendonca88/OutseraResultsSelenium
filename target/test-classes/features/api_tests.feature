Feature: JSONPlaceholder API Tests

  Scenario: Perform a GET request and validate the response
    Given I send a GET request to comments endpoint with name "alias odio sit"
    Then the response status should be 200
    And the email should be "Lew@alysha.tv"

  Scenario: Perform a POST request and validate the response
    Given I send a POST request to users endpoint with name "New User", username "newuser" and email "newuser@example.com"
    Then the response status should be 201
    And the response should contain an id

  Scenario: Perform a PUT request and validate the response
    Given I send a PUT request to update user with id 5
    Then the response status should be 200
    And the response email should be "updatedemail@example.com"
    And the response lat should be "-37.3159"
    And the response lng should be "81.1496"