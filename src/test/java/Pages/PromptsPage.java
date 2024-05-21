package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PromptsPage extends BaseObjects {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'location_title')]")
    private WebElement tailoredContentTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'btn_disallow')]")
    private WebElement maybeLaterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'title_onboarding') and contains(@text,'Messaging')]")
    private WebElement theScoreMessagingTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'btn_secondary')]")
    private WebElement emailSignUpMaybeLaterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'permission_message')]")
    private WebElement sendNotificationsAlertTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'permission_deny_button')]")
    private WebElement doNotAllowButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'sportsbook_logo')]")
    private WebElement theScoreBetTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@resource-id,'dismiss_modal')]")
    private WebElement theScoreBetCloseButton;

    public PromptsPage(){
        super();
    }

    public boolean isTailoredContentTitleDisplayed() {
        return tailoredContentTitle.isDisplayed();
    }

    public void clickMaybeLaterButton() {
        maybeLaterButton.click();
        logMessage("pass","May be later button on tailored content prompt tapped");
    }

    public boolean isTheScoreMessagingTitleDisplayed() {
        return isElementDisplayed(theScoreMessagingTitle,"Introducing the Score Messaging prompt screen");
    }

    public void clickEmailSignUpMaybeLaterButton() {
        emailSignUpMaybeLaterButton.click();
        logMessage("pass","May be later button on Email Signup prompt tapped");

    }

    public boolean isSendNotificationsAlertTitleDisplayed() {
        return isElementDisplayed(sendNotificationsAlertTitle,"Send Notification dialogue prompt");
    }

    public void clickDoNotAllowButton() {
        waitForElement(doNotAllowButton).click();
        logMessage("pass","Don't Allow button on Send Notification prompt tapped");

    }

    public boolean isTheScoreBetTitleDisplayed() {
        return isElementDisplayed(theScoreBetTitle,"TheScore Bet Download Prompt displayed");
    }

    public void clickTheScoreBetCloseButton() {
        theScoreBetCloseButton.click();
        logMessage("pass","Close button on theScore Bet Download prompt tapped");

    }
}
