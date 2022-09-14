package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * "Parent" Page Object for almost all of the rest of the pages (except Login).
 *
 * More to read:
 * https://selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/
 * https://martinfowler.com/bliki/PageObject.html
 * https://www.baeldung.com/selenium-webdriver-page-object
 * https://www.pluralsight.com/guides/getting-started-with-page-object-pattern-for-your-selenium-tests
 *
 */
public class BasePage {

  //TODO: Add more header/ footer elements. +

  @FindBy(id = "sploggedInName")
  private WebElement sploggedInName;

  @FindBy(id = "aLogoutTop")
  private WebElement aLogoutTop;

  @FindBy(id = "aHome")
  private WebElement aHome;

  @FindBy(id = "aAddresses")
  private WebElement aAddresses;

  @FindBy(id = "aAddAddress")
  private WebElement aAddAddress;

  @FindBy(id = "aCards")
  private WebElement aCards;

  @FindBy(id = "aAddCards")
  private WebElement aAddCards;

  @FindBy(id = "aEditProfile")
  private WebElement aEditProfile;

  @FindBy(id = "navbar")
  private WebElement navbar;

  @FindBy(id = "aLogoutBottom")
  private WebElement aLogoutBottom;

  @FindBy(id = "tbTerm")
  private WebElement tbTerm;

  @FindBy(id = "btnSearch")
  private WebElement btnSearch;

  @FindBy(id = "btnResetSearchCriteria")
  private WebElement btnResetSearchCriteria;

  @FindBy(id = "aRegistration")
  private WebElement aRegistration;

  @FindBy(id = "aLogin")
  private WebElement aLogin;

  public String getCurrentUserName() {
    return sploggedInName.getText();
  }

  public WebElement getLoggedInName() {
    return sploggedInName;
  }

  public void clickLogout() {
    aLogoutTop.click();
  }

  public void clickAddresses() { aAddresses.click();}
  public void clickAddAddresses() { aAddAddress.click();}
  public void clickCards() { aCards.click();}
  public void clickAddCards() { aAddCards.click();}
  public void clickEditProfile() { aEditProfile.click();}
  public void clickNavbar() { navbar.click();}
  public void clickLogoutBottom() { aLogoutBottom.click();}
  public void clickInSearchField() { tbTerm.click();}
  public void clickSearchButton() { btnSearch.click();}
  public void clickResetButton() { btnResetSearchCriteria.click();}
  public void clickSignUpButton() { aRegistration.click();}
  public void clickLoginButton() { aLogin.click();}

}
