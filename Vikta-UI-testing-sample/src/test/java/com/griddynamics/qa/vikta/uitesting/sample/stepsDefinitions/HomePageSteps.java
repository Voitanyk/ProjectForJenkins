package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static org.testng.AssertJUnit.assertTrue;

import com.codeborne.selenide.Selenide;
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

  @Step
  public void clickDetailsButtonOfTheCreatedImage(String imageId) {
    page().imageDetailsButton(imageId).click();
  }

  @Step
  public void clickAddToCartButton() {
    page().addToCartButton.click();
  }

  @Step
  public void openCart() {
    page().cartButton.click();
  }

  @Step
  public void clickSelectAddressButton() {
    page().selectAddressButton.click();
  }

  @Step
  public void clickSelectCardButton() {
    page().selectCardButton.click();
  }

  @Step
  public void chooseUsersCard() {
    page().createdUsersCard.click();
  }

  @Step
  public void chooseUsersAddress() {
    page().createdUsersAddress.click();
  }

  @Step
  public void clickPurchaseButton() {
    page().purchaseButton.click();
  }

  @Step
  public void fillInTheSearchField(String imageName) {
    page().searchField.setValue(imageName);
  }

  @Step
  public void clickLogOutButton() {
    page().logOutButton.click();
  }

  @Step
  public void verifyThatTheOrderPriceIsCorrect(String price) {
    assertTrue(page().totalPrice.innerText().contains(price));
  }

  @Step
  public void verifySearchResult(String imageId) {
    assertTrue(page().createdImage(imageId).isDisplayed());
  }

  @Step
  public void clickSearchButton() {
    page().searchButton.click();
  }

  //TODO: Add more steps. ++

  // TODO: Think about generics etc instead of this.
  private HomePage page() {
    return Selenide.page(HomePage.class);
  }
}
