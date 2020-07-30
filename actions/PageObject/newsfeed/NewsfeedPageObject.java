package PageObject.newsfeed;

import common.Function.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.PageFeed.NewsFeedPageIU;

public class NewsfeedPageObject extends AbstractPage {
    WebDriver driver;
    public NewsfeedPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void clickCreateNormalPost() {
        waitElementToClickAble(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        clickToElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
    }
}
