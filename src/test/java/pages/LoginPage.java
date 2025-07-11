    package pages;

    import io.appium.java_client.AppiumDriver;
    import io.appium.java_client.pagefactory.AndroidFindBy;
    import io.appium.java_client.pagefactory.AppiumFieldDecorator;
    import org.checkerframework.checker.units.qual.A;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.PageFactory;
    import org.testng.Assert;
    import utils.ElementHelper;

    import java.time.Duration;

    public class LoginPage {
        final AppiumDriver driver;
        final ElementHelper elementHelper;

        @AndroidFindBy(id = "com.pozitron.hepsiburada:id/menuItemAccountFakeView")
        WebElement accountButton;
        @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Giriş yap\")")
        WebElement signUpButton;
        @AndroidFindBy(accessibility = "elektronik ürünlerde fırsatları kaçırma")
        WebElement electronicButton;
        @AndroidFindBy(xpath = "//*[contains(@resource-id,'txtUserName')]")
        WebElement mailBox;
        @AndroidFindBy(xpath = "//*[contains(@resource-id,'txtPassword')]")
        WebElement passwordBox;
        @AndroidFindBy(xpath = "//*[contains(@resource-id,'btnLogin')]")
        WebElement loginButton;
        @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Geçerli bir e-posta adresi girmelisiniz.\")")
        WebElement errorEmailMessage;
        @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Girdiğiniz şifre eksik veya hatalı.\n.\")")
        WebElement errorPasswordMessage;
        @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvUserNameFull")
        WebElement nameText;

        @AndroidFindBy(id = "android:id/button1")
        WebElement okButton;

        public LoginPage(AppiumDriver driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
            this.elementHelper = new ElementHelper(driver);
        }

        public void navigateToHomePage() {
            elementHelper.checkVisible(electronicButton);
        }

        public void openLoginPage() {
            elementHelper.click(accountButton);
            elementHelper.click(signUpButton);
        }

        public void enterUsername(String username) {
            elementHelper.click(mailBox);
            mailBox.sendKeys(username);
        }

        public void enterPassword(String password) {
            elementHelper.click(passwordBox);
            passwordBox.sendKeys(password);
        }

        public void clickLoginButton() {
            elementHelper.click(loginButton);
        }

        public void verifyErrorMessage(String expectedErrorMessage) {
            String actualErrorMessage = "";
            if (expectedErrorMessage.equals("Geçerli bir e-posta adresi girmelisiniz.")) {
                elementHelper.checkVisible(errorEmailMessage);
                actualErrorMessage = errorEmailMessage.getText();
            } else if (expectedErrorMessage.equals("Girdiğiniz şifre eksik veya hatalı.")) {
                elementHelper.checkVisible(errorPasswordMessage);
                actualErrorMessage = errorPasswordMessage.getText();
            } else {
                Assert.fail("Beklenen hata mesajı için element tanımlanmamış: " + expectedErrorMessage);
            }
            Assert.assertEquals(actualErrorMessage.trim(), expectedErrorMessage, "Hata mesajı beklenenden farklı!");
        }

        public void checkSuccessful() {
          elementHelper.click(okButton);
          elementHelper.checkVisible(nameText);
        }
    }
