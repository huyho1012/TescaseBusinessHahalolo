package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import PageObject.newsfeed.Common.PageGenerator;
import PageObject.newsfeed.PageFeed.PostFunction.PostModelObject;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import org.openqa.selenium.WebDriver;
import pageUI.Common.MediaManagerUI;
import pageUI.newsfeed.Common.HeaderPageUI;
import pageUI.newsfeed.Common.sidebarRightUI;
import pageUI.newsfeed.PageFeed.NewsFeedPageIU;
import pageUI.newsfeed.PageFeed.PostModelUI;

public class NewsfeedTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public NewsfeedTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    // Hàm thay đổi ngôn ngữ hiển thị
    public void changeLanguageDisplay() {
        waitForPageLoading(driver);
        if(!checkIsDisplayedElement(driver, sidebarRightUI.VI_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        } else if(checkIsDisplayedElement(driver,sidebarRightUI.ENG_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        }
    }

    // Hàm kiểm tra đang ở tab Newsfeed
    public boolean checkNewsFeedTabSelected(){
        waitElementToVisible(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        return checkIsDisplayedElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
    }

    // Hàm kiểm tra đã login thành công hay chưa
    public boolean checkLoginSuccess() {
        waitElementToVisible(driver, HeaderPageUI.CART_FUNCTION);
        return checkIsDisplayedElement(driver, HeaderPageUI.CART_FUNCTION);
    }

    public PostModelObject clickToNormalPostFunction() {
        waitElementToClickAble(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        clickToElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        return PageGenerator.openNormalPostEditor(driver);
    }

    public PersonalTimelinePageObject clickToUserHomePage() {
        waitElementToVisible(driver, HeaderPageUI.PERSONAL_URL_LINK);
        clickToElement(driver,HeaderPageUI.PERSONAL_URL_LINK);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }
}
