package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.HutPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HutTests extends BaseTest {

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    hutPageSteps.openHutPage();
  }

 /* @Test
  public void testUsersButtonOpensUsersPage() {
    hutPageSteps.clickUsersButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.USERS);
  }
  /* @Test
  public void testCreateUserButtonOpensCreateUserPage() {
    hutPageSteps.clickCreateUserButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.CREATEUSER);
  }*/
}
