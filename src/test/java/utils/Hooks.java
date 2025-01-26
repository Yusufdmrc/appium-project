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
import pages.NotificationPage;


public class Hooks {
    private AppiumDriver driver;

    @Before
    public void setUp() {
        String platformName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platformName");
        String automationName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("automationName");
        driver = DriverFactory.initialize_Driver(platformName, automationName);

        NotificationPage notificationPage=new NotificationPage(driver);
        notificationPage.clickDontAllowButton();

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
