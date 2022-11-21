package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddAddressSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressTests extends BaseTest {

  String addressName;

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    addAddressSteps.openAddAddressPage();
    addressName = addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.STREETNAME);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.ADDITIONALSTREETINFO);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.CITY);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.REGION);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.POSTALCODE);
    addAddressSteps.fillInTheFields(AddAddressSteps.FieldName.ADDRESSNICKNAME);
  }
  /* @Test
  public void testUserCanDeleteAddress() {
    addAddressSteps.clickSaveButton();
    addressesSteps.openAddressesPage();
    addressesSteps.clickOnTheCreatedAddress(addressName);
    addAddressSteps.clickDeleteButton();
    addAddressSteps.verifyThatSuccessDeleteMessageIsDisplayed();
  }
    @Test
  public void testToTheListOfAddressesButtonLeadsToAddressesPage() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    addAddressSteps.openAddAddressPage();
    addAddressSteps.clickToListOfAddressesButton();
    addressesSteps.verifyAddressPageIsOpened();
  }*/
}
