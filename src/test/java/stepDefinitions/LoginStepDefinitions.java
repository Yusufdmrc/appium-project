package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import io.cucumber.java.en.When;
import pages.NotificationPage;
import utils.DriverFactory;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("User at home page")
    public void userAtHomePage() {
        loginPage.navigateToHomePage();
    }

    @When("Login page opens")
    public void loginPageOpens() {
        loginPage.openLoginPage();
    }

    @And("Write {string} for username field")
    public void writeForUsernameField(String username) {
        loginPage.enterUsername(username);
    }

    @And("Write {string} for password field")
    public void writeForPasswordField(String password) {
        loginPage.enterPassword(password);
    }

    @And("Click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Check {string} message about credentials not valid")
    public void checkMessageAboutCredentialsNotValid(String expectedErrorMessage) {
        loginPage.verifyErrorMessage(expectedErrorMessage);
    }

    @Then("Check Successful login")
    public void checkSuccessfulLogin() {
        loginPage.checkSuccessful();
    }
}
