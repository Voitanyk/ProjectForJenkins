package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.ImagesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ImagesSteps extends BaseSteps {

  public ImagesSteps(WebDriver driver) {
    super(driver);
  }

  private ImagesPage page() {
    return Selenide.page(ImagesPage.class);
  }

  @Step
  public void openImagesPage() {
    open(getData().imagePageUrl());
  }

  @Step
  public void verifyThatTheCreatedImageIsAddedToTheList(String imageTitle, String imageDescription) {
    String imageId = page().getImageId(imageTitle);
    SelenideElement title = page().title(imageId);
    SelenideElement description = page().description(imageId);
    assertTrue(title.innerText().contains(imageTitle));
    assertTrue(description.innerText().contains(imageDescription));
  }

  @Step
  public void searchTheImageByItsTitle(String imageTitle) {
    page().searchField.setValue(imageTitle);
  }

  @Step
  public void verifyThatImageIsDeleted() {
    assertTrue(page().deleteMessage.isDisplayed());
  }

  @Step
  public void clickDeleteButton(String imageTitle) {
    String imageId = page().getImageId(imageTitle);
    SelenideElement deleteButton = page().deleteButton(imageId);
    deleteButton.click();
    assertEquals(page().deleteMessage.text(), "Deleted, Id=" + imageId);
  }

  @Step
  public String checkImageId(String imageTitle) {
    String imageId = page().getImageId(imageTitle);
    return imageId;
  }

  @Step
  public void clickSearchButton() {
    page().searchButton.click();
  }

  @Step
  public void verifySearchResultsByImageTitle(String imageTitle) {
    String imageId = page().getImageId(imageTitle);
    SelenideElement title = page().title(imageId);
    assertTrue(title.innerText().contains(imageTitle));
  }
}
