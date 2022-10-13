package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.*;

import com.codeborne.selenide.Selenide;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddressesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddressesSteps extends BaseSteps {

  public AddressesSteps(WebDriver driver) {
    super(driver);
  }

  private AddressesPage page() {
    return Selenide.page(AddressesPage.class);
  }

  @Step
  public void openAddressesPage() {
    open(getData().addressesPageUrl());
  }

  @Step
  public void clickOnTheCreatedAddress(String addressName) {
    page().addressName(addressName).click();
  }

  @Step
  public void verifyAddressIsAddedToTheList(String addressName) {
    assertTrue(page().addressName(addressName).exists());
  }

  @Step
  public void verifyAddressPageIsOpened() {
    assertEquals(getDriver().getCurrentUrl(), getData().addressesPageUrl());
  }
}
