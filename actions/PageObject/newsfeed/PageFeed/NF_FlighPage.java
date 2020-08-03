package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.PageFeed.FlightTabPageUI;

public class NF_FlighPage extends HeaderMenu {
    WebDriver driver;
    public NF_FlighPage(WebDriver webDriver){
        driver = webDriver;
    }

    public String checkFlightTabSelected() {
        waitElementToVisible(driver, FlightTabPageUI.TITLE_PAGE);
        return getTextOfElement(driver, FlightTabPageUI.TITLE_PAGE);
    }
}
