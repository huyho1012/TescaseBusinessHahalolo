package PageObject.newsfeed.Common;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.Common.HeaderPageUI;

public class AbstractMenuPage extends AbstractPage {
    public AbstractMenuPage clickToElementOnMenu(WebDriver driver, String menuItem) {
        waitElementToClickAble(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
        clickToElement(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
        if (menuItem.equals("Bảng tin")) {
            return PageGenerator.getNewsFeed(driver);
        } else if (menuItem.equals("Trải nghiệm")) {
            return PageGenerator.getExperienceFeed(driver);
        } else if (menuItem.equals("Tour")) {
            return PageGenerator.getTourFeed(driver);
        } else if (menuItem.equals("Khách sạn")) {
            return PageGenerator.getHotelFeed(driver);
        } else if (menuItem.equals("Vé máy bay")) {
            return PageGenerator.getFlightFeed(driver);
        } else {
            return PageGenerator.getShoppingFeed(driver);
        }
    }
    public AbstractMenuPage clickToSettingItem(WebDriver driver, String itemMenu) {
        waitElementToClickAble(driver, HeaderPageUI.SETTING_FUNCTION);
        clickToElement(driver, HeaderPageUI.SETTING_FUNCTION);
        setTimeDelay(1);
        waitElementToClickAble(driver, HeaderPageUI.SETTING_ITEM_FUNCTION, itemMenu);
        clickToElement(driver, HeaderPageUI.SETTING_ITEM_FUNCTION, itemMenu);
        if(itemMenu.equals("ic-handnotes-c")) {
            return PageGenerator.tourHandNotePage(driver);
        } else if(itemMenu.equals("ic-business-c")){
            return PageGenerator.getBusinessDashboardPage(driver);
        }else if(itemMenu.equals("ic-cog-c")){
            return PageGenerator.getAccountSettingPage(driver);
        }else {
            return PageGenerator.getLoginPage(driver);
        }
    }
    public void clickItemAgain(WebDriver driver){
        waitElementToClickAble(driver, HeaderPageUI.SETTING_FUNCTION);
        clickToElement(driver, HeaderPageUI.SETTING_FUNCTION);
    }
}
