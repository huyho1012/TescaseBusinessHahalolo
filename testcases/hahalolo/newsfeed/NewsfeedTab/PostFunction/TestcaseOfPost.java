package hahalolo.newsfeed.NewsfeedTab.PostFunction;

import PageObject.newsfeed.Common.PageGenerator;
import PageObject.newsfeed.PageFeed.NewsfeedTabPageObject;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import PageObject.newsfeed.StartingProject.LoginPageObject;
import PageObject.newsfeed.PageFeed.PostFunction.PostPageObject;
import common.DriverBrowser.BrowserDriver;
import common.DriverBrowser.DriverManager;
import common.Function.AbstractTest;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageUI.newsfeed.PageFeed.NewsFeedPageIU;

public class TestcaseOfPost extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    LoginPageObject loginPage;
    NewsfeedTabPageObject newsFeedPage;
    PersonalTimelinePageObject perTimelinePage;
    PostPageObject postPage;
    String contentPostNormal = "Hahalolo này còn ai đẹp hơn ta hahaha";
    String updateContent = "Xiến chi 19 tủi";
    String authorName = "Chúa Tể Khô";
    String file1 =  "image1.jpg";
    String file2 = "image2.jpg";
    @Parameters("browser")
    @BeforeClass
    public void preconditionTest(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 01 - Open Browser");
        driver = driverManager.getDriver(Global_Constant.URL_NEWS_FEED_LOGIN);
        loginPage= PageGenerator.getLoginPage(driver);

        log.info("Precondition - Step 02 - Enter Username");
        loginPage.enterUsernameToLogin(Global_Constant.USER_NAME);

        log.info("Precondition - Step 03 - Enter Password");
        loginPage.enterPasswordToLogin(Global_Constant.PASSWORD);

        log.info("Precondition - Step 04 - Click Signin button");
        loginPage.clickSignUpButton();
        newsFeedPage = PageGenerator.getNewsFeed(driver);

        log.info("Precondition - Step 05 - Verify Login successfully");
        verifyTrue(newsFeedPage.checkLoginSuccess());
    }
    @Test
    public void createNewNormalPost(){
        log.info("Create Post - Step 01 - Open Editor function");
        newsFeedPage.clickToNormalPostFunction();
        postPage = PageGenerator.openNormalPostEditor(driver);
        verifyTrue(postPage.checkNormalPostEditorDisplay());

        log.info("Create Post - Step 02 - Enter a post content");
        postPage.inputPostNormalContent(contentPostNormal);
        postPage.setTimeDelay(1);

        log.info("Create Post - Step 03 - Insert emoji");
        postPage.clickToPostFunction("ic-smile");
        postPage.insertEmoji("9");

        log.info("Create Post - Step 04 - Insert tagging");
        postPage.clickToPostFunction("ic-user-tag");
        postPage.chooseUserTagging("Al");

        log.info("Create Post - Step 05 - Insert location");
        postPage.clickToPostFunction("ic-location");
        postPage.chooseLocationAddress("Ho Chi Minh");

        log.info("Create Post - Step 06 - Insert Image");
        postPage.clickToPostFunction("ic-photos");
        postPage.uploadMultipleFileByAutoIT(driver,file1,file1,file1,file1);
        verifyTrue(newsFeedPage.checkAreElementsIsDisplay(driver, NewsFeedPageIU.LIST_IMAGE_UPLOADED));

        log.info("Create Post - Step 07 - Insert Feeling");
        postPage.clickToPostFunction("ic-grin");
        postPage.chooseFeeling("2");

        log.info("Create Post - Step 08 - Choose a post scope");
        postPage.clickChooseScopeDropdown("fa-user-friends");
        log.info("Create Post - Step 09 - Click to create post");
        postPage.clickToSharePostButton();
        newsFeedPage = PageGenerator.getNewsFeed(driver);
   }
   @Test
    public void editNormalPost(){
        newsFeedPage.setTimeDelay(2);
       log.info("Edit Normal Post - Step 01 - Check post create success on Personal Wall");
       perTimelinePage = newsFeedPage.clickToUserHomePage();
       postPage = PageGenerator.openNormalPostEditor(driver);
       log.info("Edit Normal Post - Step 02 - Click edit Personal Wall");
       postPage.openFunction(driver,contentPostNormal,authorName,"fa-edit");
       verifyTrue(postPage.checkEditPostNormalDisplay());
       log.info("Edit Normal Post - Step 03 - Update content ");
       newsFeedPage.setTimeDelay(4);
       postPage.inputPostNormalContent(updateContent);
       postPage.removeUserTagging();
       postPage.clickChooseScopeDropdown("fa-globe-asia");
       postPage.clickToSharePostButton();
       perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);

   }
//    @Test
//    public void createNewExperiencePost(){
//        log.info("Create Post - Step 01 - Open Experience post");
//        newsFeedPage.clickToExperienceEditor();
//        verifyTrue(newsFeedPage.checkToExperienceEditorDisplay());
//
//        log.info("Create Post - Step 02 - Upload cover Experience post");
//        newsFeedPage.clickUploadCoverButton();
//        newsFeedPage.uploadMultipleFileByAutoIT(driver,file2);
//        newsFeedPage.setTimeDelay(4);
//
//        log.info("Create Post - Step 03 - Enter a Title Experience");
//        newsFeedPage.inputExperienceTitle("Test Experience post");
//        newsFeedPage.setTimeDelay(1);
//
//        log.info("Create Post - Step 04 - Create Experience content ");
//        newsFeedPage.inputExperienceContent(randomParagraphs(5));
//        newsFeedPage.setTimeDelay(1);
//
//        log.info("Create Post - Step 05 - Insert emoji");
//        newsFeedPage.clickToPostFunction("ic-smile");
//        newsFeedPage.insertEmoji("9");
//
//        log.info("Create Post - Step 06 - Insert Image");
//        newsFeedPage.clickToPostFunction("ic-photos");
//        newsFeedPage.chooseImageToInsert("1");
//
//        log.info("Create Post - Step 07 - Insert tagging");
//        newsFeedPage.clickToPostFunction("ic-user-tag");
//        newsFeedPage.chooseUserTagging("Al");
//
//        log.info("Create Post - Step 08 - Insert location");
//        newsFeedPage.clickToPostFunction("ic-location");
//        newsFeedPage.chooseLocationAddress("Ho Chi Minh");
//
//        log.info("Create Post - Step 09 - Choose a post scope");
//        newsFeedPage.clickChooseScopeDropdown("fa-user-friends");
//
//        log.info("Create Post - Step 09 - Click to create post");
//        newsFeedPage.clickToSharePostButton();
//    }
//    public void Edit_Normal_Post_With_Not_Image(){
//        perTimelinePage = newsFeedPage.clickToUserHomePage();
//        perTimelinePage.openFunction(driver,contentPostNormal,authorName,"fa-edit");
//        perTimelinePage.clickPostMenu();
//        perTimelinePage.chooseEditPostNormal();
//        perTimelinePage.editPostContent();
//        perTimelinePage.editTagging();
//        perTimelinePage.editLocation();
//        perTimelinePage.insertNewEmoji();
//        perTimelinePage.changePostScope();
//        perTimelinePage.saveChangePost();
//    }
}
