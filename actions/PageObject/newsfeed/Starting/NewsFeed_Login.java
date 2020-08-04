package PageObject.newsfeed.Starting;

import PageObject.Backend.BackendLoginPageObject;
import PageObject.Censor.CensorLogin;
import PageObject.newsfeed.Common.HeaderMenu;
import common.Function.PageGenerator;
import PageObject.newsfeed.PageFeed.NewsfeedTabPageObject;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import pageUI.Newsfeed.StartWeb.LoginPageUI;

import java.util.ArrayList;

public class NewsFeed_Login extends HeaderMenu {
    WebDriver driver;
    public NewsFeed_Login(WebDriver webDriver){
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

    public NewsfeedTabPageObject clickToLoginButton() {
        waitElementToClickAble(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return new NewsfeedTabPageObject(driver);
    }
    public String getValidateErrUsernameLogin(){
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_USERNAME);
        return getTextOfElement(driver, LoginPageUI.VALIDATE_ERROR_MESSAGE_USERNAME);
    }
    public String getValidateErrPassLogin(){
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_PASSWORD);
        return getTextOfElement(driver, LoginPageUI.VALIDATE_ERROR_MESSAGE_PASSWORD);
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

    public NewsFeed_VerifyAccount clickSignUpButton() {
        waitElementToClickAble(driver,LoginPageUI.SIGN_UP_BUTTON);
        clickToElement(driver,LoginPageUI.SIGN_UP_BUTTON);
        return PageGenerator.getVerifyAccountPage(driver);
    }

    public String getValidateFirstNameSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_FIRST_NAME);
        return getTextOfElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_FIRST_NAME);
    }
    public void checkLanguageButton(){
        waitElementToVisible(driver, LoginPageUI.VIETNAMESE_BUTTON);
        if(!checkIsDisplayedElement(driver, LoginPageUI.VIETNAMESE_BUTTON)){
            clickToElement(driver,LoginPageUI.VIETNAMESE_BUTTON);
        }
    }

    public String getValidateLastNameSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_LAST_NAME);
        return getTextOfElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_LAST_NAME);
    }

    public boolean changePhoneCode(String phoneCode) {
        waitElementToClickAble(driver,LoginPageUI.PHONE_CODE_AREA);
        if(checkIsDisplayedElement(driver,LoginPageUI.PHONE_CODE_AREA)){
            selectItemInCustomDropdown(driver,LoginPageUI.PHONE_CODE_AREA,"//span[@class ='phone-code']",phoneCode);
            return true;
        }return false;
    }

    public String getValidatePhoneEmailSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PHONE_EMAIL);
        return getTextOfElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PHONE_EMAIL);
    }

    public String getValidatePasswordSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PASS_WORD);
        return getTextOfElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_PASS_WORD);
    }
    public String getValidateConfirmPassSignUp() {
        waitElementToVisible(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_CONFIRM_PASS);
        return getTextOfElement(driver,LoginPageUI.VALIDATE_ERROR_MESSAGE_FROM_CONFIRM_PASS);
    }

    public boolean checkLogoutSuccess() {
        waitElementToVisible(driver,LoginPageUI.TITLE_REGISTER_FORM);
        return checkIsDisplayedElement(driver,LoginPageUI.TITLE_REGISTER_FORM);
    }

    public BackendLoginPageObject goToBackendLoginPage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, Global_Constant.URL_BACKEND_LOGIN);
        return PageGenerator.getLoginBackendPage(driver);
    }

    public CensorLogin gotoCensorLoginPage(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver,Global_Constant.URL_CENSOR_LINK);
        return  PageGenerator.getCensorLoginPage(driver);
    }
}
