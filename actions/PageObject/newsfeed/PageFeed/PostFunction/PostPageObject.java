package PageObject.newsfeed.PageFeed.PostFunction;

import common.Function.AbstractPage;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import pageUI.newsfeed.PostFunctionUI;

import java.io.IOException;

public class PostPageObject extends AbstractPage {
    WebDriver driver;
    public PostPageObject(WebDriver webDriver){
        driver= webDriver;
    }

    public void enterPostContent(String textContent) {
        waitElementToVisible(driver, PostFunctionUI.CONTENT_POST_TEXT_AREA);
        sendKeyToElement(driver,PostFunctionUI.CONTENT_POST_TEXT_AREA,textContent);
    }

    public void clickImageUpload() {
    }

    public void clickButtonSharePost() {
        waitElementToClickAble(driver,PostFunctionUI.CREATE_POST_BUTTON);
        clickToElement(driver,PostFunctionUI.CREATE_POST_BUTTON);
    }
    public void uploadImageOnNormalPost(WebDriver driver,String functionName, String... fileNames) {

        waitElementToClickAble(driver,PostFunctionUI.menuPostFunction);
        clickToElement(driver,PostFunctionUI.UPLOAD_BUTTON);

        String fullFileName = "";
        for(String file : fileNames){
            fullFileName = fullFileName + "\"" +Global_Constant.UPLOAD_FOLDER + file + "\"" +" ";
        }
        fullFileName = fullFileName.trim();
        System.out.println(fullFileName);
        setTimeDelay(2);
        if(driver.toString().contains("chrome")){
            try {
                Runtime.getRuntime().exec(new String[] {Global_Constant.uploadMultipleByChromeAuto, fullFileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(driver.toString().contains("firefox")){
            try {
                Runtime.getRuntime().exec(new String[] {Global_Constant.uploadMultipleByFirefoxAuto, fullFileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        setTimeDelay(4);
    }
}
