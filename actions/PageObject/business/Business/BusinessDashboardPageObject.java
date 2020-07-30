package PageObject.business.Business;

import PageObject.newsfeed.Common.AbstractMenuPage;
import PageObject.newsfeed.Common.PageGenerator;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;

public class BusinessDashboardPageObject extends AbstractMenuPage {
    WebDriver driver;
    public BusinessDashboardPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public BusinessDashboardPageObject getBusinessPage(WebDriver driver){
        openURL(driver, Global_Constant.URL_BUSINESS_PAGE);
        return PageGenerator.getBusinessDashboardPage(driver);
    }
}
