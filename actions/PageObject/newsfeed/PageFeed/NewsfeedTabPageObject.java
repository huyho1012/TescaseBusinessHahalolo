package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.Common.sidebarRightUI;
import pageUI.newsfeed.NewsfeedPageIU;
import pageUI.newsfeed.PageFeed.ExperienceTabPageUI;

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
        waitElementToVisible(driver, NewsfeedPageIU.NORMAL_POST_FUNCTION);
        return checkIsDisplayedElement(driver, NewsfeedPageIU.NORMAL_POST_FUNCTION);
    }
}
