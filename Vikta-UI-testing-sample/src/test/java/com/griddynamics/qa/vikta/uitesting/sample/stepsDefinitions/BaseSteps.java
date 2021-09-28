package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.Hooks;
import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import com.griddynamics.qa.vikta.uitesting.sample.config.TestDataAndProperties;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Base class to contain common auxiliary methods for step definitions.
 */
abstract class BaseSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    protected WebDriver getDriver() {
        return Hooks.driver;
    }

    protected WebDriverWait getWait() {
        if (Objects.isNull(this.wait)) {
            this.wait = new WebDriverWait(driver, getData().waitTimeout());
        }

        return wait;
    }

    protected TestDataAndProperties getData() {
        return DataProvider.get();
    }

    protected <P> P getPage(Class<P> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }

    protected void verifyCurrentPageIsHomePageForTheUser(String username) {
        BasePage currentPage = getPage(BasePage.class);
        getWait().until(ExpectedConditions.visibilityOf(currentPage.getLoggedInName()));

        assertCurrentPageUrl(getData().baseUrl(), "Home page was expected to be the current one.");

        assertThat(currentPage.getCurrentUserName())
                .as("Unexpected current user's name displayed. Expected: %s", username)
                .contains(username);
        //TODO: Assert displayed role as well.
    }

    protected void assertCurrentPageUrl(String expectedUrl, String messageOnFail) {
        assertThat(getDriver().getCurrentUrl())
                .as(messageOnFail)
                .contains(expectedUrl);
    }

    //TODO: Make static and move to some Utils.
    //TODO: Use something like JavaFaker.
    protected String generateRandomString(int maxLength) {

        String candidate = UUID.randomUUID().toString().replaceAll("\\d", "A");
        if (candidate.length() >= maxLength) {
            return candidate.substring(0, maxLength);
        } else {
            return candidate;
        }
    }

    protected String generateRandomString() {
        return generateRandomString(16); //Remember!!! Magic numbers are bad, bad, bad practice!
    }
}
