package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class AddImagePage extends BasePage {

  public SelenideElement imageUrlField = $("#tbUEL");
  public SelenideElement titleField = $("#tbTitle");
  public SelenideElement descriptionField = $("#tbDescription");
  public SelenideElement authorField = $("#tbAuthor");
  public SelenideElement statusMessage = $("#divMsgOrErr");
  public SelenideElement priceField = $("#tbPrice");
  public SelenideElement toImageListButton = $("#aBack");
  public SelenideElement saveButton = $("#btnSave");
  public SelenideElement resetButton = $("#btnReset");
}
