package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.PageFeed.TourTabPageUI;

public class TourTabPageObject extends HeaderMenu {
    WebDriver driver;
    public TourTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourTabSelected() {
        waitElementToVisible(driver, TourTabPageUI.TOUR_SEARCH_FORM);
        return checkIsDisplayedElement(driver, TourTabPageUI.TOUR_SEARCH_FORM);
    }
}
