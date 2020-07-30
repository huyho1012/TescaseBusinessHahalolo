package PageObject.newsfeed.Common;

import PageObject.business.Business.BusinessDashboardPageObject;
import PageObject.newsfeed.AccountSetting.GeneralAccountPageObject;
import PageObject.newsfeed.PageFeed.PostFunction.PostPageObject;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import PageObject.newsfeed.StartingProject.LoginPageObject;
import PageObject.newsfeed.PageFeed.*;
import PageObject.newsfeed.PersonalWall.Handnote.TourHandnotePageObject;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.PersonalWall.PersonalTimelinePageUI;

public class PageGenerator {
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
    public static NewsfeedTabPageObject getNewsFeed(WebDriver driver){
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
    public static PostPageObject openNormalPostEditor(WebDriver driver){
        return new PostPageObject(driver);
    }
}

