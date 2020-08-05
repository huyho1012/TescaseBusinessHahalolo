package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.HeaderMenu;
import common.Function.PageGenerator;
import PageObject.newsfeed.PageFeed.PostFunction.EditorFunction;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.Common.HeaderPageUI;
import pageUI.Newsfeed.Common.sidebarRightUI;
import pageUI.Newsfeed.PageFeed.NewsFeedPageIU;

public class NewsfeedTabPageObject extends HeaderMenu {
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

    public EditorFunction clickToNormalPostFunction() {
        waitElementToClickAble(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        clickToElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        return PageGenerator.openNormalPostEditor(driver);
    }

    public PersonalTimelinePageObject clickToUserHomePage() {
        waitElementToVisible(driver, HeaderPageUI.PERSONAL_URL_LINK);
        clickToElement(driver,HeaderPageUI.PERSONAL_URL_LINK);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }

    public void clickCancelUpdateNewInfo() {
        waitElementToClickAble(driver, NewsFeedPageIU.CANCEL_UPDATE_NEW_INFO_BUTTON);
        clickToElement(driver,NewsFeedPageIU.CANCEL_UPDATE_NEW_INFO_BUTTON);
    }

}
