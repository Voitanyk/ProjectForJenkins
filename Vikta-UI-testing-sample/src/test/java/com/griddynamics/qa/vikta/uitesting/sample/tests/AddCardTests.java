package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddCardSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCardTests extends BaseTest {

  String cardNumber;

  @Test
  public void testAdminCanAddCard() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    addCardSteps.openAdminAddCardPage();
    cardNumber = addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDNUMBER);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDCODE);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.OWNER);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.EXPIRATIONDATE);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.NICKNAME);
    addCardSteps.clickSaveButton();
    addCardSteps.verifySuccessMassage(cardNumber);
  }

  @Test
  public void testRegularUserCanAddCard() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    addCardSteps.openRegularUserAddCardPage();
    cardNumber = addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDNUMBER);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDCODE);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.OWNER);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.EXPIRATIONDATE);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.NICKNAME);
    addCardSteps.clickSaveButton();
    addCardSteps.verifySuccessMassage(cardNumber);
  }

  @Test
  public void testClearButtonMakesFieldsEmpty() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    addCardSteps.openAdminAddCardPage();
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDNUMBER);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDCODE);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.OWNER);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.EXPIRATIONDATE);
    addCardSteps.fillInTheFields(AddCardSteps.FieldName.NICKNAME);
    addCardSteps.clickClearButton();
    addCardSteps.verifyThatTheFieldIsEmpty(AddCardSteps.FieldName.CARDNUMBER);
    addCardSteps.verifyThatTheFieldIsEmpty(AddCardSteps.FieldName.CARDCODE);
    addCardSteps.verifyThatTheFieldIsEmpty(AddCardSteps.FieldName.OWNER);
    addCardSteps.verifyThatTheFieldIsEmpty(AddCardSteps.FieldName.EXPIRATIONDATE);
    addCardSteps.verifyThatTheFieldIsEmpty(AddCardSteps.FieldName.NICKNAME);
  }

  @Test
  public void testToTheListOfCardsButtonLeadsToCardsPage() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    addCardSteps.openRegularUserAddCardPage();
    addCardSteps.clickBackToCardsButton();
    addCardSteps.verifyThatCardsPageIsOpened();
  }
}
