    package pages;

    import io.appium.java_client.AppiumDriver;
    import io.appium.java_client.pagefactory.AndroidFindBy;
    import io.appium.java_client.pagefactory.AppiumFieldDecorator;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.PageFactory;
    import utils.ElementHelper;

    import java.time.Duration;

    public class LoginPage {
        final AppiumDriver driver;
        final ElementHelper elementHelper;

        public LoginPage(AppiumDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
            this.elementHelper = new ElementHelper(driver);
        }

    }
