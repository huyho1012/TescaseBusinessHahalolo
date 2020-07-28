package hahalolo.newsfeed.StartIngApp;

import PageObject.newsfeed.StartingProject.LoginPageObject;
import PageObject.newsfeed.NewsfeedPageObject;
import common.Function.AbstractTest;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTestcase extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPage;
    NewsfeedPageObject newsfeedPage;
    @BeforeTest
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Global_Constant.URL_NEWS_FEED_LOGIN);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Global_Constant.LONG_TIME_OUT, TimeUnit.SECONDS);
        loginPage = new LoginPageObject(driver);
    }
    @Test
    public void TC01_Login_With_Blank_Username(){
        loginPage.enterUsernameToLogin("");
        loginPage.enterPasswordToLogin("123456");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidationErrorMessageOnUsernameLogin(),"Tài khoản là bắt buộc.");
    }
    @Test
    public void TC02_Login_With_Blank_Password(){
        loginPage.enterUsernameToLogin("0936709449");
        loginPage.enterPasswordToLogin("");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidationErrorMessageOnPasswordLogin(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void TC03_Login_With_Invalid_Username(){
        loginPage.enterUsernameToLogin("huyho1210@gmail.");
        loginPage.enterPasswordToLogin("123456");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidationErrorMessageOnUsernameLogin(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC04_Login_With_Password_Less_than_6_Chars(){
        loginPage.enterUsernameToLogin("balo_04@mailinator.com");
        loginPage.enterPasswordToLogin("12345");
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidationErrorMessageOnPasswordLogin(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }
    @Test
    public void TC05_Login_With_Password_More_than_129_Chars(){
        loginPage.enterUsernameToLogin("balo_04@mailinator.com");
        loginPage.enterPasswordToLogin(randomPassword(129));
        loginPage.clickToLoginButton();
        Assert.assertEquals(loginPage.getValidationErrorMessageOnPasswordLogin(),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
    }
    @Test
    public void TC06_Login_With_Valid_Username(){
        loginPage.enterUsernameToLogin("balo_04@mailinator.com");
        loginPage.enterPasswordToLogin("123456");
        loginPage.clickToLoginButton();
    }
}
