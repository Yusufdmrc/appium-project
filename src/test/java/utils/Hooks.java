package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import pages.LoginPage;
import pages.NotificationPage;


public class Hooks {
    private AppiumDriver driver;

    public void initializeDriverAndHandleCookies() {
        String platformName = System.getProperty("platformName");
        driver = DriverFactory.initialize_Driver(platformName);

        NotificationPage notificationPage=new NotificationPage(driver);
        notificationPage.clickDontAllowButton();

    }
    @Before("(not @LoginRequired)")
    public void setUp() {
        initializeDriverAndHandleCookies();
    }

    @Before("@LoginRequired")
    public void beforeSkipLogin(){
        initializeDriverAndHandleCookies();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(Constants.CORRECT_EMAIL,Constants.CORRECT_PASSWORD);
    }

    @AfterStep
    public void takeScreenshotOnFailure(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test execution completed. Driver closed.");
        }
    }
}
