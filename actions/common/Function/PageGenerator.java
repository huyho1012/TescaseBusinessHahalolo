package common.Function;

import PageObject.Backend.BackendLoginPageObject;
import PageObject.Backend.backendDashboardPageObject;
import PageObject.business.Business.BusinessDashboardPageObject;
import PageObject.newsfeed.AccountSetting.GeneralAccountPageObject;
import PageObject.newsfeed.PageFeed.PostFunction.EditorFunction;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import PageObject.newsfeed.Starting.NewsFeed_Login;
import PageObject.newsfeed.PageFeed.*;
import PageObject.newsfeed.PersonalWall.Handnote.TourHandnotePageObject;
import PageObject.newsfeed.Starting.NewsFeed_VerifyAccount;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static NewsFeed_VerifyAccount getVerifyAccountPage (WebDriver driver){
        return new NewsFeed_VerifyAccount(driver);
    }
    public static NF_ExperiencePage getExperienceFeed(WebDriver driver){
        return new NF_ExperiencePage(driver);
    }
    public static NewsFeed_Login getLoginPage(WebDriver driver){
        return new NewsFeed_Login(driver);
    }
    public static NF_FlighPage getFlightFeed(WebDriver driver){
        return new NF_FlighPage(driver);
    }
    public static HotelTabPageObject getHotelFeed(WebDriver driver){
        return new HotelTabPageObject(driver);
    }
    public static ShoppingTabPageObject getShoppingFeed(WebDriver driver){
        return new ShoppingTabPageObject(driver);
    }
    public static NewsfeedTabPageObject getNewsFeedPage(WebDriver driver){
        return new NewsfeedTabPageObject(driver);
    }
    public static TourTabPageObject getTourFeed(WebDriver driver){
        return new TourTabPageObject(driver);
    }
    public static TourHandnotePageObject tourHandNotePage(WebDriver driver){
        return new TourHandnotePageObject(driver);
    }
    public static GeneralAccountPageObject getAccountSettingPage(WebDriver driver){
        return new GeneralAccountPageObject(driver);
    }
    public static BusinessDashboardPageObject getBusinessDashboardPage(WebDriver driver){
        return new BusinessDashboardPageObject(driver);
    }
    public static PersonalTimelinePageObject getPersonalTimeLinePage(WebDriver driver){
        return new PersonalTimelinePageObject(driver);
    }
    // Khởi tạo model Editor
    public static EditorFunction openNormalPostEditor(WebDriver driver){
        return new EditorFunction(driver);
    }
    public static EditorFunction openExperiencePostEditor(WebDriver driver){
        return new EditorFunction(driver);
    }

    public static BackendLoginPageObject getLoginBackendPage(WebDriver driver){
        return new BackendLoginPageObject(driver);
    }
    public static backendDashboardPageObject getBackendDashboardPage(WebDriver driver){
        return new backendDashboardPageObject(driver);
    }
}

