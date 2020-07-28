package PageObject.newsfeed.Common;

import common.Function.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.Common.HeaderPageUI;

public class AbstractMenuPage extends AbstractPage {
    public void clickToElementOnMenu(WebDriver driver, String menuItem) {
        waitElementToClickAble(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
        clickToElement(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
        setTimeDelay(1);
    }
    public void clickToSettingItem(WebDriver driver, String itemMenu) {
        setTimeDelay(2);
        waitElementToClickAble(driver, HeaderPageUI.SETTING_FUNCTION);
        clickToElement(driver, HeaderPageUI.SETTING_FUNCTION);
        setTimeDelay(1);
        waitElementToClickAble(driver, HeaderPageUI.SETTING_ITEM_FUNCTION,itemMenu);
        clickToElement(driver, HeaderPageUI.SETTING_ITEM_FUNCTION,itemMenu);
        setTimeDelay(1);
    }
    public void clickFunctionOnHelping(WebDriver driver, String itemFunction){
        setTimeDelay(1);
        waitElementToClickAble(driver,HeaderPageUI.HELPER_FUNCTION);
        clickToElement(driver,HeaderPageUI.HELPER_FUNCTION);
        setTimeDelay(1);
        waitElementToClickAble(driver, HeaderPageUI.HELPER_ITEM_FUNCTION, itemFunction);
        clickToElement(driver,HeaderPageUI.HELPER_ITEM_FUNCTION,itemFunction);
        setTimeDelay(1);
    }
}
