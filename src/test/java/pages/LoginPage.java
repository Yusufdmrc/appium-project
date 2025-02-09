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

        @AndroidFindBy(id = "com.pozitron.hepsiburada:id/menuItemAccountFakeView")
        WebElement accountButton;
        @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Giriş yap.\")")
        WebElement signUpButton;
        @AndroidFindBy(id = "txtUserName")
        WebElement mailBox;
        @AndroidFindBy(id = "txtPassword")
        WebElement passwordBox;
        @AndroidFindBy(id = "btnLogin")
        WebElement loginButton;
        @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Geçerli bir e-posta adresi girmelisiniz.\")")
        WebElement errorEmailMessage;
        @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Girdiğiniz şifre eksik veya hatalı.\n.\")")
        WebElement errorPasswordMessage;

        public LoginPage(AppiumDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
            this.elementHelper = new ElementHelper(driver);
        }

        public void navigateToHomePage() {
        }

        public void openLoginPage() {
        }

        public void enterUsername(String username) {
        }

        public void enterPassword(String password) {
        }

        public void clickLoginButton() {
        }

        public void verifyErrorMessage(String expectedErrorMessage) {
        }

        public void checkSuccessful() {
        }
    }
