package StepDefinitions;


import Utilities.*;
import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeagueStandingStepDef  extends BaseObjects{

    public LeagueStandingStepDef() {
        super();
    }

    WelcomePage welcomePage = new WelcomePage();
    ChooseFavouriteLeaguePage chooseFavouriteLeaguePage = new ChooseFavouriteLeaguePage();
    ChooseFavouriteTeam chooseFavouriteTeam = new ChooseFavouriteTeam();
    MainMenuPage mainMenuPage = new MainMenuPage();
    NeverMissAGamePage neverMissAGamePage = new NeverMissAGamePage();
    PromptsPage promptsPage = new PromptsPage();
    LeaguePage leaguePage = new LeaguePage();

    @Given("I have landed on Welcome Screen and continued")
    public void iHaveLandedOnWelcomeScreenAndContinued() {
        Assertions.assertEquals(welcomePage.getWelcomeTitleText(), "WELCOME");
        welcomePage.clickGetStartedButton();
    }

    @And("I have selected a favorite league {string} verify selection as {string} and continued")
    public void iHaveSelectedAFavoriteLeagueAndContinued(String leagueName, String selectedLeague) {
        Assertions.assertEquals(chooseFavouriteLeaguePage.getChooseYourFavouriteLeagueTitleText(),"Choose your favorite leagues");
        chooseFavouriteLeaguePage.selectLeagueByName(leagueName);
        DataStore.put(Constants.FAV_LEAGUE,leagueName);
        Assertions.assertTrue(chooseFavouriteLeaguePage.isLeagueSelected(selectedLeague),"Favourite league selected");
        chooseFavouriteLeaguePage.clickContinueButton();
    }

    @Then("I have selected a favorite team {string} verify selection as {string} and continued")
    public void iHaveSelectedAFavoriteTeamAndContinued(String teamName, String selectedTeam) {
        if(promptsPage.isTailoredContentTitleDisplayed()){
            promptsPage.clickMaybeLaterButton();
        }
        Assertions.assertEquals(chooseFavouriteTeam.chooseYourFavouriteTeamTitle(),"Choose your favorite teams");
        chooseFavouriteTeam.selectTeamByName(teamName);
        Assertions.assertTrue(chooseFavouriteTeam.isTeamSelected(selectedTeam),"Favourite team selected");
        chooseFavouriteTeam.clickContinueButton();
    }

    @And("I have landed on Never miss a game screen and continue")
    public void iHaveLandedOnNeverMissAGameScreenAndContinue() {
        Assertions.assertEquals(neverMissAGamePage.neverMissAGameTitleText(),"Never miss a game");
        neverMissAGamePage.clickContinueButton();
    }

    @And("I have reached the main menu screen after dismissing first-time prompts")
    public void iHaveReachedTheMainMenuScreenAfterDismissingFirstTimePrompts() {
        if(promptsPage.isTheScoreMessagingTitleDisplayed()){
            promptsPage.clickEmailSignUpMaybeLaterButton();
        }
        if(promptsPage.isSendNotificationsAlertTitleDisplayed()){
            promptsPage.clickDoNotAllowButton();
        }
        if(promptsPage.isTheScoreBetTitleDisplayed()){
            promptsPage.clickTheScoreBetCloseButton();
        }
        if(mainMenuPage.isProfileButtonDisplayed()){
            Assertions.assertEquals(mainMenuPage.getFavouritesTabText(),"Favorites");
            logMessage("pass","User landed on main menu screen");
        }
    }

    @When("I select {string} from the favorites list")
    public void iSelectFromTheFavoritesList(String teamSelection) {
        mainMenuPage.tapLeagueTeamFromFavourites(teamSelection);
    }

    @And("I Validate league or team selected title")
    public void iNavigateToTheLeagueScreen() {
        Assertions.assertEquals(leaguePage.getLeagueTitle(), String.valueOf(DataStore.get(Constants.FAV_LEAGUE)));
    }

    @And("I tap on the {string} tab")
    public void iTapOnTheStandingsTab(String tabName) {
        leaguePage.clickLeagueTab(tabName);
    }

    @And("I select {string} from the conferences and validate selection")
    public void iSelectFromTheConferencesSelection(String conference) {
        String conferenceSelected = leaguePage.getLeagueConferenceSelectedText();
        leaguePage.clickConferenceSelectionButton();
        leaguePage.clickLeagueTitle(conference);
        if(!conferenceSelected.equalsIgnoreCase(conference)) {
            Assertions.assertEquals(leaguePage.getTableTitle(), conference);
            logMessage("pass","Conference selection is successful");
        }
    }


    @And("I tap the back button on the league screen and validate landing on main menu screen")
    public void iTapTheBackButtonOnTheLeagueScreen() {
        leaguePage.clickBackButton();
        Assertions.assertEquals(mainMenuPage.getFavouritesTabText(),"Favorites");
        Assertions.assertTrue(mainMenuPage.isProfileButtonDisplayed(),"Profile button on Main menu screen displayed");
    }

}
