package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUI.newsfeed.PostFunctionUI;

import java.io.IOException;
import java.sql.Driver;
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

    // Timeout
    public void setImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Global_Constant.TIME_OUT, TimeUnit.SECONDS);
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
        explicitWait = new WebDriverWait(driver,Global_Constant.TIME_OUT);
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
        explicitWait = new WebDriverWait(driver,Global_Constant.TIME_OUT);
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
        return findElement(driver,locator).isDisplayed();
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

    // Webdriver wait
    public void waitElementToClickAble(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, Global_Constant.TIME_OUT);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
    }
    public void waitElementToVisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, Global_Constant.TIME_OUT);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
    }
    public void waitElementToInvisible(WebDriver driver, String locator){
        explicitWait = new WebDriverWait(driver, Global_Constant.TIME_OUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
    }

    public void uploadMultipleBySendKey(WebDriver driver, String... fileNames){
        String fullFileName = "";
        for(String file : fileNames){
            fullFileName = fullFileName + Global_Constant.UPLOAD_FOLDER+ file+ "\n";
        }
        fullFileName = fullFileName.trim();
        sendKeyToElement(driver, PostFunctionUI.UPLOAD_BUTTON_FLIED_INPUT,fullFileName);
    }

}
