package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertTrue;

import com.codeborne.selenide.Selenide;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddAddressPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddAddressSteps extends BaseSteps {

  public AddAddressSteps(WebDriver driver) {
    super(driver);
  }

  private AddAddressPage page() {
    return Selenide.page(AddAddressPage.class);
  }

  public enum FieldName {
    STREETNAME,
    ADDITIONALSTREETINFO,
    CITY,
    REGION,
    POSTALCODE,
    ADDRESSNICKNAME,
  }

  @Step
  public void openAddAddressPage() {
    open(getData().addAddressPageUrl());
  }

  @Step
  public String fillInTheFields(FieldName fieldName) {
    String valueToReturn;
    switch (fieldName) {
      case STREETNAME:
        valueToReturn = randomData.generateStreetName();
        page().streetNameField.setValue(valueToReturn);
        break;
      case ADDITIONALSTREETINFO:
        valueToReturn = randomData.generateStreetName();
        page().additionalStreetInfoField.setValue(valueToReturn);
        break;
      case CITY:
        valueToReturn = randomData.generateCityName();
        page().cityField.setValue(valueToReturn);
        break;
      case REGION:
        valueToReturn = randomData.generateRegionName();
        page().regionField.setValue(valueToReturn);
        break;
      case POSTALCODE:
        valueToReturn = randomData.generatePostalCode();
        page().postalCodeField.setValue(valueToReturn);
        break;
      case ADDRESSNICKNAME:
        valueToReturn = randomData.generateName();
        page().addressNickNameField.setValue(valueToReturn);
        break;
      default:
        throw new IllegalArgumentException("Unsupported AddAddress page field name: " + fieldName);
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
  public void clickDeleteButton() {
    page().deleteButton.click();
  }

  @Step
  public void editCityField() {
    page().cityField.setValue(randomData.generateCityName());
  }

  @Step
  public void clickToListOfAddressesButton() {
    page().toTheAddressesPageButton.click();
  }

  @Step
  public void verifyThatSuccessDeleteMessageIsDisplayed() {
    assertTrue(page().infoMessage.innerText().startsWith("Deleted"));
  }

  @Step
  public void verifyThatSuccessAddressCreationMessageIsDisplayed() {
    assertTrue(page().infoMessage.innerText().startsWith("Created user address"));
  }

  @Step
  public void verifyThatSuccessUpdateMessageIsDisplayed() {
    assertTrue(page().infoMessage.innerText().startsWith("Updated user address"));
  }

  @Step
  public void verifyThatTheFieldIsEmpty(FieldName fieldName) {
    switch (fieldName) {
      case STREETNAME:
        assertTrue(page().streetNameField.getAttribute("value").isEmpty());
        break;
      case ADDITIONALSTREETINFO:
        assertTrue(page().additionalStreetInfoField.getAttribute("value").isEmpty());
        break;
      case CITY:
        assertThat(page().cityField.getAttribute("value").isEmpty());
        break;
      case REGION:
        assertThat(page().regionField.getAttribute("value").isEmpty());
        break;
      case POSTALCODE:
        assertThat(page().postalCodeField.getAttribute("value").isEmpty());
        break;
      case ADDRESSNICKNAME:
        assertThat(page().addressNickNameField.getAttribute("value").isEmpty());
        break;
    }
  }
}
