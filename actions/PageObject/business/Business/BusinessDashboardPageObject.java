package PageObject.business.Business;

import PageObject.newsfeed.Common.HeaderMenu;
import common.Function.PageGenerator;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;

public class BusinessDashboardPageObject extends HeaderMenu {
    WebDriver driver;
    public BusinessDashboardPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public BusinessDashboardPageObject getBusinessPage(WebDriver driver){
        openURL(driver, Global_Constant.URL_BUSINESS_PAGE);
        return PageGenerator.getBusinessDashboardPage(driver);
    }
}
