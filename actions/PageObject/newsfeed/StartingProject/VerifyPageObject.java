package PageObject.newsfeed.StartingProject;

import common.Function.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.StartWeb.VerifyPageUI;

public class VerifyPageObject extends AbstractPage {
    WebDriver driver;
    public VerifyPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public Boolean checkEmailDisplayOnRegisterPage(String email) {
        waitElementToVisible(driver, VerifyPageUI.contentVerify);
        return getTextOfElement(driver, VerifyPageUI.contentVerify).contains(email);
    }

    public Boolean checkTitlePageVerifyEmail() {
        waitElementToVisible(driver, VerifyPageUI.titlePage);
        return getTextOfElement(driver, VerifyPageUI.titlePage).contains("Xác minh tài khoản bằng email");
    }
    public Boolean checkPhoneDisplayOnRegisterPage(String phoneNumber) {
        waitElementToVisible(driver, VerifyPageUI.contentVerify);
        return getTextOfElement(driver, VerifyPageUI.contentVerify).contains(phoneNumber);
    }

    public Boolean checkTitlePageVerifyPhone() {
        waitElementToVisible(driver, VerifyPageUI.titlePage);
        return getTextOfElement(driver, VerifyPageUI.titlePage).contains("Xác minh tài khoản bằng điện thoại");
    }

    public void inputVerifyDataOnField(String verifyCode) {
        waitElementToVisible(driver,VerifyPageUI.VERIFY_CODE_TEXT_BOX);
        sendKeyToElement(driver,VerifyPageUI.VERIFY_CODE_TEXT_BOX,verifyCode);
    }

    public void clickVerifyButton() {
        waitElementToClickAble(driver,VerifyPageUI.VERIFY_BUTTON);
        clickToElement(driver, VerifyPageUI.VERIFY_BUTTON);
        setTimeDelay(1);
    }

    public String getVerifyCode() {
        waitElementToVisible(driver,VerifyPageUI.VERIFY_MESSAGE_CODE);
        return getTextOfElement(driver,VerifyPageUI.VERIFY_MESSAGE_CODE);
    }
}
