package hahalolo.newsfeed.NewsfeedTab.PostFunction;

import PageObject.newsfeed.Common.PageGenerator;
import PageObject.newsfeed.PageFeed.NewsfeedTabPageObject;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import PageObject.newsfeed.StartingProject.LoginPageObject;
import PageObject.newsfeed.PageFeed.PostFunction.PostModelObject;
import common.DriverBrowser.BrowserDriver;
import common.DriverBrowser.DriverManager;
import common.Function.AbstractTest;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageUI.newsfeed.PageFeed.NewsFeedPageIU;
import pageUI.newsfeed.PageFeed.PostModelUI;

public class TestcaseOfPost extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    LoginPageObject loginPage;
    NewsfeedTabPageObject newsFeedPage;
    PersonalTimelinePageObject perTimelinePage;
    PostModelObject postPage;
    String contentPost = "Hahalolo này còn ai đẹp hơn ta hahaha";
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
    public void NormalPost_01_Check_Button_Share_Post_With_No_Input(){
        log.info("Check Button Share Post - Step 01 - Open Post Normal Editor");
        newsFeedPage.clickToNormalPostFunction();
        postPage = PageGenerator.openNormalPostEditor(driver);

        log.info("Check Share Post button - Step 02 - Check form Editor post display");
        verifyTrue(postPage.checkCreatePostModalIsDisplay());

        log.info("Check Share Post button - Step 03 - Check status");
        verifyFalse(postPage.checkButtonSharePostIsEnable());

        log.info("Check Button Share Post - Step 05 - Close Post Normal Editor");
        postPage.closeNormalPostEditor();


    }
    @Test
    public void NormalPost_02_Check_Button_Share_Post_When_Has_Input(){
        log.info("Check Button Share Post - Step 01 - Open Post Normal Editor");
        newsFeedPage.clickToNormalPostFunction();
        postPage = PageGenerator.openNormalPostEditor(driver);

        log.info("Check Button Share Post - Step 02 - Verify Normal Post Display");
        verifyTrue(postPage.checkCreatePostModalIsDisplay());

        log.info("Check Button Share Post - Step 03 - Input content");
        postPage.inputPostNormalContent(contentPost);

        log.info("Check Button Share Post - Step 04 - Check status Shared button");
        verifyTrue(postPage.checkButtonSharePostIsEnable());


    }
    @Test
    public void NormalPost_03_Check_Button_Share_Post_When_User_Remove_Content(){
        log.info("Check Button Share Post - Step 01 - Go to personalWall");
        newsFeedPage.setTimeDelay(1);
        newsFeedPage.clickToNormalPostFunction();
        postPage = PageGenerator.openNormalPostEditor(driver);

        log.info("Check Button Share Post - Step 02 - Verify Normal Post Display");
        verifyTrue(postPage.checkNormalPostEditorDisplay());

        log.info("Check Button Share Post - Step 03 - Input content");
        postPage.inputPostNormalContent(contentPostNormal);

        log.info("Check Button Share Post - Step 04 - Check button Share Post disable");
        verifyFalse(postPage.checkSharedButtonIsDisable());

        log.info("Check Button Share Post - Step 05 - Close Post Normal Editor");
        postPage.closeNormalPostEditor();
    }
    @Test
    public void TC_01_CreateNewNormalPost(){
        log.info("Create Post - Step 01 - Open Editor function");
        postPage = newsFeedPage.clickToNormalPostFunction();
        postPage = PageGenerator.openNormalPostEditor(driver);

        log.info("Create Post - Step 02 - Check Editor Post normal display");
        verifyTrue(postPage.checkCreatePostModalIsDisplay());

        log.info("Create Post - Step 03 - Enter content");
        postPage.inputPostNormalContent(contentPost);
        postPage.setTimeDelay(1);

        log.info("Create Post - Step 04 - Insert emoji");
        postPage.chooseFunctionIcon("ic-smile");
        postPage.insertEmoji(10,"9");

        log.info("Create Post - Step 05 - Insert tagging");
        postPage.chooseFunctionIcon("ic-user-tag");
        postPage.chooseUserTagging("Al");

        log.info("Create Post - Step 06 - Insert location");
        postPage.chooseFunctionIcon("ic-location");
        postPage.chooseLocationAddress("Ho Chi Minh");

        log.info("Create Post - Step 07 - Insert Image");
        postPage.chooseFunctionIcon("ic-photos");
        postPage.uploadMultipleFileByAutoIT(driver,file1);
        verifyTrue(newsFeedPage.checkAreElementsIsDisplay(driver, PostModelUI.LIST_UPLOADED_IMAGE));

        log.info("Create Post - Step 08 - Insert Feeling");
        postPage.chooseFunctionIcon("ic-grin");
        postPage.chooseFeeling("2");

        log.info("Create Post - Step 09 - Choose a post scope");
        postPage.clickChooseScopeDropdown("fa-user-friends");

        log.info("Create Post - Step 10 - Click to create post");
        postPage.clickToSharePostButton();
        newsFeedPage = PageGenerator.getNewsFeed(driver);

        log.info("Create Post - Step 11 - Click to go homepage");
        newsFeedPage.setTimeDelay(1);
        perTimelinePage = newsFeedPage.clickToUserHomePage();
        perTimelinePage = PageGenerator.getPersonalTimeLinePage(driver);
        verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,authorName,contentPost));
   }
    @Test
    public void NormalPost_03_Check_Button_Share_Post_When_User_Do_Not_Input_Content(){
        log.info("Check Share Post button - Step 01 - Open Editor function");
        newsFeedPage.clickToNormalPostFunction();
        postPage = PageGenerator.openNormalPostEditor(driver);

        log.info("Check Button Share Post - Step 02 - Verify Normal Post Display");
        verifyTrue(postPage.checkNormalPostEditorDisplay());

        log.info("Check Button Share Post - Step 03 - Check button Share Post disable");
        verifyTrue(postPage.checkSharedButtonIsDisable());

        log.info("Check Button Share Post - Step 04 - Close Post Normal Editor");
        postPage.closeNormalPostEditor();
    }
   @Test
    public void TC02_Edit_Normal_Post(){
       log.info("Edit Normal Post - Step 01 - Click edit Personal Wall");
       postPage.openFunction(driver,contentPost,authorName,"fa-edit");
       verifyTrue(postPage.checkEditPostModalIsDisplay());

       log.info("Edit Normal Post - Step 03 - Update content");
       newsFeedPage.setTimeDelay(2);
       postPage.inputPostNormalContent(updateContent);
       postPage.clickChooseScopeDropdown("fa-globe-asia");

       log.info("Edit Normal Post - Step 04 - Edit post");
       perTimelinePage = postPage.clickToSharePostButton();
       perTimelinePage= PageGenerator.getPersonalTimeLinePage(driver);

       log.info("Edit Normal Post - Step 04 - Check Edit post with new content ");
       verifyTrue(perTimelinePage.checkCreatedPostSuccessfully(driver,authorName,updateContent));
   }
   @Test
   public void TC_03_Remove_Post() {
       log.info("Edit Normal Post - Step 01 - Click remove post");
       postPage.openFunction(driver, contentPost, authorName, "fa-trash-alt");
       verifyTrue(postPage.checkConfirmDeletePostPopup());
       perTimelinePage= postPage.clickDeleteButton();
       verifyFalse(perTimelinePage.checkCreatedPostSuccessfully(driver,authorName,updateContent));
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
