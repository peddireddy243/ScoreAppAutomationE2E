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

}
