package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.ElementHelper;

import java.time.Duration;

public class NotificationPage {
    final AppiumDriver driver;
    final ElementHelper elementHelper;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private WebElement dontAllowButton;

    public NotificationPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickDontAllowButton(){
        elementHelper.click(dontAllowButton);
    }

}
