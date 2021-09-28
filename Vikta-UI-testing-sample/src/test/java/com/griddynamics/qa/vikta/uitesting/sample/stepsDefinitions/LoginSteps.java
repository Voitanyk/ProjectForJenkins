package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Login functionality related steps.
 */
public class LoginSteps extends BaseSteps {

    @Given("user opens Login page")
    public void openLoginPage() {
        getDriver().get(getData().loginPageUrl());
    }

    @When("user types '([^']+)' as loginname and '([^']+)' as password and hits Submit")
    public void login(String username, String password) {
        page().login(username, password);
    }

    @When("user logins as regular user")
    public void loginAsRegularUser() {
        page().login(getData().userName(), getData().userPassword());
    }

    @When("user logins as ADMIN user")
    public void loginAsAdmin() {
        page().login(getData().adminName(), getData().adminPassword());
    }

    @Then("Home is displayed for the regular user")
    public void verifyCurrentPageIsHomePageForTheRegularUser() {
        verifyCurrentPageIsHomePageForTheUser(getData().userName());
    }

    @Then("Home is displayed for the ADMIN user")
    public void verifyCurrentPageIsHomePageForTheAdmin() {
        verifyCurrentPageIsHomePageForTheUser(getData().adminName());
    }

    @Then("login error message '([^']+)' is displayed")
    public void verifyErrorMessage(String text) {
        getWait().until(ExpectedConditions.visibilityOf(page().getErrorWebElement()));
        // Have a look at https://assertj.github.io/doc/
        assertThat(page().getErrorMessage().trim())
                .as("Error message was nor shown or had unexpected content.")
                .contains(text);
    }

    //TODO: Think about generics etc instead of this.
    private LoginPage page() {
        return getPage(LoginPage.class);
    }
}