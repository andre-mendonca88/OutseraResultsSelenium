Feature: JSONPlaceholder E2E Test

  Scenario: Navigate and validate data from albums
    Given I open the guide page
    When I click on the guide menu
    And I navigate to albums photos
    Then I should see the photos data
    And I validate the object with id 6