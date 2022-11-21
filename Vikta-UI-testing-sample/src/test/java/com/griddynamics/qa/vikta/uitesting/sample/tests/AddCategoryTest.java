package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddCategorySteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCategoryTest extends BaseTest {

  String enteredTitle;
  String enteredDescription;
  String enteredPath;

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    addCategorySteps.openAddCategoryPage();
    enteredTitle = addCategorySteps.fillInTheField(AddCategorySteps.FieldName.TITLE);
    enteredDescription = addCategorySteps.fillInTheField(AddCategorySteps.FieldName.DESCRIPTION);
    enteredPath = addCategorySteps.fillInTheField(AddCategorySteps.FieldName.PATH);
  }
  /* @Test
  public void testAdminCanCreateCategory() {
    addCategorySteps.clickSaveButton();
    addCategorySteps.verifyMessageOfCategoryCreation();
  }
   @Test
  public void testResetButtonMakesTheFieldsEmpty() {
    addCategorySteps.clickResetButton();
    addCategorySteps.verifyThatTheFieldIsEmpty(AddCategorySteps.FieldName.TITLE);
    addCategorySteps.verifyThatTheFieldIsEmpty(AddCategorySteps.FieldName.DESCRIPTION);
    addCategorySteps.verifyThatTheFieldIsEmpty(AddCategorySteps.FieldName.PATH);
  }*/
}
