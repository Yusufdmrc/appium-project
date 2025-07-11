package testRunners;
import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.DriverFactory;

@CucumberOptions(
        features ={"src/test/resources/features"},
        glue = {"stepDefinitions","utils"},
        tags = "@SuccessfulLogin",
        plugin = {
                "summary","pretty","html:Reports/CucumberReport/Reports.html",
                "json:Reports/CucumberReport/Reports.json",
        },
        monochrome = true
)

public class runner extends AbstractTestNGCucumberTests {
}