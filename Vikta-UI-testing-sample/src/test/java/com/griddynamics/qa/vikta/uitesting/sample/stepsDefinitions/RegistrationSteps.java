package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Registration functionality related steps.
 */
public class RegistrationSteps extends BaseSteps {
    private static String SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX = "User has been registered successfully: ";
    //TODO: Move to TestContext map as soon as it ready.
    private String loginnameUsed;

    @Given("user opens Registration page")
    public void openLoginPage() {
        getDriver().get(getData().registrationPageUrl());
    }

    @When("user types in some random value for '([^']+)'")
    public void typeInto(String fieldName) {
        switch (fieldName.toUpperCase()){
            case "LOGINNAME":
                this.loginnameUsed = generateRandomString();
                page().typeInLoginname(loginnameUsed);
                break;
            case "SURNAME":
                page().typeInSurname(generateRandomString());
                break;
            case "FIRSTNAME":
                page().typeInFirstname(generateRandomString());
                break;
            case "PATRONIM":
                page().typeInPatronim(generateRandomString());
                break;
            case "PASSWORD":
                page().typeInPassword(generateRandomString());
                break;
            //TODO: Add the rest... .
            default:
                throw new IllegalArgumentException("Unsupported Registration page field name: " + fieldName);
        }
    }

    //TODO: Add rest of the steps needed.

    @Then("Registration page the current one")
    public void verifyCurrentPageIsRegistration() {
        assertCurrentPageUrl(getData().registrationPageUrl(), "Registration page was expected to be the current one.");
    }

    @Then("Successful registration message is displayed")
    public void verifySuccessfulRegistrationMessageIsDisplayed() {
        getWait().until(ExpectedConditions.visibilityOf(page().getMessageWebElement()));
        // Have a look at https://assertj.github.io/doc/
        assertThat(page().getMessageText().trim())
                .as("Successful registration message was nor shown or had unexpected content.")
                .startsWith(SUCCESSFUL_REGISTRATION_MESSAGE_PREFIX);
    }

    @Then("Successful registration message contains the login name used")
    public void verifySuccessfulRegistrationMessageContainsNewUsername() {
        // Have a look at https://assertj.github.io/doc/
        assertThat(page().getMessageText().trim())
                .as("Successful registration message was expected to contain the new username used.")
                .contains(loginnameUsed);
    }

    //TODO: Think about generics etc instead of this.
    private RegistrationPage page() {
        return getPage(RegistrationPage.class);
    }
}