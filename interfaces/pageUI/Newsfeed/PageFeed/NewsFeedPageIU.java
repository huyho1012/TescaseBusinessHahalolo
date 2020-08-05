package pageUI.Newsfeed.PageFeed;

public class NewsFeedPageIU {
    public static final String NORMAL_POST_FUNCTION = "//a[@id='act-nav-single']";
    public static final String EXPERIENCE_POST_FUNCTION = "//a[@id='act-nav-addvance']";

    public static final String UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Cập nhật')]";
    public static final String CANCEL_UPDATE_NEW_INFO_BUTTON ="//div[@id='modal-addition-user-info']//button[contains(text(),'Bỏ qua')]";


    public static final String SELECTED_DATE_DROP_DOWN = "//select[@name= '%s']";

    public static final String SELECTED_DATE_ITEM = "//select[@name= '%s']//following-sibling::div/div[contains(@class,'selectize-dropdown')]//div[contains(@class,'option')][@data-value = '%s']";


}
