package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertTrue;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.CreateUserPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateUserPageSteps extends BaseSteps {

  public enum FieldName {
    SURNAME,
    PATRONIM,
    PASSWORD,
  }

  private static String WARNING_MESSAGE = "size must be between 1 and 288";
  public CreateUserPageSteps(WebDriver driver) {
    super(driver);
  }

  @Step
  public void typeInAvatarUrl() {
    page().typeInAvatarImage(getData().avatarPicture());
  }

  @Step
  public void clickSaveTheChangesButton() {
    page().clickSaveTheChanges();
  }

  @Step
  public void clickCreateUser() {
    page().clickAddUser();
  }

  @Step
  public void verifySuccessfulUserCreationMessageContainsLoginName(String username) {
    assertThat(page().getSuccessUserCreationMessage().trim().contains(username));
  }

  @Step
  public void verifyThatPasswordIsMissing() {
    assertTrue(page().ErrorPasswordMessage().isDisplayed());
  }

  @Step
  public void verifyThatWarningMessageIsDisplayed(FieldName fieldName) {
    switch (fieldName) {
      case SURNAME:
        assertThat(page().getSurnameWarningMessage().trim().contains(WARNING_MESSAGE));
        break;
      case PASSWORD:
        assertThat(page().getPasswordWarningMessage().trim().contains(WARNING_MESSAGE));
        break;
      case PATRONIM:
        assertThat(page().getPatronimWarningMessage().trim().contains(WARNING_MESSAGE));
    }
  }

  private CreateUserPage page() {
    return getPage(CreateUserPage.class);
  }
}
