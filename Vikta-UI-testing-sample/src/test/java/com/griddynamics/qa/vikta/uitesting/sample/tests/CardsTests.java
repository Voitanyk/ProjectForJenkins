package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddCardSteps;
import org.testng.annotations.Test;

public class CardsTests extends BaseTest {

  String cardNumber;
  String cardCode;
  String cardOwner;
  String cardExpiryDate;
  String nickName;

  @Test
  public void testRegularUserCanDeleteCard() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    addCardSteps.openRegularUserAddCardPage();
    cardNumber = addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDNUMBER);
    cardCode = addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDCODE);
    cardOwner = addCardSteps.fillInTheFields(AddCardSteps.FieldName.OWNER);
    cardExpiryDate = addCardSteps.fillInTheFields(AddCardSteps.FieldName.EXPIRATIONDATE);
    nickName = addCardSteps.fillInTheFields(AddCardSteps.FieldName.NICKNAME);
    addCardSteps.clickSaveButton();
    cardsSteps.openRegularUserCardsPage();
    cardsSteps.clickOnTheNeededCard(cardNumber);
    cardsSteps.clickDeleteButton();
    cardsSteps.verifyCardIsDeleted();
  }

  @Test
  public void testCreatedCardDataIsCorrectlyAddedToTheList() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    addCardSteps.openAdminAddCardPage();
    cardNumber = addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDNUMBER);
    cardCode = addCardSteps.fillInTheFields(AddCardSteps.FieldName.CARDCODE);
    cardOwner = addCardSteps.fillInTheFields(AddCardSteps.FieldName.OWNER);
    cardExpiryDate = addCardSteps.fillInTheFields(AddCardSteps.FieldName.EXPIRATIONDATE);
    nickName = addCardSteps.fillInTheFields(AddCardSteps.FieldName.NICKNAME);
    addCardSteps.clickSaveButton();
    cardsSteps.openAdminCardsPage();
    cardsSteps.verifyCorrectCardDataIsAddedToTheCardsTable(cardNumber, cardCode, cardOwner, cardExpiryDate, nickName
    );
  }
}
