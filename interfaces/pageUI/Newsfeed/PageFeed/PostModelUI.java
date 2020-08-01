package pageUI.Newsfeed.PageFeed;

public class PostModelUI {
    public static final String TITLE_EDIT_NORMAL_POST = "//h6/span[contains(text(),'Chỉnh sửa bài viết')]";
    public static final String POST_CONTENT_TEXT_AREA ="//div[@class ='note-editable']";
    public static final String ITEM_FUNCTION_ON_POST = "//i[contains(),'%s']";

    public static final String SCOPE_POST_DROPDOWN = "//div[@class ='dropdown dropdown-privacy']";
    public static final String SCOPE_POST_ITEM = "//div[@class ='dropdown-item']/i[@class = 'fas %s']";

    public static final String CREATE_POST_BUTTON = "//button[@id='btn-save-post']";

    public static final String LIST_USER_TAGGED_ON_POST = "//span[@class = 'tag-area__friends']";
    public static final String USER_TAGGED_REMOVE_ICON = "//div[@id = '_input_friends']/span[@class='tagger-list'][position() ='%s']//a[@class = 'tagger-list__remove']";

    public static final String CLOSE_BUTTON_EDITOR_POST = "//button[@id = 'js_btn_nav_editor_close']";

    public static final String EMOJI_POP_UP = "//div[@id = 'js-popup-emoji']";
    public static final String EMOJI_ITEM = "//a[@class = 'emoji-list__item'][position()= '%s']";

    public static final String SEARCH_USER_TAGGING = "//div[@id = '_input_friends']/input";
    public static final String USER_TAGGING_LIST = "//div[@id= 'js-list-user-tagin']";
    public static final String USER_ITEM = "//div[contains(@class,'list-item-user')][position()='%s']";

    public static final String SEARCH_LOCATION = "//div[@id= '_input_locations']";
    public static final String LOCATION_LIST = "//div[@id='js-list-location-tagin']";
    public static final String LOCATION_ITEM = "//div[contains(@class,'list-item-location')][position()='%s']";

    public static final String FEELING_FUNCTION = "//div[@id= 'js-feeling-activity']";
    public static final String FEELING_LIST = "//div[@id= 'js-droplist-menu-feeling']";
    public static final String SEARCH_USER_FEELING = "//div[@id = 'js_tagger_input_feeling']/input";
    public static final String FEELING_ITEM = "//div[contains(@class,'feeling-item')][position()='%s']";

    public static final String LIST_UPLOADED_IMAGE = "//div[@id ='list-editor-attachment']";
    public static final String BUTTON_REMOVE_ITEM_IMAGE = "//div[@id='list-editor-attachment']//div[@class='editor-attachment__item'][position()='%s']/i[contains(@class,'attachment__remove')]";

    public static final String ADD_PHOTO_BUTTON = "//div[@class='editor-attachment__add-photo']";

    public static final String ICON_UPLOAD_LOADING = "//div[@class='editor-attachment__uploading']";

    public static final String UPLOAD_COVER_EXPERIENCE_BUTTON ="//div[@id= 'js-cover-editor-upload']";
    public static final String TITLE_EXPERIENCE_TEXT_AREA ="//input[@id='js-title-advance']";
    public static final String ICON_LOADING_COVER_EXPERIENCE = "//div[@id= 'js-cover-loading']";
    public static final String ICON_UPLOAD_COVER_EXPERIENCE = "//i[@class='fas fa-upload']";
    public static final String ICON_REMOVE_COVER_EXPERIENCE = "//i[@class= 'far fa-trash-alt']";


    public static final String DIRECT_POST_WITH_AUTHOR_CONTENT_TAGGING ="//a[@class='post-author'][contains(text(),'%s')]/ancestor::div[@class='post-head']/following-sibling::div[@class='post-body']//div[@class='body-binding-post'][contains(text(),'%s')]";
    public static final String FUNCTION_DROPDOWN_POST = "//div[@class='body-binding-post'][contains(text(),'%s')]/ancestor::div[@class='post-body']/preceding-sibling::div[@class='post-head']//a[contains(@class,'post-author')][contains(text(),'%s')]/ancestor::div[@class='post-head__content']/following-sibling::div[contains(@class,'post-head__options')]//span[@class='btn-ellipis-h']";
    public static final String ITEM_FUNCTION_POST = "//div[@class='body-binding-post'][contains(text(),'%s')]/ancestor::div[@class='post-body']/preceding-sibling::div[@class='post-head']//a[contains(@class,'post-author')][contains(text(),'%s')]/ancestor::div[@class='post-head__content']/following-sibling::div[contains(@class,'post-head__options')]//span[@class='btn-ellipis-h']/following-sibling::div//i[@class = 'far %s dropdown-item__icon']";

    public static final String CONFIRM_REMOVE_POST_POPUP = "//h6[@class = 'modal-title'][contains(text(),'Xóa bài viết')]";

}
