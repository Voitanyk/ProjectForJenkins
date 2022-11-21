package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import com.codeborne.selenide.Selenide;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.HutPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HutPageSteps extends BaseSteps {

  public HutPageSteps(WebDriver driver) {
    super(driver);
  }

  private HutPage page() {
    return Selenide.page(HutPage.class);
  }

  public enum PageName {
    CATEGORIES,
    ADDCATEGORY,
    IMAGES,
    ADDIMAGE,
    USERS,
    CREATEUSER,
  }

  @Step
  public void openHutPage() {
    open(getData().hutPageUrl());
  }

  @Step
  public void clickCategoriesButton() {
    page().categoriesButton.click();
  }

  @Step
  public void clickAddCategoryButton() {
    page().addNewCategoryButton.click();
  }

  @Step
  public void clickImageItemsButton() {
    page().imageItemsButton.click();
  }

  @Step
  public void clickAddImageButton() {
    page().addImageButton.click();
  }

  @Step
  public void clickUsersButton() {
    page().usersButton.click();
  }

  @Step
  public void clickCreateUserButton() {
    page().createUserButton.click();
  }

  @Step
  public void verifyThatNeededPageIsOpened(PageName pageName) {
    switch (pageName) {
      case CATEGORIES:
        assertEquals(getDriver().getCurrentUrl(), getData().categoriesPageUrl() + "?");
        break;
      case ADDCATEGORY:
        assertEquals(getDriver().getCurrentUrl(), getData().addCategoryPageUrl() + "?");
        break;
      case IMAGES:
        assertEquals(getDriver().getCurrentUrl(), getData().imagePageUrl() + "?");
        break;
      case ADDIMAGE:
        assertEquals(getDriver().getCurrentUrl(), getData().addImagePageUrl() + "?");
        break;
      case USERS:
        assertEquals(getDriver().getCurrentUrl(), getData().usersPageUrl() + "?");
        break;
      case CREATEUSER:
        assertEquals(getDriver().getCurrentUrl(), getData().createUserPageUrl() + "?");
        break;
    }
  }
}
