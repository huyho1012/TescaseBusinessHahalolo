package PageObject.newsfeed.Common;

import PageObject.Backend.BackendLoginPageObject;
import PageObject.Backend.backendDashboardPageObject;
import PageObject.business.Business.BusinessDashboardPageObject;
import PageObject.newsfeed.AccountSetting.GeneralAccountPageObject;
import PageObject.newsfeed.PageFeed.PostFunction.PostModelObject;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import PageObject.newsfeed.StartingProject.LoginPageObject;
import PageObject.newsfeed.PageFeed.*;
import PageObject.newsfeed.PersonalWall.Handnote.TourHandnotePageObject;
import PageObject.newsfeed.StartingProject.VerificationAccountPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static VerificationAccountPageObject getVerifyAccountPage (WebDriver driver){
        return new VerificationAccountPageObject(driver);
    }
    public static ExperienceTabPageObject getExperienceFeed(WebDriver driver){
        return new ExperienceTabPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static FlightTabPageObject getFlightFeed(WebDriver driver){
        return new FlightTabPageObject(driver);
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
    public static PostModelObject openNormalPostEditor(WebDriver driver){
        return new PostModelObject(driver);
    }

    public static BackendLoginPageObject getLoginBackendPage(WebDriver driver){
        return new BackendLoginPageObject(driver);
    }
    public static backendDashboardPageObject getBackendDashboardPage(WebDriver driver){
        return new backendDashboardPageObject(driver);
    }
}

