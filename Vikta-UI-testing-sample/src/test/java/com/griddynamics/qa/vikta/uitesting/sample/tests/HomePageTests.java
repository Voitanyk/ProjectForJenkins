package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddImageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

  String imageName;
  String imageId;
  String orderPrice;

  @BeforeMethod
  public void adminCreatesImageForPurchase() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    addImageSteps.openAddImagePage();
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.IMAGEURL);
    imageName = addImageSteps.fillInTheFields(AddImageSteps.FieldName.TITLE);
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.DESCRIPTION);
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.AUTHOR);
    orderPrice = addImageSteps.fillInTheFields(AddImageSteps.FieldName.PRICE);
    addImageSteps.clickSaveButton();
    imagesSteps.openImagesPage();
    imageId = imagesSteps.checkImageId(imageName);
    homePageSteps.clickLogOutButton();
  }

  @Test
  public void testUserCanPurchaseImage() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    homePageSteps.clickDetailsButtonOfTheCreatedImage(imageId);
    homePageSteps.clickAddToCartButton();
    homePageSteps.openCart();
    homePageSteps.clickSelectAddressButton();
    homePageSteps.chooseUsersAddress();
    homePageSteps.clickSelectCardButton();
    homePageSteps.chooseUsersCard();
    homePageSteps.clickPurchaseButton();
    homePageSteps.verifyThatTheOrderPriceIsCorrect(orderPrice);
  }

  @Test
  public void testImageSearchResultsOnTheHomePage() {
    loginSteps.openLoginPage();
    loginSteps.loginAsRegularUser();
    homePageSteps.fillInTheSearchField(imageName);
    homePageSteps.clickSearchButton();
    homePageSteps.verifySearchResult(imageId);
  }
}
