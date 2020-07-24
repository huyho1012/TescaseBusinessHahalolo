package PageObject.newsfeed;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.LoginPageUI;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;
    public LoginPageObject(WebDriver webDriver){
        driver = webDriver;
    }
    public void enterUsernameToLogin(String userName) {
        waitElementToVisible(driver, LoginPageUI.USER_NAME_LOGIN_TEXT_BOX);
        sendKeyToElement(driver,LoginPageUI.USER_NAME_LOGIN_TEXT_BOX,userName);
    }
    public void enterPasswordToLogin(String passWord) {
        waitElementToVisible(driver, LoginPageUI.PASSWORD_LOGIN_TEXT_BOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_LOGIN_TEXT_BOX,passWord);
    }

    public void clickToLoginButton() {
        waitElementToClickAble(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
    }
    public String getValidationErrorMessageOnUsernameLogin(){
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_USERNAME);
        return getTextElement(driver, LoginPageUI.VALIDATE_ERROR_MESSAGE_USERNAME);
    }
    public String getValidationErrorMessageOnPasswordLogin(){
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_PASSWORD);
        return getTextElement(driver, LoginPageUI.VALIDATE_ERROR_MESSAGE_PASSWORD);
    }

    public void inputDataOnFirstNameSignUp(String firstName) {
        waitElementToVisible(driver,LoginPageUI.FIRST_NAME_TEXT_BOX);
        sendKeyToElement(driver,LoginPageUI.FIRST_NAME_TEXT_BOX,firstName);
    }
    public void inputDataOnLastNameSignUp(String lastName) {
        waitElementToVisible(driver,LoginPageUI.LAST_NAME_TEXT_BOX);
        sendKeyToElement(driver,LoginPageUI.LAST_NAME_TEXT_BOX,lastName);
    }

    public void inputDataOnPhoneEmailSignUp(String phoneEmail) {
        waitElementToVisible(driver,LoginPageUI.PHONE_EMAIL_TEXT_BOX);
        sendKeyToElement(driver,LoginPageUI.PHONE_EMAIL_TEXT_BOX,phoneEmail);
    }

    public void inputDataOnPasswordSignUp(String passWord) {
        waitElementToVisible(driver,LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXT_BOX,passWord);
    }

    public void inputDataOnConfirmPasswordSignUp(String confirmPass) {
        waitElementToVisible(driver,LoginPageUI.CONFIRM_PASSWORD_TEXT_BOX);
        sendKeyToElement(driver,LoginPageUI.CONFIRM_PASSWORD_TEXT_BOX,confirmPass);
    }

    public void clickSignUpButton() {
        waitElementToClickAble(driver,LoginPageUI.SIGN_UP_BUTTON);
        clickToElement(driver,LoginPageUI.SIGN_UP_BUTTON);
    }

    public String getValidateFirstNameSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_FIRST_NAME);
        return getTextElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_FIRST_NAME);
    }
    public void checkLanguageButton(){
        waitElementToVisible(driver, LoginPageUI.VIETNAMESE_BUTTON);
        if(!isControlDisplay(driver, LoginPageUI.VIETNAMESE_BUTTON)){
            clickToElement(driver,LoginPageUI.VIETNAMESE_BUTTON);
        }
    }

    public String getValidateLastNameSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_LAST_NAME);
        return getTextElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_LAST_NAME);
    }

    public boolean changePhoneCode(String phoneCode) {
        waitElementToClickAble(driver,LoginPageUI.PHONE_CODE_AREA);
        if(isControlDisplay(driver,LoginPageUI.PHONE_CODE_AREA)){
            selectItemOnCustomDropdown(driver,LoginPageUI.PHONE_CODE_AREA,"//span[@class ='phone-code']",phoneCode);
            return true;
        }return false;
    }

    public String getValidatePhoneEmailSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PHONE_EMAIL);
        return getTextElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PHONE_EMAIL);
    }

    public String getValidatePasswordSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PASS_WORD);
        return getTextElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PASS_WORD);
    }
    public String getValidateConfirmPassSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_CONFIRM_PASS);
        return getTextElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_CONFIRM_PASS);
    }
}
