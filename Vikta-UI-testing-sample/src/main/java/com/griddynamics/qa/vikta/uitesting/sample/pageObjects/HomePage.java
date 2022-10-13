package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object of Home page
 */
public class HomePage extends BasePage {

  //TODO: Add more. done+

  public SelenideElement imageDetailsButton(String imageId) {
    SelenideElement detailsButton = $("#imageItem" + imageId + " > nav > a");
    return detailsButton;
  }

  public SelenideElement createdImage(String imageId) {
    SelenideElement createdImage = $("#imageItemTitle" + imageId);
    return createdImage;
  }

  public SelenideElement addToCartButton = $("#aAddToCart");
  public SelenideElement cartButton = $("#imgCartTop");
  public SelenideElement selectAddressButton = $("#slctAddress");
  public SelenideElement selectCardButton = $("#slctPayment");
  public SelenideElement createdUsersAddress = $("#slctAddress > option:nth-child(2)");
  public SelenideElement createdUsersCard = $("#slctPayment > option:nth-child(2)");
  public SelenideElement purchaseButton = $("#btnPurchase");
  public SelenideElement totalPrice = $("#spPurchaseTotal");
  public SelenideElement logOutButton = $("#aLogoutTop > img");
  public SelenideElement searchField = $("#tbTerm");
  public SelenideElement searchButton = $("#btnSearch");
}
