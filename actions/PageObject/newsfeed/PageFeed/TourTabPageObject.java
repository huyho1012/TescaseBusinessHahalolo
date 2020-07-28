package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.PageFeed.TourTabPageUI;

public class TourTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public TourTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkTourTabSelected() {
        waitElementToVisible(driver, TourTabPageUI.TOUR_SEARCH_FORM);
        return checkIsDisplayedElement(driver, TourTabPageUI.TOUR_SEARCH_FORM);
    }
}
