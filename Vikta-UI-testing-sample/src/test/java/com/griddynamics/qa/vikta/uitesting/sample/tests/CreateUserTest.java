package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.CreateUserPageSteps;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

  String loginName;

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    homePageSteps.clickCreateUser();
    loginName = registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.EMAIL);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
  }

  @Test
  public void testAdminCanCreateNewUser() {
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PASSWORD);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    createUserPageSteps.typeInAvatarUrl();
    createUserPageSteps.clickSaveTheChangesButton();
    createUserPageSteps.verifySuccessfulUserCreationMessageContainsLoginName(loginName);
  }
  /* @Test
  public void testAdminCannotCreateNewUserWithoutPassword() {
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    createUserPageSteps.typeInAvatarUrl();
    createUserPageSteps.clickSaveTheChangesButton();
    createUserPageSteps.verifyThatPasswordIsMissing();
  }*/
}
