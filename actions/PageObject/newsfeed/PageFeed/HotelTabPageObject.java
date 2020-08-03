package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.PageFeed.HotelTabPageUI;

public class HotelTabPageObject extends HeaderMenu {
    WebDriver driver;
    public HotelTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkHotelTabSelected() {
        waitElementToVisible(driver, HotelTabPageUI.HOTEL_SEARCH_FORM);
        return checkIsDisplayedElement(driver,HotelTabPageUI.HOTEL_SEARCH_FORM);
    }
}
