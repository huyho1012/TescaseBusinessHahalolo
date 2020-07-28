package hahalolo.newsfeed.NewsfeedTab.PostFunction;

import PageObject.newsfeed.StartingProject.LoginPageObject;
import PageObject.newsfeed.NewsfeedPageObject;
import PageObject.newsfeed.PageFeed.PostFunction.PostPageObject;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestcaseOfPost {
    WebDriver driver;
    LoginPageObject loginPage;
    NewsfeedPageObject newsfeedPage;
    PostPageObject postPage;

    String file1 =  "image1.jpg";
    String file2 = "image2.jpg";
    @BeforeClass
    public void preconditionTest(){
        System.setProperty("webdriver.chrome.driver","browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Global_Constant.URL_NEWS_FEED_LOGIN);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Global_Constant.LONG_TIME_OUT, TimeUnit.SECONDS);
        loginPage = new LoginPageObject(driver);
        loginPage.enterUsernameToLogin("balo_04@mailinator.com");
        loginPage.enterPasswordToLogin("123456");
        loginPage.clickToLoginButton();
        newsfeedPage = new NewsfeedPageObject(driver);
    }
    @Test
    public void createNewNormalPost(){
        newsfeedPage.clickCreateNormalPost();
        postPage = new PostPageObject(driver);
        postPage.enterPostContent("Huy đẹp trai");
    postPage.uploadImageOnNormalPost(driver,file1,file2);
       postPage.uploadMultipleFileByAutoIT(driver,file1,file2);
        postPage.clickButtonSharePost();
    }

}