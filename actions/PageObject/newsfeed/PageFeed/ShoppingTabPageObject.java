package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.Common.HeaderPageUI;

public class ShoppingTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public ShoppingTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public String getTitle(String tabMenu) {
        waitElementToVisible(driver, HeaderPageUI.NEWS_FEED_MENU,tabMenu);
        return driver.getTitle();
    }
}
