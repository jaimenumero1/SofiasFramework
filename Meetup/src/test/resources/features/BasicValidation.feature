Feature: BasicValidation

  Scenario: Title Verification
    Given the user is on the MeetUp homepage
    Then the title should be "Meetup - We are what we do"


    Scenario: Join MeetUp button Verification
      Given the user is on the MeetUp homepage
      Then verify Join Meetup button is displayed