package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainMenuPage extends BaseObjects {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageButton\")")
    private WebElement profileButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'navigation_bar_item_small_label_view')]")
    private List<WebElement> bottomMenuTabText;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'navigation_bar_item_large_label_view')]")
    private WebElement favouritesTabText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*id/label.*\")")
    private List<WebElement> selectedFavouriteTeamOrLeague;

    public MainMenuPage(){
        super();
    }

    public void clickProfileButton() {
        profileButton.click();
    }

    public List<WebElement> getBottomMenuTabText() {
        return bottomMenuTabText;
    }

    public List<WebElement> getSelectedFavouriteTeamOrLeague() {
        return selectedFavouriteTeamOrLeague;
    }

    public boolean isProfileButtonDisplayed(){
        return isElementDisplayed(profileButton, "Profile button on top left corner displayed");
    }

    public String getBottomMenuTabText(int index) {
        return bottomMenuTabText.get(index).getText();
    }
    public String getFavouritesTabText(){
        return favouritesTabText.getText();
    }

    public void tapLeagueTeamFromFavourites(String leagueTeamSelected) {
        for (int i = 0; i < selectedFavouriteTeamOrLeague.size(); i++) {
            WebElement leagueTeamTitle = selectedFavouriteTeamOrLeague.get(i);
            if (leagueTeamTitle.getText().equalsIgnoreCase(leagueTeamSelected)) {
                leagueTeamTitle.click();
                logMessage("pass", "League or team tapped from favourites: " + leagueTeamSelected);
                break; // Exit the loop after clicking the element
            }
        }
    }
}
