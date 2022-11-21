package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.RegistrationSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {

  String loginName;
  String email;

  @BeforeMethod
  public void setup() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    homePageSteps.clickCreateUser();
    loginName = registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.LOGINNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PASSWORD);
    email = registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.EMAIL);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.SURNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.FIRSTNAME);
    registrationSteps.typeRandomValueInto(RegistrationSteps.FieldName.PATRONIM);
    createUserPageSteps.clickSaveTheChangesButton();
    usersPageSteps.openUsersPage();
  }


  @Test
  public void testThatTheUserWasDeletedFromTheUsersList() {
    usersPageSteps.verifyThatUserIsDeleted(loginName);
  }
}
