@sample
Feature: FirstFeatureFile

  @simpleTest
  Scenario: Validate NCAA Standings and Team Title in Standings Table
    Given I have landed on Welcome Screen and continued
    And I have selected a favorite league and continued
    Then I have selected a favorite team and continued
    And I have reached the main menu screen after dismissing first-time prompts
    When I select "NCAA" from the favorites list
    And I navigate to the "NCAA Football" league screen
    And I tap on the standings tab
    And I select "ACC" from the conferences selection
    Then I verify that the standings table title displayed is for "ACC"
    And I tap the back button on the league screen
    And I return to the main menu screen
