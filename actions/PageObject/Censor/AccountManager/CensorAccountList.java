package PageObject.Censor.AccountManager;
import PageObject.Censor.CensorLogin;
import common.Function.AbstractPage;
import common.Function.PageGenerator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUI.Censor.Account.CensorAccountListUI;
import pageUI.Censor.CensorHomeUI;

public class CensorAccountList extends AbstractPage {
    WebDriver driver;
    public CensorAccountList(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkAccountManagerPageIsDisplay() {
        waitElementToVisible(driver, CensorAccountListUI.TITLE_ACCOUNT_MODERATOR);
        return checkIsDisplayedElement(driver, CensorAccountListUI.TITLE_ACCOUNT_MODERATOR);
    }

    public void searchAccount(WebDriver driver, String accountName) {
        waitElementToVisible(driver, CensorAccountListUI.ACCOUNT_SEARCH_FIELD);
        sendKeyToElement(driver, CensorAccountListUI.ACCOUNT_SEARCH_FIELD,accountName);
        sendKeyboardToElement(driver,CensorAccountListUI.ACCOUNT_SEARCH_FIELD, Keys.ENTER);
    }

    public void clickToBlockAccount(WebDriver driver, String accountName,String statusAccount, String password) {
        waitElementToVisible(driver,CensorAccountListUI.BLOCKED_STATUS,accountName,statusAccount);
        clickToElement(driver,CensorAccountListUI.BLOCKED_STATUS,accountName,statusAccount);
        waitElementToVisible(driver,CensorAccountListUI.TITLE_CONFIRM_PASS_POPUP);
        sendKeyToElement(driver,CensorAccountListUI.CONFIRM_PASS_FIELD,password);
        clickToElement(driver,CensorAccountListUI.CONFIRM_BUTTON);
    }

    public boolean checkAccountIsBlockedSuccessfully(WebDriver driver,String emailUser, String statusAccount) {
        waitElementToVisible(driver, CensorAccountListUI.BLOCKED_STATUS, emailUser,statusAccount);
        return checkIsDisplayedElement(driver, CensorAccountListUI.BLOCKED_STATUS, emailUser,statusAccount);
    }

    public CensorLogin clickLogoutButton() {
        waitElementToClickAble(driver, CensorHomeUI.LOGOUT_ICON);
        clickToElement(driver, CensorHomeUI.LOGOUT_ICON);
        return PageGenerator.getCensorLoginPage(driver);
    }
}
