package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;

public class TourTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public TourTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
