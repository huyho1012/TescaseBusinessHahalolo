package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.Common.sidebarRightUI;

public class NewsfeedTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public NewsfeedTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public void changeLanguageDisplay() {
        waitForPageLoading(driver);
        if(!checkIsDisplayedElement(driver, sidebarRightUI.VI_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        } else if(checkIsDisplayedElement(driver,sidebarRightUI.ENG_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        }
    }
}
