package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class CardsPage extends BasePage {

  public SelenideElement cardNumber(String number) {
    SelenideElement cardNumber = $("#trCard_" + number + " > td:nth-child(2) > a");
    return cardNumber;
  }

  public SelenideElement cardCode(String number) {
    SelenideElement cardCode = $("#trCard_" + number + " > td:nth-child(3)");
    return cardCode;
  }

  public SelenideElement cardOwner(String number) {
    SelenideElement cardOwner = $("#trCard_" + number + " > td:nth-child(4)");
    return cardOwner;
  }

  public SelenideElement cardExpiryDate(String number) {
    SelenideElement cardExpiryDate = $("#trCard_" + number + " > td:nth-child(5)");
    return cardExpiryDate;
  }

  public SelenideElement cardOwnerNickName(String number) {
    SelenideElement cardOwnerNickName = $("#trCard_" + number + " > td:nth-child(6)");
    return cardOwnerNickName;
  }

  public SelenideElement deleteButton = $("#btnDelete2");
  public SelenideElement deleteMessage = $("#divMsgOrErr > span");
}
