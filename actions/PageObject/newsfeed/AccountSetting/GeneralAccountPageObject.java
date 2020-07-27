package PageObject.newsfeed.AccountSetting;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;

public class GeneralAccountPageObject extends AbstractMenuPage {
    WebDriver driver;
    public GeneralAccountPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
