package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class HutPage extends BasePage {

  public SelenideElement categoriesButton = $("body > div:nth-child(5) > form:nth-child(1) > button");
  public SelenideElement addNewCategoryButton = $("body > div:nth-child(5) > form:nth-child(2) > button");
  public SelenideElement imageItemsButton = $("body > div:nth-child(7) > form:nth-child(1) > button");
  public SelenideElement addImageButton = $("body > div:nth-child(7) > form:nth-child(2) > button");
  public SelenideElement usersButton = $("body > div:nth-child(9) > form:nth-child(1) > button");
  public SelenideElement createUserButton = $("body > div:nth-child(9) > form:nth-child(2) > button");
}
