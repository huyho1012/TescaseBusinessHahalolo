package hahalolo.newsfeed;

import PageObject.business.Business.BusinessDashboardPageObject;
import PageObject.newsfeed.AccountSetting.GeneralAccountPageObject;
import PageObject.newsfeed.Common.AbstractMenuPage;
import PageObject.newsfeed.Common.PageGenerator;
import PageObject.newsfeed.LoginPageObject;
import PageObject.newsfeed.PageFeed.*;
import PageObject.newsfeed.PersonalWall.Handnote.TourHandnotePageObject;
import common.DriverBrowser.BrowserDriver;
import common.DriverBrowser.DriverManager;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCaseNewsfeedPage extends AbstractMenuPage {
    WebDriver driver;
    LoginPageObject loginPage;
    ExperienceTabPageObject experiencePage;
    HotelTabPageObject hotelPage;
    TourTabPageObject tourPage;
    DriverManager driverManager;
    ShoppingTabPageObject shopPage;
    NewsfeedTabPageObject newsfeedPage;
    FlightTabPageObject flightPage;

    BusinessDashboardPageObject businessPage;
    GeneralAccountPageObject accountSettingPage;
    TourHandnotePageObject handNotePage;


    @Parameters("browser")
    @BeforeClass
    public void getBrowser(String browserName){
    driverManager = BrowserDriver.getBrowser(browserName);
    driver= driverManager.getDriver(Global_Constant.URL_NEWS_FEED_LOGIN);
    loginPage = PageGenerator.getLoginPage(driver);
    loginPage.enterUsernameToLogin(Global_Constant.USER_NAME);
    loginPage.enterPasswordToLogin(Global_Constant.PASSWORD);
    newsfeedPage = loginPage.clickToLoginButton();
    newsfeedPage.changeLanguageDisplay();
    }
//    @Test
//    public void switchToTabFeedOnMenu() {
//        experiencePage = (ExperienceTabPageObject) newsfeedPage.clickToElementOnMenu(driver, "Trải nghiệm");
//        hotelPage = (HotelTabPageObject) experiencePage.clickToElementOnMenu(driver, "Khách sạn");
//        tourPage = (TourTabPageObject) hotelPage.clickToElementOnMenu(driver, "Tour");
//        shopPage = (ShoppingTabPageObject) tourPage.clickToElementOnMenu(driver, "Mua sắm");
//        flightPage = (FlightTabPageObject) shopPage.clickToElementOnMenu(driver, "Vé máy bay");
//    }
    @Test
    public void switchToSettingFunctionOnHeader() {
        handNotePage = (TourHandnotePageObject) newsfeedPage.clickToSettingItem(driver, "ic-handnotes-c");
        accountSettingPage = (GeneralAccountPageObject) handNotePage.clickToSettingItem(driver,"ic-cog-c");
        businessPage = (BusinessDashboardPageObject) accountSettingPage.clickToSettingItem(driver,"ic-business-c");
        loginPage = (LoginPageObject) businessPage.clickToSettingItem(driver,"ic-logout-c");

    }
//    @AfterTest
//    public void closePage(){
//        driver.close();
//    }
}
