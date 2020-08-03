package PageObject.newsfeed.AccountSetting;

import PageObject.newsfeed.Common.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class GeneralAccountPageObject extends HeaderMenu {
    WebDriver driver;
    public GeneralAccountPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
