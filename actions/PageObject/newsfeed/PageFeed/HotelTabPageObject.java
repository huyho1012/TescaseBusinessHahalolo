package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;

public class HotelTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public HotelTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
