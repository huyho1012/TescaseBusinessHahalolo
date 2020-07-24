package PageObject.newsfeed;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.VerifyPageUI;

public class VerifyPageObject extends AbstractPage {
    WebDriver driver;
    public VerifyPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public Boolean checkEmailDisplayOnRegisterPage(String email) {
        waitElementToVisible(driver, VerifyPageUI.contentVerify);
        if(getTextElement(driver,VerifyPageUI.contentVerify).contains(email)){
            return true;
        }
        else return false;
    }

    public Boolean checkTitlePageVerifyEmail() {
        waitElementToVisible(driver, VerifyPageUI.titlePage);
        if(getTextElement(driver,VerifyPageUI.titlePage).contains("Xác minh tài khoản bằng email")){
            return true;
        }
        else return false;
    }
    public Boolean checkPhoneDisplayOnRegisterPage(String phoneNumber) {
        waitElementToVisible(driver, VerifyPageUI.contentVerify);
        if(getTextElement(driver,VerifyPageUI.contentVerify).contains(phoneNumber)){
            return true;
        }
        else return false;
    }

    public Boolean checkTitlePageVerifyPhone() {
        waitElementToVisible(driver, VerifyPageUI.titlePage);
        if(getTextElement(driver,VerifyPageUI.titlePage).contains("Xác minh tài khoản bằng điện thoại")){
            return true;
        }
        else return false;
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
        return getTextElement(driver,VerifyPageUI.VERIFY_MESSAGE_CODE);
    }
}
