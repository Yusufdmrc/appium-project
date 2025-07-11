package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import utils.DriverFactory;

public class SearchStepDefinitions {

    SearchPage searchPage=new SearchPage(DriverFactory.getDriver());

    @When("User clicks on the search bar")
    public void userClicksOnTheSearchBar() {
        searchPage.clickSearchBar();
    }

    @And("User searches for {string}")
    public void userSearchesFor(String productName) {
        searchPage.searchForProduct(productName);

    }

    @Then("User verifies that products are listed")
    public void userChecksThatTheProductsListed() {
        searchPage.verifyProductsListed();

    }
}
