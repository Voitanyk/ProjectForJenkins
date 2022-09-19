package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Home page
 */
public class HomePage extends BasePage {

  //TODO: Add more.

  @FindBy(id = "1")
  private WebElement categoryEmpty;

  public void clickCategoryEmpty() {
    categoryEmpty.click();
  }

  @FindBy(id = "2")
  private WebElement categoryFull;

  public void clickCategoryFull() {
    categoryFull.click();
  }

  @FindBy(id = "3")
  private WebElement categoryMyths;

  public void clickCategoryMyths() {
    categoryMyths.click();
  }

  @FindBy(id = "4")
  private WebElement categoryCity;

  public void clickCategoryCity() {
    categoryCity.click();
  }

  @FindBy(id = "5")
  private WebElement categoryStreet;

  public void clickCategoryStreet() {
    categoryStreet.click();
  }

  @FindBy(id = "6")
  private WebElement categoryTech;

  public void clickCategoryTech() {
    categoryTech.click();
  }

  @FindBy(id = "7")
  private WebElement categoryWhoUN;

  public void clickCategoryWhoUN() {
    categoryWhoUN.click();
  }

  @FindBy(id = "8")
  private WebElement categoryMupirocinCalcium;

  public void clickCategoryMupirocinCalcium() {
    categoryMupirocinCalcium.click();
  }

  @FindBy(id = "9")
  private WebElement categoryMystery;

  public void clickCategoryMystery() {
    categoryMystery.click();
  }

  @FindBy(id = "10")
  private WebElement categoryCountry;

  public void clickCategoryCountry() {
    categoryCountry.click();
  }

  @FindBy(id = "11")
  private WebElement categoryConstruction;

  public void clickCategoryConstruction() {
    categoryConstruction.click();
  }

  @FindBy(id = "12")
  private WebElement categoryNapoleon;

  public void clickCategoryNapoleon() {
    categoryNapoleon.click();
  }

  @FindBy(id = "13")
  private WebElement categoryGreatDane;

  public void clickCategoryGreatDane() {
    categoryGreatDane.click();
  }
}
