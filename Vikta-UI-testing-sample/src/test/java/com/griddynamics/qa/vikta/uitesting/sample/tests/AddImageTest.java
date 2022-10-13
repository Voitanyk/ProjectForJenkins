package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddImageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddImageTest extends BaseTest {

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    addImageSteps.openAddImagePage();
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.IMAGEURL);
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.TITLE);
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.DESCRIPTION);
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.AUTHOR);
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.PRICE);
  }

  @Test
  public void testAdminCanAddImage() {
    addImageSteps.clickSaveButton();
    addImageSteps.verifyThatSuccessMessageIsDisplayed();
  }

  @Test
  public void testResetButtonMakesFieldsEmpty() {
    addImageSteps.clickResetButton();
    addImageSteps.verifyThatTheFieldIsEmpty(AddImageSteps.FieldName.IMAGEURL);
    addImageSteps.verifyThatTheFieldIsEmpty(AddImageSteps.FieldName.TITLE);
    addImageSteps.verifyThatTheFieldIsEmpty(AddImageSteps.FieldName.DESCRIPTION);
    addImageSteps.verifyThatTheFieldIsEmpty(AddImageSteps.FieldName.AUTHOR);
    addImageSteps.verifyThatTheFieldIsEmpty(AddImageSteps.FieldName.PRICE);
  }

  @Test
  public void testTheImageIsUpdated() {
    addImageSteps.clickSaveButton();
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.TITLE);
    addImageSteps.clickSaveButton();
    addImageSteps.verifyThatTheImageIsUpdated();
  }
}
