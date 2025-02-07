package stepDefinitions;

import pages.LoginPage;
import io.cucumber.java.en.When;
import pages.NotificationPage;
import utils.DriverFactory;

public class LoginStepDefinitions {
    NotificationPage notificationPage = new NotificationPage(DriverFactory.getDriver());

    @When("user login")
    public void userLogin(){
        notificationPage.clickDontAllowButton();
    }
}
