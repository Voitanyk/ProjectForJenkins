package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class AddAddressPage extends BasePage {

  public SelenideElement streetNameField = $("#tbStreet");
  public SelenideElement additionalStreetInfoField = $("#tbStreetAdditional");
  public SelenideElement cityField = $("#tbCityName");
  public SelenideElement regionField = $("#tbRegionName");
  public SelenideElement postalCodeField = $("#tbPostalCode");
  public SelenideElement addressNickNameField = $("#tbAddressNickname");
  public SelenideElement saveButton = $("#btnSave");
  public SelenideElement clearButton = $("#btnReset");
  public SelenideElement deleteButton = $("#btnDelete");
  public SelenideElement toTheAddressesPageButton = $("#aBack");
  public SelenideElement infoMessage = $("#divMsgOrErr > span");
}
