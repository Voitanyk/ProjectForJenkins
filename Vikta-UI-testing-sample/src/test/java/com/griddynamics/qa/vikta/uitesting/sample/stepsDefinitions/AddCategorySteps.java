package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.*;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddCategoryPage;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class AddCategorySteps extends BaseSteps {

  public enum FieldName {
    TITLE,
    DESCRIPTION,
    PATH,
  }

  @Step
  public void openAddCategoryPage() {
    getDriver().get(getData().addCategoryPageUrl());
  }
  @Step
  public String fillInTheField(FieldName fieldName) {
    String valueToReturn;
    switch (fieldName) {
      case TITLE:
        valueToReturn = randomData.generateRandomString();
        page().typeInTitle(valueToReturn);
        break;
      case DESCRIPTION:
        valueToReturn = randomData.generateRandomString();
        page().typeInDescription(valueToReturn);
        break;
      case PATH:
        valueToReturn = getData().categoryPicture();
        page().typeInPathToImage(valueToReturn);
        break;
      default:
        throw new IllegalArgumentException(
          "Unsupported AddCategory page field name: " + fieldName
        );
    }
    return valueToReturn;
  }

  @Step
  public void clickSaveButton() {
    page().clickSaveButton();
  }

  @Step
  public void clickResetButton() {
    page().clickResetButton();
  }

  @Step
  public void clickToTheListOfCategoriesButton() {
    page().clickToTheListOfCategoriesButton();
  }

  @Step
  public void verifyMessageOfCategoryCreation() {
    assertThat(page().categoryCreatedMessage().isDisplayed());
  }

  @Step
  public void verifyThatCategoriesPageIsOpened() {
    assertEquals(getDriver().getCurrentUrl(), getData().categoriesPageUrl());
  }

  @Step
  public void verifyThatEnteredTestIsDisplayedInTheField(FieldName fieldName, String enteredText) {
    switch (fieldName) {
      case TITLE:
        assertEquals(page().titleField().getAttribute("value"), enteredText);
        break;
      case DESCRIPTION:
        assertEquals(page().descriptionField().getAttribute("value"), enteredText);
        break;
      case PATH:
        assertEquals(page().pathField().getAttribute("value"), getData().categoryPicture());
        break;
    }
  }

  @Step
  public void verifyThatTheFieldIsEmpty(FieldName fieldName) {
    switch (fieldName) {
      case TITLE:
        assertThat(page().titleField().getAttribute("value").isEmpty());
        break;
      case DESCRIPTION:
        assertThat(page().descriptionField().getAttribute("value").isEmpty());
        break;
      case PATH:
        assertThat(page().pathField().getAttribute("value").isEmpty());
        break;
    }
  }

  public AddCategorySteps(WebDriver driver) {
    super(driver);
  }

  private AddCategoryPage page() {
    return getPage(AddCategoryPage.class);
  }
}
