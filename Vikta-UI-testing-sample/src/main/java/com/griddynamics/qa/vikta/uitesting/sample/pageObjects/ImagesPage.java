package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import com.google.common.base.CharMatcher;

public class ImagesPage extends BasePage {

  public SelenideElement deleteMessage = $("#tMessage");
  public SelenideElement searchButton = $("#btnSearch");
  public SelenideElement searchField = $("#tbTerm");

  public SelenideElement imageTitle(String title) {
    SelenideElement imageTitle = $(byText(title));
    return imageTitle;
  }

  public SelenideElement imageDescription(String description) {
    SelenideElement imageDescription = $(byText(description));
    return imageDescription;
  }

  public SelenideElement title(String id) {
    SelenideElement title = $(byXpath("//*[@id=\'trImage_" + id + "\']/td[3]/a"));
    return title;
  }

  public SelenideElement description(String id) {
    SelenideElement description = $(byXpath("//*[@id=\'trImage_" + id + "\']/td[4]"));
    return description;
  }

  public String getImageId(String title) {
    String imageId = imageTitle(title).attr("href");
    String id = imageId.substring(imageId.length() - 3);
    return id;
  }

  public SelenideElement deleteButton(String imageId) {
    String xPath = "//*[@id=\'trImage_" + imageId + "\']/td[10]/a";
    SelenideElement deleteButton = $(byXpath(xPath));
    return deleteButton;
  }
}
