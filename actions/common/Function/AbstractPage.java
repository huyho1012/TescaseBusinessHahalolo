package common.Function;

import common.Global_Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUI.newsfeed.Common.HeaderPageUI;
import pageUI.newsfeed.PostFunctionUI;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    private Actions action;
    private WebDriverWait explicitWait;
    private Alert alert;
    private Select select;
    private WebElement element;
    private List<WebElement> elements;
    private JavascriptExecutor jsExecutor;

    public String castToObject(String locator, String... values){
        return  String.format(locator, values);
    }
    // Timeout
    public void waitForPageLoading(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(Global_Constant.LONG_TIME_OUT,TimeUnit.SECONDS);
    }
    public void setImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Global_Constant.LONG_TIME_OUT, TimeUnit.SECONDS);
    }
    public void setTimeDelay(long time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // WebBrowser
    public void openURL(WebDriver driver,String urlPage){
        driver.get(urlPage);
    }
    public String getTitlePage(WebDriver driver){
        return  driver.getTitle();
    }
    public String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }
    public void backPreviousPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToNextPage(WebDriver driver){
        driver.navigate().forward();
    }
    public void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }
    // Alert
    public void waitPresenceAlert(WebDriver driver){
        explicitWait = new WebDriverWait(driver,Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(WebDriver driver){
        waitPresenceAlert(driver);
        driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAccept(WebDriver driver){
        waitPresenceAlert(driver);
        driver.switchTo().alert();
        alert.dismiss();
    }
    public String getAlertText(WebDriver driver){
        waitPresenceAlert(driver);
        driver.switchTo().alert();
        return alert.getText();
    }
    public void sendKeyOnAlert(WebDriver driver, String valueText){
        waitPresenceAlert(driver);
        driver.switchTo().alert();
        alert.sendKeys(valueText);
    }
    // Window
    public void switchToAnotherWindowByID(WebDriver driver, String parentID){
        Set<String> allWindow = driver.getWindowHandles();
        for(String currentWindow: allWindow){
            if(!currentWindow.equals(parentID)){
                driver.switchTo().window(currentWindow);
                break;
            }
        }
    }
    public void switchToAnotherWindowByTitle(WebDriver driver, String titleWindow){
        Set<String> allWindow = driver.getWindowHandles();
        for(String currentWindow:allWindow){
            driver.switchTo().window(currentWindow);
            String textCurrentWindow = driver.getTitle();
            if(!currentWindow.equals(titleWindow)){
                break;
            }
        }
    }
    public void closeAllWindowExceptParentWindow(WebDriver driver,String parentID){
        Set<String> allWindow = driver.getWindowHandles();
        for(String currentWindow :allWindow){
            driver.switchTo().window(currentWindow);
            driver.close();
        }
        driver.switchTo().window(parentID);
    }
    public int getTotalWindow(WebDriver driver){
        return driver.getWindowHandles().size();
    }

    // Frame or IFrame
    public void switchToFrameOrIFrame(WebDriver driver, String locator){
        driver.switchTo().frame(findElement(driver,locator));
    }
    public void switchToDefaultIFrame(WebDriver driver, String locator){
        driver.switchTo().defaultContent();
    }

    // WebElement
    public By byXpath(String xpathValue){
        return By.xpath(xpathValue);
    }
    public WebElement findElement(WebDriver driver, String locator){
        return driver.findElement(byXpath(locator));
    }
    public List<WebElement> findElements(WebDriver driver, String locator){
        return driver.findElements(byXpath(locator));
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value){
        element = findElement(driver,locator);
        element.clear();
        element.sendKeys(value);
    }
    public void clickToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        element.click();
    }

    public void selectItemInDefaultDropdown(WebDriver driver , String locator, String itemValue){
        select = new Select(findElement(driver,locator));
        select.selectByVisibleText(itemValue);
    }
    public String getSelectedItemOnDropdown(WebDriver driver,String locator){
        select = new Select(findElement(driver,locator));
        return select.getFirstSelectedOption().getText();
    }
    public Boolean checkDropdownIsMultiple(WebDriver driver, String locator){
        select = new Select(findElement(driver,locator));
        return select.isMultiple();
    }
    public void selectItemInCustomDropdown(WebDriver driver, String dropdownMenu, String dropdownItem, String expectedItem){
        clickToElement(driver,dropdownMenu);
        setTimeDelay(1);
        explicitWait = new WebDriverWait(driver,Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(dropdownItem)));
        elements = findElements(driver,dropdownItem);
        for(WebElement item: elements){
            if(item.getText().contains(expectedItem)){
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);",item);
                setTimeDelay(1);
                item.click();
                break;
            }
        }
    }

    public String getTextOfElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        return element.getText();
    }
    public String getAttributeOfElement(WebDriver driver, String locator, String attributeValue){
        element = findElement(driver,locator);
        return element.getAttribute(attributeValue);
    }
    public int countElements(WebDriver driver, String locator){
        elements = findElements(driver,locator);
        return elements.size();
    }

    public boolean checkIsDisplayedElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        return element.isDisplayed();
    }
    public boolean checkIsEnableElement(WebDriver driver, String locator){
        return findElement(driver,locator).isEnabled();
    }
    public boolean checkIsSelectedElement(WebDriver driver, String locator){
        return findElement(driver,locator).isSelected();
    }
    // Action
    public void doubleClickToElement(WebDriver driver, String locator){
        action = new Actions(driver);
        element = findElement(driver,locator);
        action.doubleClick(element).perform();
    }
    public void hoverMouseToElement(WebDriver driver, String locator){
        element = findElement(driver, locator);
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator){
        element = findElement(driver,locator);
        action = new Actions(driver);
        action.contextClick(element).perform();
    }
    public void sendKeyboardToElement(WebDriver driver, String locator, Keys key){
        element = findElement(driver, locator);
        action = new Actions(driver);
        action.sendKeys(element,key).perform();
    }
    // Upload
    public void uploadOneFileBySendKey(WebDriver driver, String locator, String fileName){
        waitElementToVisible(driver,locator);
        sendKeyToElement(driver,locator,fileName);
    }
    public void uploadMultipleFileBySendKey(WebDriver driver,String locator, String... fileNames){
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName = fullFileName + Global_Constant.UPLOAD_FOLDER+ file+ "\n";
        }
        fullFileName = fullFileName.trim();
        waitElementToVisible(driver,locator);
        sendKeyToElement(driver,locator,fullFileName);
    }
    public void uploadFileByRobot(WebDriver driver, String... fileNames){
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName = fullFileName + Global_Constant.UPLOAD_FOLDER+ file+ "\n";
        }
        fullFileName = fullFileName.trim();
        StringSelection select = new StringSelection(fullFileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select,null);
        try {
            Robot robot = new Robot();
            setTimeDelay(1);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            setTimeDelay(1);

        } catch (AWTException e) {
            e.printStackTrace();
        }

    }
    public void uploadMultipleFileByAutoIT(WebDriver driver, String... fileNames){
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName = fullFileName + "\"" +Global_Constant.UPLOAD_FOLDER + file + "\"" +" ";
        }
        fullFileName = fullFileName.trim();
        if (driver.toString().contains("firefox")){
            try {
                Runtime.getRuntime().exec(new String[] {Global_Constant.uploadMultipleByFirefoxAuto, fullFileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (driver.toString().contains("chrome")){
            try {
                Runtime.getRuntime().exec(new String[] {Global_Constant.uploadMultipleByChromeAuto, fullFileName});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        setTimeDelay(3);
    }
    // Javascript Executor
    public void sendKeyToElementByJS(WebDriver driver,String locator, String valueName){
        jsExecutor =(JavascriptExecutor) driver;
        element = findElement(driver,locator);
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + valueName +"')", element);
    }
    public void scrollToElement(WebDriver driver , String locator, String valueName){
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver,locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void clickToElementByJS(WebDriver driver, String locator){
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver,locator);
        jsExecutor.executeScript("arguments[0].click();",element);
    }
    public void highlightElementByJS(WebDriver driver, String locator){
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }
    public void removeAttributeByJS(WebDriver driver, String locator,String attributeName){
        jsExecutor = (JavascriptExecutor) driver;
        element = findElement(driver,locator);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);
    }
    public boolean verifyTextInInnerText(String textExpected) {
        String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }
    // Driver wait
    public void waitElementToClickAble(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
    }
    public void waitElementToVisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
    }
    public void waitElementToPresence(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
    }
    public void waitElementToInvisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
    }
    public void waitElementsToInvisible(WebDriver driver, String locator){
        elements = findElements(driver,locator);
        explicitWait = new WebDriverWait(driver, Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
    // Dynamic locator
    public void clickToElement(WebDriver driver, String locator, String...values) {
        element = findElement(driver, castToObject(locator, values));
        element.click();
    }
    public void waitElementToVisible(WebDriver driver, String locator, String...values){
        explicitWait = new WebDriverWait(driver, Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castToObject(locator, values))));
    }
    public void waitElementToClickAble(WebDriver driver, String locator, String... values){
        explicitWait = new WebDriverWait(driver, Global_Constant.LONG_TIME_OUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castToObject(locator,values))));
    }

    // Dynamic Locator
    public boolean checkIsSelectedElement(WebDriver driver, String locator, String... values){
        element = findElement(driver,castToObject(locator, values));
        return element.isSelected();
    }

    public boolean checkAreElementsIsDisplay(WebDriver driver, String locator){
        elements = findElements(driver,locator);
        if(!elements.isEmpty()){
            return true;
        } else return false;
    }
}
