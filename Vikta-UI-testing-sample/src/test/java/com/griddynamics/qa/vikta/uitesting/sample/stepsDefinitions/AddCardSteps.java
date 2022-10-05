package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.*;

import com.codeborne.selenide.Selenide;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddCardPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddCardSteps extends BaseSteps {

  final static String SUCCESSFUL_ADDED_CARD_MESSAGE_PREFIX = "Created payment card ";

  public AddCardSteps(WebDriver driver) {
    super(driver);
  }

  private AddCardPage page() {
    return Selenide.page(AddCardPage.class);
  }

  public enum FieldName {
    CARDNUMBER,
    CARDCODE,
    OWNER,
    EXPIRATIONDATE,
    NICKNAME,
  }

  @Step
  public void openAdminAddCardPage() {
    page().userStaffButton.click();
    page().addCardButton.click();
  }

  @Step
  public void openRegularUserAddCardPage() {
    open(getData().regularUserAddCardPageUrl());
  }

  @Step
  public String fillInTheFields(FieldName fieldName) {
    String valueToReturn;
    switch (fieldName) {
      case CARDNUMBER:
        valueToReturn = randomData.generateCardNumber();
        page().cardNumberField.setValue(valueToReturn);
        break;
      case CARDCODE:
        valueToReturn = randomData.generateRandomNumber();
        page().cardCodeField.setValue(valueToReturn);
        break;
      case OWNER:
        valueToReturn = randomData.generateName();
        page().ownerField.setValue(valueToReturn);
        break;
      case EXPIRATIONDATE:
        valueToReturn = randomData.generateCardExpiryDate();
        page().expirationDateField.setValue(valueToReturn);
        break;
      case NICKNAME:
        valueToReturn = randomData.generateName();
        page().nickNameField.setValue(valueToReturn);
        break;
      default:
        throw new IllegalArgumentException("Unsupported AddCard page field name: " + fieldName);
    }
    return valueToReturn;
  }

  @Step
  public void clickSaveButton() {
    page().saveButton.click();
  }

  @Step
  public void clickClearButton() {
    page().clearButton.click();
  }

  @Step
  public void clickBackToCardsButton() {
    page().toTheListOfCardsButton.click();
  }

  @Step
  public void verifySuccessMassage(String cardNumber) {
    assertTrue(page().message.exists());
    assertEquals(page().message.innerText(), SUCCESSFUL_ADDED_CARD_MESSAGE_PREFIX + cardNumber);
  }

  @Step
  public void verifyThatTheFieldIsEmpty(FieldName fieldName) {
    switch (fieldName) {
      case CARDNUMBER:
        assertThat(page().cardNumberField.getAttribute("value").isEmpty());
        break;
      case CARDCODE:
        assertThat(page().cardCodeField.getAttribute("value").isEmpty());
        break;
      case OWNER:
        assertThat(page().ownerField.getAttribute("value").isEmpty());
        break;
      case EXPIRATIONDATE:
        assertThat(page().expirationDateField.getAttribute("value").isEmpty());
        break;
      case NICKNAME:
        assertThat(page().nickNameField.getAttribute("value").isEmpty());
        break;
    }
  }
  @Step
  public void verifyThatCardsPageIsOpened() {
    assertEquals(getDriver().getCurrentUrl(), getData().regularUserCardsPageUrl());
  }
}
