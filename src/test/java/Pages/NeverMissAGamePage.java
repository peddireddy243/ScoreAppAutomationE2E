package Pages;

import Utilities.BaseObjects;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NeverMissAGamePage extends BaseObjects{

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'title_onboarding') and contains(@text,'miss')]")
    private WebElement neverMissAGameTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'btn_primary')]")
    private WebElement continueButton;

    public NeverMissAGamePage(){
        super();
    }

    public String neverMissAGameTitleText(){
        return waitForElement(neverMissAGameTitle).getText();
    }

    public void clickContinueButton() {
        continueButton.click();
        logMessage("pass","Continue button on never miss a screen tapped");
    }
}
