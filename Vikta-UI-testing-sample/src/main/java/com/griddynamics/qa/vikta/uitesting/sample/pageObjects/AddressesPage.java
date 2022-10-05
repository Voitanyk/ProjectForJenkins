package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class AddressesPage extends BasePage {

  public SelenideElement addressName(String name) {
    SelenideElement addressName = $(By.partialLinkText(name));
    return addressName;
  }
}
