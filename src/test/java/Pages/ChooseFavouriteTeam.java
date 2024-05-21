package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseFavouriteTeam {
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"title_onboarding\") and contains(@text,'teams')]")
    private WebElement chooseYourFavouriteTeamTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"txt_name\")]")
    private List<WebElement> favouriteTeamList;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"id/label\")]")
    private List<WebElement> selectedTeamTitle;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,\"btn_primary\")]")
    private WebElement continueButton;

}
