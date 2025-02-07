package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static AppiumDriver driver;
    static DesiredCapabilities capabilities;

    public static AppiumDriver initialize_Driver(String platformName){
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        if(platformName.equals("Android")){
            capabilities.setCapability("deviceName","emulator-5554");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("appPackage","com.pozitron.hepsiburada");
            capabilities.setCapability("appActivity","com.hepsiburada.ui.startup.SplashActivity");
        } else if (platformName.equals("IOS")) {
            capabilities.setCapability("deviceName","");
            capabilities.setCapability("appPackage","");
            capabilities.setCapability("appActivity","");
        }
        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return getDriver();
    }
    public static AppiumDriver getDriver(){
        return driver;
    }

}