package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeaguePage extends BaseObjects {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'titleTextView')]")
    private WebElement leagueTitle;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    private List<WebElement> leagueTabs;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'subTitleTextView')]")
    private WebElement leagueConferenceSelectedText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*text_conf_item.*\")")
    private List<WebElement> leagueTitlesList;

    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@resource-id,'txt_name')])[1]")
    private WebElement tableTitle;

    @AndroidFindBy(accessibility = "Navigate up")
    private WebElement backButton;

    public LeaguePage(){
        super();
    }

}
