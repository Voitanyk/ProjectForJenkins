package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddAddressPage;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddImagePage;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.RegistrationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddImageSteps extends BaseSteps {

  public enum FieldName {
    IMAGEURL,
    TITLE,
    DESCRIPTION,
    AUTHOR,
    PRICE,
  }

  public AddImageSteps(WebDriver driver) {
    super(driver);
  }

  private AddImagePage page() {
    return Selenide.page(AddImagePage.class);
  }

  @Step
  public void openAddImagePage() {
    open(getData().addImagePageUrl());
  }

  @Step
  public String fillInTheFields(FieldName fieldName) {
    String valueToReturn;
    switch (fieldName) {
      case IMAGEURL:
        valueToReturn = getData().categoryPicture();
        page().imageUrlField.setValue(valueToReturn);
        break;
      case TITLE:
        valueToReturn = randomData.generateRandomString();
        page().titleField.setValue(valueToReturn);
        break;
      case DESCRIPTION:
        valueToReturn = randomData.generateRandomString();
        page().descriptionField.setValue(valueToReturn);
        break;
      case AUTHOR:
        valueToReturn = randomData.generateRandomString();
        page().authorField.clear();
        page().authorField.setValue(valueToReturn);
        break;
      case PRICE:
        valueToReturn = randomData.generateRandomNumber();
        page().priceField.clear();
        page().priceField.setValue(valueToReturn);
        break;
      default:
        throw new IllegalArgumentException("Unsupported AddImage page field name: " + fieldName);
    }
    return valueToReturn;
  }

  @Step
  public void clickSaveButton() {
    page().saveButton.click();
  }

  @Step
  public void clickResetButton() {
    page().resetButton.click();
  }

  @Step
  public void verifyThatSuccessMessageIsDisplayed() {
    assertThat(page().statusMessage.shouldHave(text("Created")));
  }

  @Step
  public void verifyThatTheFieldIsEmpty(FieldName fieldName) {
    switch (fieldName) {
      case IMAGEURL:
        assertThat(page().imageUrlField.shouldBe(empty));
        break;
      case TITLE:
        assertThat(page().titleField.getAttribute("value").isEmpty());
        break;
      case DESCRIPTION:
        assertThat(page().descriptionField.getAttribute("value").isEmpty());
        break;
      case AUTHOR:
        assertThat(page().authorField.getAttribute("value").startsWith("UNKNOWN AUTHOR"));
        break;
      case PRICE:
        assertThat(page().priceField.getAttribute("value").startsWith("0.0"));
        break;
    }
  }

  @Step
  public void verifyThatTheImageIsUpdated() {
    assertThat(page().statusMessage.shouldHave(text("Updated")));
  }
}
