package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.Common.HeaderPageUI;

public class ShoppingTabPageObject extends HeaderMenu {
    WebDriver driver;
    public ShoppingTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public String getTitle(String tabMenu) {
        waitElementToVisible(driver, HeaderPageUI.NEWS_FEED_MENU,tabMenu);
        return driver.getTitle();
    }
}
