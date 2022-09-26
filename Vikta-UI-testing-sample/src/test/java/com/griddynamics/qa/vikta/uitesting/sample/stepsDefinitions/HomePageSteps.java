package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HomePage;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Home page related step Definitions
 */
public class HomePageSteps extends BaseSteps {

  public HomePageSteps(WebDriver driver) {
    super(driver);
  }
  @Step
  public void clickCreateUser() {
    getDriver().navigate().to(getData().createUserPageUrl());
  }

  //TODO: Add more steps.

  //TODO: Think about generics etc instead of this.
  private HomePage page() {
    return getPage(HomePage.class);
  }
}
