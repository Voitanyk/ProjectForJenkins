package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class AddCardPage extends BasePage {

  public SelenideElement cardNumberField = $("#tbNumber");
  public SelenideElement cardCodeField = $("#tbCode");
  public SelenideElement ownerField = $("#tbOwner");
  public SelenideElement expirationDateField = $("#tbexpirationDate");
  public SelenideElement nickNameField = $("#tbNickname");
  public SelenideElement saveButton = $("#btnSave");
  public SelenideElement clearButton = $("#btnReset");
  public SelenideElement toTheListOfCardsButton = $("#aBack");
  public SelenideElement userStaffButton = $("#aUsersStuffMenuHeader");
  public SelenideElement addCardButton = $("#aUsrAddCard");

  public SelenideElement message = $("#divMsgOrErr > span");
}
