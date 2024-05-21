package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseFavouriteTeam extends BaseObjects {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"title_onboarding\") and contains(@text,'teams')]")
    private WebElement chooseYourFavouriteTeamTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"txt_name\")]")
    private List<WebElement> favouriteTeamList;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"id/label\")]")
    private List<WebElement> selectedTeamTitle;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,\"btn_primary\")]")
    private WebElement continueButton;

    public ChooseFavouriteTeam(){
        super();
    }

    public boolean isChooseYourFavouriteTeamTitleDisplayed() {
        return chooseYourFavouriteTeamTitle.isDisplayed();
    }
    public String chooseYourFavouriteTeamTitle() {
        return chooseYourFavouriteTeamTitle.getText();
    }

    public List<WebElement> getFavouriteTeamList() {
        return favouriteTeamList;
    }



    public void selectTeamByName(String teamName) {
        for (int i = 0; i < favouriteTeamList.size(); i++) {
            WebElement team = favouriteTeamList.get(i);
            waitForElement(team);
            if (team.getText().equalsIgnoreCase(teamName)) {
                team.click();
                break;
            }
        }
    }

    public List<WebElement> getSelectedTeamTitle() {
        return selectedTeamTitle;
    }

    public boolean isTeamSelected(String teamInitials) {
        for (int i = 0; i < selectedTeamTitle.size(); i++) {
            WebElement team = selectedTeamTitle.get(i);
            waitForElement(team,3);
            if (team.getText().equalsIgnoreCase(teamInitials)) {
                return true;
            }
        }
        return false;
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
