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

  @Test
  public void testCategoriesButtonOpensCategoriesPage() {
    hutPageSteps.clickCategoriesButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.CATEGORIES);
  }

  @Test
  public void testAddCategoryButtonOpensAddCategoryPage() {
    hutPageSteps.clickAddCategoryButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.ADDCATEGORY);
  }

  @Test
  public void testImageItemsButtonOpensImageItemsPage() {
    hutPageSteps.clickImageItemsButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.IMAGES);
  }

  @Test
  public void testAddImageButtonOpensAddImagePage() {
    hutPageSteps.clickAddImageButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.ADDIMAGE);
  }

  @Test
  public void testUsersButtonOpensUsersPage() {
    hutPageSteps.clickUsersButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.USERS);
  }

  @Test
  public void testButtonOpensPage() {
    hutPageSteps.clickCreateUserButton();
    hutPageSteps.verifyThatNeededPageIsOpened(HutPageSteps.PageName.CREATEUSER);
  }
}
