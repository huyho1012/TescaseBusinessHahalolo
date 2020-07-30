package PageObject.newsfeed.PageFeed;

import PageObject.newsfeed.Common.AbstractMenuPage;
import PageObject.newsfeed.Common.PageGenerator;
import PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import org.openqa.selenium.WebDriver;
import pageUI.Common.MediaManagerUI;
import pageUI.newsfeed.Common.HeaderPageUI;
import pageUI.newsfeed.Common.sidebarRightUI;
import pageUI.newsfeed.PageFeed.NewsFeedPageIU;

public class NewsfeedTabPageObject extends AbstractMenuPage {
    WebDriver driver;
    public NewsfeedTabPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    // Hàm thay đổi ngôn ngữ hiển thị
    public void changeLanguageDisplay() {
        waitForPageLoading(driver);
        if(!checkIsDisplayedElement(driver, sidebarRightUI.VI_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        } else if(checkIsDisplayedElement(driver,sidebarRightUI.ENG_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        }
    }

    // Hàm kiểm tra đang ở tab Newsfeed
    public boolean checkNewsFeedTabSelected(){
        waitElementToVisible(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        return checkIsDisplayedElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
    }

    // Hàm kiểm tra đã login thành công hay chưa
    public boolean checkLoginSuccess() {
        waitElementToVisible(driver, HeaderPageUI.CART_FUNCTION);
        return checkIsDisplayedElement(driver, HeaderPageUI.CART_FUNCTION);
    }

    public void clickToNormalPostFunction() {
        waitElementToClickAble(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        clickToElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
    }

    public boolean checkNormalPostEditorDisplay() {
        waitElementToVisible(driver,NewsFeedPageIU.POST_SCOPE_DROPDOWN);
        return checkIsDisplayedElement(driver,NewsFeedPageIU.POST_SCOPE_DROPDOWN);
    }

    public boolean checkSharedButtonIsDisable() {
        waitElementToVisible(driver,NewsFeedPageIU.POST_SCOPE_DROPDOWN);
        if(!checkIsDisplayedElement(driver,NewsFeedPageIU.POST_SCOPE_DROPDOWN)) {
            return true;
        }
        return false;
    }

    public void inputPostNormalContent(String contentPost) {
        waitElementToVisible(driver, NewsFeedPageIU.POST_CONTENT_TEXT_BOX);
        sendKeyToElement(driver,NewsFeedPageIU.POST_CONTENT_TEXT_BOX, contentPost);
    }

    public void clickToPostFunction(String functionName) {
        waitElementToClickAble(driver, NewsFeedPageIU.POST_FUNCTION, functionName);
        clickToElement(driver, NewsFeedPageIU.POST_FUNCTION, functionName);
    }

    public void insertEmoji(String emojiIndex) {
        for(int i = 0; i<10; i++){
            waitElementToClickAble(driver,NewsFeedPageIU.EMOJI_LIST);
            clickToElement(driver,NewsFeedPageIU.EMOJI_ITEM,emojiIndex);
        }
    }

    public void chooseUserTagging(String friendName) {
        waitElementToVisible(driver,NewsFeedPageIU.SEARCH_TAGGING_USER);
        sendKeyToElement(driver,NewsFeedPageIU.SEARCH_TAGGING_USER,friendName);
        setTimeDelay(2);
        clickToElementByJS(driver,NewsFeedPageIU.FRIEND_TAGGING_ITEM);
    }
    public void chooseLocationAddress(String locationName) {
        waitElementToVisible(driver,NewsFeedPageIU.LOCATION_SEARCH);
        sendKeyToElement(driver,NewsFeedPageIU.LOCATION_SEARCH,locationName);
        setTimeDelay(2);
        waitElementToVisible(driver,NewsFeedPageIU.LOCATION_LIST);
        clickToElement(driver,NewsFeedPageIU.LOCATION_LIST_ITEM);
    }
    public void chooseFeeling(String feelingName) {
        waitElementToClickAble(driver,NewsFeedPageIU.FEELING_FUNCTION);
        clickToElement(driver,NewsFeedPageIU.FEELING_FUNCTION);

        waitElementToClickAble(driver,NewsFeedPageIU.FEELING_ITEM,feelingName);
        clickToElement(driver,NewsFeedPageIU.FEELING_ITEM,feelingName);
    }

    public void clickChooseScopeDropdown(String scopeName) {
        waitElementToClickAble(driver,NewsFeedPageIU.POST_SCOPE_DROPDOWN);
        clickToElement(driver,NewsFeedPageIU.POST_SCOPE_DROPDOWN);

        waitElementToClickAble(driver,NewsFeedPageIU.POST_SCOPE_OPTION,scopeName);
        clickToElement(driver,NewsFeedPageIU.POST_SCOPE_OPTION,scopeName);
    }

    public void clickToSharePostButton() {
        waitElementsToInvisible(driver,NewsFeedPageIU.ICON_LOADING_IMAGE);
        waitElementToClickAble(driver,NewsFeedPageIU.SHARE_POST_BUTTON);
        clickToElement(driver,NewsFeedPageIU.SHARE_POST_BUTTON);
    }

    public PersonalTimelinePageObject clickToUserHomePage() {
        waitElementToVisible(driver, HeaderPageUI.PERSONAL_URL_LINK);
        clickToElement(driver,HeaderPageUI.PERSONAL_URL_LINK);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }

    public void clickToExperienceEditor() {
        waitElementToClickAble(driver,NewsFeedPageIU.EXPERIENCE_POST_FUNCTION);
        clickToElement(driver,NewsFeedPageIU.EXPERIENCE_POST_FUNCTION);
    }

    public boolean checkToExperienceEditorDisplay() {
        waitElementToVisible(driver, NewsFeedPageIU.UPLOAD_EXPERIENCE_COVER_BUTTON);
        return checkIsDisplayedElement(driver,NewsFeedPageIU.UPLOAD_EXPERIENCE_COVER_BUTTON);
    }

    public void inputExperienceTitle(String titleExperience) {
        waitElementToVisible(driver, NewsFeedPageIU.EXPERIENCE_POST_TITLE);
        sendKeyToElement(driver,NewsFeedPageIU.EXPERIENCE_POST_TITLE,titleExperience);
    }

    public void inputExperienceContent(String randomParagraphs) {
        waitElementToVisible(driver,NewsFeedPageIU.POST_CONTENT_TEXT_BOX);
        sendKeyToElement(driver,NewsFeedPageIU.POST_CONTENT_TEXT_BOX,randomParagraphs);
    }

    public void clickUploadCoverButton() {
        waitElementToClickAble(driver,NewsFeedPageIU.UPLOAD_EXPERIENCE_COVER_BUTTON);
        clickToElement(driver,NewsFeedPageIU.UPLOAD_EXPERIENCE_COVER_BUTTON);
    }

    public void chooseImageToInsert(String indexImage) {
        waitElementToVisible(driver, MediaManagerUI.TITLE_MEDIA_MANAGER);
        waitElementToVisible(driver,MediaManagerUI.IMAGE_ROOT_ITEM,indexImage);
        clickToElement(driver,MediaManagerUI.IMAGE_ROOT_ITEM,indexImage);
        setTimeDelay(1);
        waitElementToVisible(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
        clickToElement(driver,MediaManagerUI.SELECT_IMAGE_BUTTON);
    }
    public void openFunction(WebDriver driver, String postContent, String authorName, String functionPost){
        waitElementToVisible(driver,NewsFeedPageIU.MENU_FUNCTION_WITH_DIRECT_POST,postContent,authorName);
        clickToElement(driver,NewsFeedPageIU.MENU_FUNCTION_WITH_DIRECT_POST,postContent,authorName);
        waitElementToClickAble(driver,NewsFeedPageIU.MENU_FUNCTION_WITH_DIRECT_POST,postContent,authorName,functionPost);
        clickToElement(driver,NewsFeedPageIU.MENU_FUNCTION_WITH_DIRECT_POST,postContent,authorName,functionPost);
    }
}
