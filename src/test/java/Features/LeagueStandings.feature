@LeagueStandings @Regression
Feature: League feature

  @Task1
  Scenario: Validate NCAAF Standings and Team Title in Standings Table
    Given I have landed on Welcome Screen and continued
    And I have selected a favorite league "NCAA Football" verify selection as "NCAAF" and continued
    Then I have selected a favorite team "Toronto Maple Leafs" verify selection as "TOR" and continued
    And I have landed on Never miss a game screen and continue
    And I have reached the main menu screen after dismissing first-time prompts
    When I select "NCAAF" from the favorites list
    And I Validate league or team selected title
    And I tap on the "STANDINGS" tab
    Then I select "ACC" from the conferences and validate selection
    And I tap the back button on the league screen and validate landing on main menu screen



#    No real test here just to confirm custom tag running as provided in the testng parameters
  @Task2
  Scenario: Validate NCAA Standings and Team Title in Standings Table1
    Given I have landed on Welcome Screen and continued
    And I have selected a favorite league "NCAA Football" verify selection as "NCA" and continued
