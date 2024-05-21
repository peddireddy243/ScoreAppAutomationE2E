package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class PromptsPage{

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

}
