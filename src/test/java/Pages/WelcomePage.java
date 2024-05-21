package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class WelcomePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'txt_welcome')]")
    @iOSXCUITFindBy(iOSNsPredicate ="name == 'WELCOME'")
    private WebElement welcomeTitleText;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'btn_primary')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'GET STARTED'")
    private WebElement getStartedButton;

}

