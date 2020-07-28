package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.PageFeed.FlightTabPageUI;
import pageUI.newsfeed.PageFeed.HotelTabPageUI;

public class FlightTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public FlightTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public String checkFlightTabSelected() {
        waitElementToVisible(driver, FlightTabPageUI.TITLE_PAGE);
        return getTextOfElement(driver, FlightTabPageUI.TITLE_PAGE);
    }
}
