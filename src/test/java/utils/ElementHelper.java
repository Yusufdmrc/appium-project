package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {
    private final AppiumDriver driver;
    private final WebDriverWait wait;
    private final Actions action;

    public ElementHelper(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
        this.action = new Actions(driver);
    }

    // Check element visibility
    public void checkVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void checkVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void checkNotVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Check element clickability
    public void checkClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void checkClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Check element invisibility
    public void checkNotVisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Click on element
    public void click(Object elementLocator){
        WebElement element = null;
        if(elementLocator instanceof WebElement){
            checkClickable((WebElement) elementLocator);
            element = (WebElement) elementLocator;
        } else if (elementLocator instanceof By) {
            checkClickable((By) elementLocator);
            element = driver.findElement((By) elementLocator);
        }
        assert element != null;
        element.click();
    }

    // Send keys to element
    public void sendKeys(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }


    // Scroll to element
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    // Get text from element
    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Check if element is displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Pause execution
    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
