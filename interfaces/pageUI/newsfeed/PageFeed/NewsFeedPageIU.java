package pageUI.newsfeed.PageFeed;

public class NewsFeedPageIU {
    public static final String NORMAL_POST_FUNCTION = "//a[@id='act-nav-single']";
    public static final String POST_SCOPE_DROPDOWN = "//div[@class= 'dropdown dropdown-privacy']";
    public static final String POST_SCOPE_OPTION = "//i[@class = 'fas %s']";

    public static final String POST_CONTENT_TEXT_BOX = "//div[@class= 'note-editable']";
    public static final String POST_FUNCTION = "//i[@class = 'ic %s']";

    public static final String EMOJI_LIST = "//div[@class= 'popup-icon-content']";
    public static final String EMOJI_ITEM = "//div[@class= 'emoji-list emoji-list--emoji']//a[position() = '%s']";
    public static final String SEARCH_TAGGING_USER = "//div[@id= '_input_friends']/input";
    public static final String FRIEND_TAGGING_LIST = "//div[@class = 'js-list-user-tagin']";
    public static final String FRIEND_TAGGING_ITEM = "//div[@class ='droplist-menu__item list-item-user'][1]";

    public static final String LOCATION_SEARCH = "//div[@id= 'js-input-tag-location-editor']//input";
    public static final String LOCATION_LIST= "//div[@id= 'js-list-location-tagin']";
    public static final String LOCATION_LIST_ITEM= "//div[@class= 'droplist-menu__item list-item-location'][1]";
    public static final String SHARE_POST_BUTTON = "//button[@id= 'btn-save-post']";
    public static final String ICON_LOADING_IMAGE = "//div[@class='editor-attachment__uploading']";
    public static final String LIST_IMAGE_UPLOADED = "//div[@class = 'editor-attachment__item']";

    public static final String FEELING_FUNCTION = "//div[@class='droplist-menu__item-name']";
    public static final String FEELING_ITEM = "//div[@id='js-droplist-menu-feeling']//div[position()='%s']";

    public static final String EXPERIENCE_POST_FUNCTION = "//a[@id='act-nav-addvance']";
    public static final String EXPERIENCE_POST_TITLE = "//input[@id= 'js-title-advance']";
    public static final String UPLOAD_EXPERIENCE_COVER_BUTTON ="//label[@id= 'js-btn-upload-cover']";

    public static final String MENU_FUNCTION_WITH_DIRECT_POST = "//div[@class='body-binding-post'][contains(text(),'%s')]/ancestor::div[@class='post-body']/preceding-sibling::div[@class='post-head']//a[contains(@class,'post-author')][contains(text(),'%s')]/ancestor::div[@class='post-head__content']/following-sibling::div[contains(@class,'post-head__options')]//span[@class='btn-ellipis-h']";
    public static final String ITEM_FUNCTION_WITH_DIRECT_POST = "//div[@class='body-binding-post'][contains(text(),'%s')]/ancestor::div[@class='post-body']/preceding-sibling::div[@class='post-head']//a[contains(@class,'post-author')][contains(text(),'%s')]/ancestor::div[@class='post-head__content']/following-sibling::div[contains(@class,'post-head__options')]//span[@class='btn-ellipis-h']/following-sibling::div//i[@class = 'far %s dropdown-item__icon']";

    public static final String TITLE_EDIT_NORMAL_POST = "//h6[@class = 'modal-title']//span[text()='Chỉnh sửa bài viết']";
}
