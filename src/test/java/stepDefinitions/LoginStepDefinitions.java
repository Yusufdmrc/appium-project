package stepDefinitions;

import pages.LoginPage;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

}
