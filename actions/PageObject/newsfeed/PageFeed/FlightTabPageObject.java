package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;

public class FlightTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public FlightTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
