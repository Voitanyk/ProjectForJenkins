package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.CategoriesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesSteps extends BaseSteps {

  @Step
  public void verifyThatCategoryIsAddedToTheList(String categoryTitle, String categoryDescription) {
    assertThat(
      getDriver().findElement(By.xpath("//a[contains(text()," + categoryTitle + ")]")).isDisplayed()
    );
    assertThat(
      getDriver()
        .findElement(By.xpath("//a[contains(text()," + categoryDescription + ")]"))
        .isDisplayed()
    );
  }

  @Step
  public void openCategoriesPage() {
    getDriver().get(getData().categoriesPageUrl());
  }

  @Step
  public void clickResetButton() {
    page().clickResetButton();
  }

  @Step
  public void typeRandomValueInSearchField() {
    page().searchField().sendKeys(randomData.generateRandomString());
  }

  @Step
  public void verifyThatTheSearchFieldIsEmpty() {
    assertThat(page().searchField().getAttribute("value").isEmpty());
  }

  public CategoriesSteps(WebDriver driver) {
    super(driver);
  }

  private CategoriesPage page() {
    return getPage(CategoriesPage.class);
  }
}
