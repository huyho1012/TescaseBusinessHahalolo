package PageObject.business.Business;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;

public class BusinessDashboardPageObject extends AbstractMenuPage {
    WebDriver driver;
    public BusinessDashboardPageObject(WebDriver webDriver){
        driver = webDriver;
    }
}
