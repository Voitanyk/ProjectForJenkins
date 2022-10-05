package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddAddressSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAddressTests extends BaseTest {

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    addAddressSteps.openAddAddressPage();
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.STREETNAME);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.ADDITIONALSTREETINFO);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.CITY);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.REGION);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.POSTALCODE);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.ADDRESSNICKNAME);
  }

  @Test
  public void testRegularUserCanAddAddress() {
    addAddressSteps.clickSaveButton();
    addAddressSteps.verifyThatSuccessAddressCreationMessageIsDisplayed();
  }

  @Test
  public void testClearButtonMakesAddressFieldsEmpty() {
    addAddressSteps.clickClearButton();
    addAddressSteps.verifyThatTheFieldIsEmpty(AddAddressSteps.FieldName.STREETNAME);
    addAddressSteps.verifyThatTheFieldIsEmpty(AddAddressSteps.FieldName.ADDITIONALSTREETINFO);
    addAddressSteps.verifyThatTheFieldIsEmpty(AddAddressSteps.FieldName.CITY);
    addAddressSteps.verifyThatTheFieldIsEmpty(AddAddressSteps.FieldName.REGION);
    addAddressSteps.verifyThatTheFieldIsEmpty(AddAddressSteps.FieldName.POSTALCODE);
    addAddressSteps.verifyThatTheFieldIsEmpty(AddAddressSteps.FieldName.ADDRESSNICKNAME);
  }
}
