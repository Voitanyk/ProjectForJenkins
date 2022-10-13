package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.*;

import com.codeborne.selenide.Selenide;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.CardsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CardsSteps extends BaseSteps {

  public CardsSteps(WebDriver driver) {
    super(driver);
  }

  private CardsPage page() {
    return Selenide.page(CardsPage.class);
  }

  @Step
  public void openAdminCardsPage() {
    open(getData().adminCardsPageUrl());
  }

  @Step
  public void openRegularUserCardsPage() {
    open(getData().regularUserCardsPageUrl());
  }

  @Step
  public void clickDeleteButton() {
    page().deleteButton.click();
  }

  @Step
  public void verifyCardIsDeleted() {
    assertTrue(page().deleteMessage.exists());
  }

  @Step
  public void verifyCorrectCardDataIsAddedToTheCardsTable(String cardNumber, String cardCode, String owner, String expiryDate, String nickName) {
    assertEquals(page().cardNumber(cardNumber).innerText(), cardNumber);
    assertEquals(page().cardCode(cardNumber).innerText(), cardCode);
    assertEquals(page().cardOwner(cardNumber).innerText(), owner);
    assertEquals(page().cardExpiryDate(cardNumber).innerText(), expiryDate);
    assertEquals(page().cardOwnerNickName(cardNumber).innerText(), nickName);
  }

  @Step
  public void clickOnTheNeededCard(String cardNumber) {
    page().cardNumber(cardNumber).click();
  }
}
