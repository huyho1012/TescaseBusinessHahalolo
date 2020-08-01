package hahalolo.newsfeed.StartIngApp;

import PageObject.Backend.BackendLoginPageObject;
import PageObject.Backend.backendDashboardPageObject;
import PageObject.newsfeed.Common.PageGenerator;
import PageObject.newsfeed.PageFeed.NewsfeedTabPageObject;
import PageObject.newsfeed.StartingProject.LoginPageObject;
import PageObject.newsfeed.StartingProject.VerificationAccountPageObject;
import common.DriverBrowser.BrowserDriver;
import common.DriverBrowser.DriverManager;
import common.Function.AbstractTest;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestcase extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DriverManager driverManager;
    NewsfeedTabPageObject newsFeedPage;
    BackendLoginPageObject backendLoginPage;
    backendDashboardPageObject backendDashboardPage;
    VerificationAccountPageObject verifyAccountPage;
    String passWord ="123456";
    String confirmPassword = "123456";
    String firstName = "Huy";
    String lastName = "Hò";
    String email = "tester.hahalolo" + randomEmail() + "@mailinator.com";
    @Parameters("browser")
    @BeforeTest
    public void openBrowser(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(Global_Constant.URL_NEWS_FEED_LOGIN);
        loginPage = PageGenerator.getLoginPage(driver);
    }
//    @Test
//    public void Login_TC01_Login_With_Blank_Info(){
//        loginPage.enterUsernameToLogin("");
//        loginPage.enterPasswordToLogin("");
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrUsernameLogin(),"Tài khoản là bắt buộc.");
//        verifyEquals(loginPage.getValidateErrPassLogin(),"Mật khẩu là bắt buộc.");
//    }
//    @Test
//    public void Login_TC02_Login_With_Blank_Username(){
//        loginPage.enterUsernameToLogin("");
//        loginPage.enterPasswordToLogin("123456");
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrUsernameLogin(),"Tài khoản là bắt buộc.");
//    }
//    @Test
//    public void Login_TC03_Login_With_Blank_Password(){
//        loginPage.enterUsernameToLogin("0936709449");
//        loginPage.enterPasswordToLogin("");
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrPassLogin(),"Mật khẩu là bắt buộc.");
//    }
//    @Test
//    public void Login_TC03_Login_With_Invalid_Email(){
//        loginPage.enterUsernameToLogin("huyho1210@gmail.");
//        loginPage.enterPasswordToLogin("123456");
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrUsernameLogin(),"Tài khoản không hợp lệ.");
//    }
    @Test
    public void Login_TC03_Login_With_Blocked_Account_Email(){
        log.info("Precondition Step1 - Register Account");
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp(passWord);
        loginPage.inputDataOnConfirmPasswordSignUp(confirmPassword);
        verifyAccountPage = loginPage.clickSignUpButton();
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
        verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.getVerificationAccountCode(email));
        newsFeedPage = verifyAccountPage.clickVerifyButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());

        log.info("Step1 - Logout account");
        newsFeedPage.setTimeDelay(5);
        newsFeedPage.clickCancelUpdateNewInfo();
        newsFeedPage.clickToSettingItem(driver,"ic-logout-c");
        loginPage = PageGenerator.getLoginPage(driver);
        verifyTrue(loginPage.checkLogoutSuccess());

        log.info("Step2 - Login with Admin Hahalolo");
        backendLoginPage = loginPage.goToBackendLoginPage();
        backendLoginPage.enterDataToUsernameTextBox(Global_Constant.BACKEND_USER_NAME);
        backendLoginPage.enterDataToPasswordTextBox(Global_Constant.BACKEND_PASSWORD);
        backendLoginPage.setTimeDelay(10);
        backendDashboardPage = backendLoginPage.clickLoginButton();
        verifyTrue(backendDashboardPage.verifyLoginBackEndSuccess());
//
//        backenDashboard.clickAccountTabmenu();
//        backendAccountManager = backenDashboard.clickAllAccountManagerTab();
//        verifyTrue(backendAccountManager.checkAccountManagerPageIsDisplay());
//
//        backendAccountManager.enterEmailAccountUserToSearchForm();
//        backendAccountManager.clickFilterButton();
//
//        backendAccountManagement.chooseAccountBlock();
//        verifyTrue(backendAccountManagement.checkStatusBlockedAccount());
//
//        loginPage = backendAccountManagement.getLoginPage();
//
//        log.info("Precondition Step1 - Login Account");
//        loginPage.enterUsernameToLogin(email);
//        loginPage.enterPasswordToLogin(passWord);
//        newsFeedPage = loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrUsernameLogin(),"Tài khoản không hợp lệ.");
//        log.info("Precondition Step1 - Verify Account");
//        loginPage.enterUsernameToLogin("huyho1210@gmail.");
//        loginPage.enterPasswordToLogin("123456");
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrUsernameLogin(),"Tài khoản không hợp lệ.");
    }
//    @Test
//    public void Login_TC03_Login_With_Invalid_Phone(){
//        loginPage.enterUsernameToLogin("090364");
//        loginPage.enterPasswordToLogin("123456");
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrUsernameLogin(),"Tài khoản không hợp lệ.");
//    }
//    @Test
//    public void TC04_Login_With_Password_Less_than_6_Chars(){
//        loginPage.enterUsernameToLogin("balo_04@mailinator.com");
//        loginPage.enterPasswordToLogin("12345");
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrPassLogin(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
//    }
//    @Test
//    public void TC05_Login_With_Password_More_than_129_Chars(){
//        loginPage.enterUsernameToLogin("balo_04@mailinator.com");
//        loginPage.enterPasswordToLogin(randomPassword(129));
//        loginPage.clickToLoginButton();
//        verifyEquals(loginPage.getValidateErrPassLogin(),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
//    }
//    @Test
//    public void TC06_Login_With_Valid_Username(){
//        loginPage.enterUsernameToLogin("balo_04@mailinator.com");
//        loginPage.enterPasswordToLogin("123456");
//        newsFeedPage=loginPage.clickToLoginButton();
//        verifyTrue(newsFeedPage.checkLoginSuccess());
//    }
}



