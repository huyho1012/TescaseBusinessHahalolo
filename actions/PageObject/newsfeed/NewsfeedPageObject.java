package PageObject.newsfeed;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.NewsfeedPageIU;

public class NewsfeedPageObject extends AbstractPage {
    WebDriver driver;
    public NewsfeedPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickCreateNormalPost() {
        waitForElementClickable(driver, NewsfeedPageIU.NORMAL_POST_FUNCTION);
        clickToElement(driver,NewsfeedPageIU.NORMAL_POST_FUNCTION);
    }
}
