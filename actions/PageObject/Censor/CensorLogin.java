package PageObject.Censor;

import common.Function.AbstractPage;
import common.Function.AbstractTest;
import common.Function.PageGenerator;
import common.Global_Constant;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import pageUI.Censor.CensorLoginUI;
import pageUI.Newsfeed.StartWeb.LoginPageUI;

public class CensorLogin extends AbstractPage {
    WebDriver driver;
    public CensorLogin(WebDriver webDriver){
        driver = webDriver;
    }

    public void enterUsername(String userName) {
        waitElementToVisible(driver, CensorLoginUI.USER_NAME);
        sendKeyToElement(driver,CensorLoginUI.USER_NAME, Global_Constant.BACKEND_USER_NAME);
    }
    public void enterPassword(String passWord) {
        waitElementToVisible(driver, CensorLoginUI.PASSWORD);
        sendKeyToElement(driver,CensorLoginUI.PASSWORD, Global_Constant.BACKEND_PASSWORD);
    }

    public CensorHomePage clickLoginButton() {
        waitElementToClickAble(driver,CensorLoginUI.LOGIN_BUTTON);
        clickToElement(driver,CensorLoginUI.LOGIN_BUTTON);
        return PageGenerator.getCensorHomePage(driver);
    }

    public boolean checkLogoutSuccess() {
        waitForPageLoading(driver);
        waitElementToVisible(driver,CensorLoginUI.LOGIN_BUTTON);
        return checkAreElementsIsDisplay(driver,CensorLoginUI.LOGIN_BUTTON);
    }
}
