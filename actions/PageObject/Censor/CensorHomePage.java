package PageObject.Censor;

import common.Function.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.Backend.backendDashboardPageUI;
import pageUI.Censor.CensorHomeUI;

public class CensorHomePage extends AbstractPage {
    WebDriver driver;
    public CensorHomePage(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkLoginCensorSuccess(){
        waitElementToVisible(driver, CensorHomeUI.NOTI_ICON);
        return checkIsDisplayedElement(driver,CensorHomeUI.NOTI_ICON);
    }

    public void clickToItemOnMenu(WebDriver driver, String functionName) {
        waitElementToClickAble(driver, CensorHomeUI.MENU_FUNCTION,functionName);
        clickToElement(driver,CensorHomeUI.MENU_FUNCTION,functionName);
    }

    public void checkAndChangeLanguageToVI(WebDriver driver){
        waitForPageLoading(driver);
        if(checkIsDisplayedElement(driver,CensorHomeUI.ENG_LANGUAGE_ICON)){
            waitElementToVisible(driver,CensorHomeUI.ENG_LANGUAGE_ICON);
            clickToElement(driver,CensorHomeUI.ENG_LANGUAGE_ICON);
        }
    }
}
