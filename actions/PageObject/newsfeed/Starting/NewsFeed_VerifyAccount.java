package PageObject.newsfeed.Starting;

import common.Function.PageGenerator;
import PageObject.newsfeed.PageFeed.NewsfeedTabPageObject;
import common.Function.AbstractPage;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.StartWeb.VerificationAccountPageUI;

import java.util.ArrayList;

public class NewsFeed_VerifyAccount extends AbstractPage {
    WebDriver driver;
    public NewsFeed_VerifyAccount(WebDriver webDriver){
        driver = webDriver;
    }

    public Boolean checkAccountDisplayOnRegisterPage(String account) {
        waitElementToVisible(driver, VerificationAccountPageUI.CONTENT_VERIFY);
        return getTextOfElement(driver, VerificationAccountPageUI.CONTENT_VERIFY).contains(account);
    }

    public Boolean checkTitlePageVerifyEmail() {
        waitElementToVisible(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"email");
        return getTextOfElement(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"email").contains("Xác minh tài khoản bằng email");
    }

    public Boolean checkTitlePageVerifyPhone() {
        waitElementToVisible(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"phone");
        return getTextOfElement(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"phone").contains("Xác minh tài khoản bằng điện thoại");
    }

    public void inputVerifyDataOnField(String verifyCode) {
        waitElementToVisible(driver, VerificationAccountPageUI.VERIFY_CODE_TEXT_BOX);
        sendKeyToElement(driver, VerificationAccountPageUI.VERIFY_CODE_TEXT_BOX,verifyCode);
    }

    public NewsfeedTabPageObject clickVerifyButton() {
        waitElementToClickAble(driver, VerificationAccountPageUI.VERIFY_BUTTON);
        clickToElement(driver, VerificationAccountPageUI.VERIFY_BUTTON);
        setTimeDelay(1);
        return PageGenerator.getNewsFeedPage(driver);
    }

    public String getVerifyCode() {
        waitElementToVisible(driver, VerificationAccountPageUI.VERIFY_MESSAGE_CODE);
        return getTextOfElement(driver, VerificationAccountPageUI.VERIFY_MESSAGE_CODE);
    }
    public String getVerificationAccountCode(String emailAddress) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, Global_Constant.URL_MAILINATOR);
        waitElementToVisible(driver, Global_Constant.MAIl_SEARCH_BOX);
        sendKeyToElement(driver, Global_Constant.MAIl_SEARCH_BOX, emailAddress);
        clickToElement(driver, Global_Constant.SEARCH_BOX);
        clickToElement(driver, Global_Constant.EMAIL_VERIFY_ACCOUNT);
        switchToFrameOrIFrame(driver, Global_Constant.FRAME_BODY_MESSAGE);
        waitElementToVisible(driver,Global_Constant.VERIFY_CODE_VALUE);
        String code = getTextOfElement(driver, Global_Constant.VERIFY_CODE_VALUE);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        return code;
    }
}
