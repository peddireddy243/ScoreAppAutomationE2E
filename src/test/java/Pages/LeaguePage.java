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

    public String getLeagueTitle() {
        return leagueTitle.getText();
    }

    public List<WebElement> getLeagueTabs() {
        return leagueTabs;
    }

    public List<WebElement> getLeagueTitlesList() {
        return leagueTitlesList;
    }

    public void clickLeagueTab(String tabName) {
        for (int i = 0; i < leagueTabs.size(); i++) {
            WebElement tab = leagueTabs.get(i);
            if (tab.getText().equalsIgnoreCase(tabName)) {
                tab.click();
                return; // Exit the method after clicking the tab
            }
        }
    }

    public String getLeagueConferenceSelectedText() {
        sleep(3);
        return leagueConferenceSelectedText.getText();
    }
    public void clickConferenceSelectionButton(){
        waitForElement(leagueConferenceSelectedText).click();
    }

    public void clickLeagueTitle(String title) {
        for (int i = 0; i < leagueTitlesList.size(); i++) {
            WebElement leagueTitle = leagueTitlesList.get(i);
            if (leagueTitle.getText().equalsIgnoreCase(title)) {
                leagueTitle.click();
                return; // Exit the method after clicking the title
            }
        }
    }

    public String getTableTitle() {
        return waitForElement(tableTitle,3).getText();
    }

    public void clickBackButton() {
        backButton.click();
    }
}
