package hahalolo.newsfeed.StartIngApp.SignUpTestCase;

import PageObject.Censor.AccountManager.CensorAccountList;
import PageObject.Censor.CensorHomePage;
import PageObject.Censor.CensorLogin;
import PageObject.newsfeed.PageFeed.NewsfeedTabPageObject;
import PageObject.newsfeed.Starting.NewsFeed_Login;
import PageObject.newsfeed.Starting.NewsFeed_VerifyAccount;
import common.DriverBrowser.BrowserDriver;
import common.DriverBrowser.DriverManager;
import common.Function.AbstractTest;
import common.Function.PageGenerator;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUpITTestcase extends AbstractTest {

    WebDriver driver;
    NewsFeed_Login loginPage;
    DriverManager driverManager;
    NewsfeedTabPageObject newsFeedPage;
    CensorLogin censorLoginPage;
    CensorHomePage censorHomePage;
    CensorAccountList censorAccountListPage;
    NewsFeed_VerifyAccount verifyAccountPage;
    String passWord ="123456";
    String confirmPassword = "123456";
    String firstName = "Huy";
    String lastName = "Hò";
    String email = "tester.hahalolo" + randomEmail() + "@mailinator.com";
    @Parameters("browser")
    @BeforeClass
    public void preconditionMethod(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(Global_Constant.URL_NEWS_FEED_LOGIN);
        loginPage = PageGenerator.getLoginPage(driver);
    }
    @Test
    public void TC_01_SingUp_With_Valid_Email(){
        log.info("Register Account - Step 1");
        log.info("Register Account - Step 1.1 - Enter First name");
        loginPage.inputDataOnFirstNameSignUp(firstName);

        log.info("Register Account - Step 1.2 - Enter Last name");
        loginPage.inputDataOnLastNameSignUp(lastName);

        log.info("Register Account - Step 1.3 - Enter Email");
        loginPage.inputDataOnPhoneEmailSignUp(email);

        log.info("Register Account - Step 1.4 - Password");
        loginPage.inputDataOnPasswordSignUp(passWord);

        log.info("Register Account - Step 1.5 - Enter Confirm Password");
        loginPage.inputDataOnConfirmPasswordSignUp(confirmPassword);

        log.info("Register Account - Step 1.6 - Click Signup Button");
        verifyAccountPage = loginPage.clickSignUpButton();

        log.info("Register Account - Step 2.1 - Check Account verification");
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
        verifyTrue(verifyAccountPage.checkAccountDisplayOnRegisterPage(email));

        log.info("Register Account - Step 2.2 - Enter verification code");
        verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.getVerificationAccountCode(email));

        log.info("Register Account - Step 2.3 - Click verify button");
        verifyAccountPage.clickVerifyButton();

//        log.info("Register Account - Step 2.4 - Check message after verify");
//        verifyEquals(verifyAccountPage.getVerifyCode(), "");

        log.info("Register Account - Step 2.5 - Check verify account successfully");
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        newsFeedPage.updateBirthday(driver,"day","12","month","10","year","1992");
        newsFeedPage.setTimeDelay(10);
        newsFeedPage.updateGender();
        newsFeedPage.updateCountry();
        newsFeedPage.clickUpdateButton();
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}
