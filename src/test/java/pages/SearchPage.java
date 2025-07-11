package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ElementHelper;

import java.time.Duration;

public class SearchPage {
    final AppiumDriver driver;
    final ElementHelper elementHelper;

    @AndroidFindBy(accessibility = "Ana Sayfam")
    WebElement homepageButton;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    WebElement searchBar;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/lytOptionBarSort")
    WebElement optionBarSort;

    public SearchPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickSearchBar() {
        elementHelper.click(homepageButton);
        elementHelper.click(searchBar);
    }

    public void searchForProduct(String productName) {
        searchBar.clear();
        searchBar.sendKeys(productName);
        AndroidDriver androidDriver = (AndroidDriver) driver;
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));

    }

    public void verifyProductsListed() {
        elementHelper.checkVisible(optionBarSort);
    }
}
