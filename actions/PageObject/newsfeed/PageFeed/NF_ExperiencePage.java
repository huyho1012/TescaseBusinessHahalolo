package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.HeaderMenu;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.PageFeed.ExperienceTabPageUI;

public class NF_ExperiencePage extends HeaderMenu {
    WebDriver driver;
    public NF_ExperiencePage(WebDriver webDriver){
       driver = webDriver;
   }

   public boolean checkExperienceTabSelected(){
       waitElementToVisible(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
       return checkIsDisplayedElement(driver, ExperienceTabPageUI.SEARCH_FORM_EXPERIENCE);
   }
}
