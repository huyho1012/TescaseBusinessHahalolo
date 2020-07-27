package common;

public class Global_Constant {
    public static String USER_NAME = "balo_04@mailinator.com";
    public static String PASSWORD = "123456";
    // URL các project Hahalolo
    public static final String URL_NEWS_FEED_LOGIN = "https://test-newsfeed.hahalolo.com/auth/signin";
    public static final String URL_BUSINESS_LOGIN = "";
    // Constant
    public static final long LONG_TIME_OUT = 30;
    public static final long LESS_TIME_OUT = 5;
    public static final String HTML_CODE = "<p> Hello word </p>";
    public static final String SCRIPT_CODE = "<script>destroyWebsite();</script>";
    // Đường dẫn thư mục
    public static final String ROOT_FOLDER = System.getProperty("user.dir");
    public static final String UPLOAD_FOLDER = ROOT_FOLDER+"\\FileUpload\\";


    public static final String uploadMultipleByChromeAuto = Global_Constant.ROOT_FOLDER + "\\AutoIT\\chromeUploadMultiple.exe";
    public static final String uploadMultipleByFirefoxAuto = Global_Constant.ROOT_FOLDER + "\\AutoIT\\firefoxUploadMultiple.exe";

}
