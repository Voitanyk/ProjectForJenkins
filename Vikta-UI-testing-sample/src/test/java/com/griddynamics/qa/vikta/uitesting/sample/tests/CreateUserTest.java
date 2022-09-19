package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.CreateUserPageSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

  @Test
  public void testAdminCanCreateNewUser() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    createUserPageSteps.clickCreateUser();
    String loginName = registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PASSWORD);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.EMAIL);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    createUserPageSteps.typeInAvatarUrl();
    createUserPageSteps.clickSaveTheChangesButton();
    createUserPageSteps.verifySuccessfulUserCreationMessageContainsLoginName(loginName);
  }

  @Test
  public void testAdminCannotCreateNewUserWithoutPassword() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    createUserPageSteps.clickCreateUser();
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.EMAIL);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    createUserPageSteps.typeInAvatarUrl();
    createUserPageSteps.clickSaveTheChangesButton();
    createUserPageSteps.verifyThatPasswordIsMissing();
  }

  @Test
  public void testWarningMessagesAreDisplayedForEmptyFields() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    createUserPageSteps.clickCreateUser();
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.EMAIL);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    createUserPageSteps.clickSaveTheChangesButton();
    createUserPageSteps.verifyThatWarningMessageIsDisplayed(CreateUserPageSteps.FieldName.SURNAME);
    createUserPageSteps.verifyThatWarningMessageIsDisplayed(CreateUserPageSteps.FieldName.PASSWORD);
    createUserPageSteps.verifyThatWarningMessageIsDisplayed(CreateUserPageSteps.FieldName.PATRONIM);
  }
}
