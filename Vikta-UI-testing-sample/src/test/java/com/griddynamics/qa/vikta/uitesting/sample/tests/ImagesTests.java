package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddImageSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImagesTests extends BaseTest {

  String imageTitle;
  String imageDescription;

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
    addImageSteps.openAddImagePage();
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.IMAGEURL);
    imageTitle = addImageSteps.fillInTheFields(AddImageSteps.FieldName.TITLE);
    addImageSteps.fillInTheFields(AddImageSteps.FieldName.PRICE);
    imageDescription = addImageSteps.fillInTheFields(AddImageSteps.FieldName.DESCRIPTION);
    addImageSteps.clickSaveButton();
    imagesSteps.openImagesPage();
  }

  @Test
  public void testCreatedImageIsAddedToTheList() {
    imagesSteps.verifyThatTheCreatedImageIsAddedToTheList(imageTitle, imageDescription);
    imagesSteps.clickDeleteButton(imageTitle);
  }

  @Test
  public void testSearchResultsByImageTitle() {
    imagesSteps.searchTheImageByItsTitle(imageTitle);
    imagesSteps.clickSearchButton();
    imagesSteps.verifySearchResultsByImageTitle(imageTitle);
    imagesSteps.clickDeleteButton(imageTitle);
  }

  @Test
  public void testDeleteButtonRemovesTheImage() {
    imagesSteps.verifyThatTheCreatedImageIsAddedToTheList(imageTitle, imageDescription);
    imagesSteps.clickDeleteButton(imageTitle);
    imagesSteps.verifyThatImageIsDeleted();
  }
}
