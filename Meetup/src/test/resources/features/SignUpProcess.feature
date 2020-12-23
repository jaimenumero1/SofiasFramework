@signup
Feature: SignUpProcess

  Background:
    Given the user is on the MeetUp homepage

  Scenario: Verify all sign up options are displayed
    When the user clicks Join Meetup button
    Then display all sign up options