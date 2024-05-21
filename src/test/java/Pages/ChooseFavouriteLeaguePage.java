package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseFavouriteLeaguePage extends BaseObjects {

    // Android locators
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'title_onboarding') and contains(@text,'leagues')]")
    private WebElement chooseYourFavouriteLeaguesTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'txt_name')]")
    private List<WebElement> leagueTitles;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/label')]")
    private List<WebElement> selectedLeagueTitles;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'btn_primary')]")
    private WebElement continueButton;

    public ChooseFavouriteLeaguePage(){
        super();
    }


    public boolean isChooseYourFavouriteLeaguesTitleDisplayed() {
        return chooseYourFavouriteLeaguesTitle.isDisplayed();
    }

    public String getChooseYourFavouriteLeagueTitleText(){
        return chooseYourFavouriteLeaguesTitle.getText();
    }

    public List<WebElement> getLeagueTitles() {
        return leagueTitles;
    }
    public void selectLeagueByName(String leagueName) {
        boolean leagueFound = false;
        for (int i = 0; i < leagueTitles.size(); i++) {
            WebElement leagueTitle = leagueTitles.get(i);
            waitForElement(leagueTitle);
            if (leagueTitle.getText().equalsIgnoreCase(leagueName)) {
                leagueTitle.click();
                logMessage("pass", leagueName + " is selected");
                leagueFound = true;
                break;
            }
        }
    }

    public List<WebElement> getSelectedLeagueTitles() {
        return selectedLeagueTitles;
    }

    public boolean isLeagueSelected(String leagueName) {
        List<WebElement> selectedLeagueTitles = getSelectedLeagueTitles();
        for (int i = 0; i < selectedLeagueTitles.size(); i++) {
            WebElement selectedLeagueTitle = selectedLeagueTitles.get(i);
            waitForElement(selectedLeagueTitle);
            if (selectedLeagueTitle.getText().equalsIgnoreCase(leagueName)) {
                return true;
            }
        }
        return false;
    }

    public void clickContinueButton() {
        continueButton.click();
        logMessage("pass","continue button tapped on choose your favourite league screen");
    }
}
