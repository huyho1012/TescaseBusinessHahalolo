package PageObject.newsfeed.PersonalWall;

import PageObject.newsfeed.Common.AbstractMenuPage;
import common.Function.AbstractTest;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.PageFeed.NewsFeedPageIU;

public class PersonalTimelinePageObject extends AbstractMenuPage {
    WebDriver driver;
    public PersonalTimelinePageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPostIsDisplay() {
        return true;
    }

    public void goToNormalPost() {
    }

    public void openFunction(WebDriver driver, String postContent, String authorName, String functionPost){
        waitElementToVisible(driver, NewsFeedPageIU.MENU_FUNCTION_WITH_DIRECT_POST,postContent,authorName);
        clickToElement(driver,NewsFeedPageIU.MENU_FUNCTION_WITH_DIRECT_POST,postContent,authorName);
        setTimeDelay(2);
        waitElementToClickAble(driver,NewsFeedPageIU.ITEM_FUNCTION_WITH_DIRECT_POST,postContent,authorName,functionPost);
        clickToElement(driver,NewsFeedPageIU.ITEM_FUNCTION_WITH_DIRECT_POST,postContent,authorName,functionPost);
    }
}
