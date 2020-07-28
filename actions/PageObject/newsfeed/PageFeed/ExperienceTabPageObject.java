package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.Common.HeaderPageUI;
import pageUI.newsfeed.PageFeed.ExperienceTabPageUI;

public class ExperienceTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public ExperienceTabPageObject (WebDriver webDriver){
       driver = webDriver;
   }

   public boolean checkExperienceTabSelected(){
       waitElementToVisible(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
       return checkIsDisplayedElement(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
   }
}
