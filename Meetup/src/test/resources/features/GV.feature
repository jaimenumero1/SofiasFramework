Feature: GoogleVerification

  Background:
    Given the user is on google page

  Scenario: Search results verification
    When the user types "flower" in a search field
    And the user clicks search
    Then verify the search results contain "flower"
