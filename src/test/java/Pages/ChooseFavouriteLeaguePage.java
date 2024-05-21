package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseFavouriteLeaguePage {

    // Android locators
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'title_onboarding') and contains(@text,'leagues')]")
    private WebElement chooseYourFavouriteLeaguesTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'txt_name')]")
    private List<WebElement> leagueTitles;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'id/label')]")
    private List<WebElement> selectedLeagueTitles;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'btn_primary')]")
    private WebElement continueButton;


}
