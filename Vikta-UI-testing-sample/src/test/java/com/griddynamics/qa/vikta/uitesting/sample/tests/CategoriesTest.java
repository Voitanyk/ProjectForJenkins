package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.config.RandomData;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddCategorySteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoriesTest extends BaseTest {

  String enteredTitle;
  String enteredDescription;
  String enteredPath;

  @BeforeMethod
  public void setUp() {
    loginSteps.openLoginPage();
    loginSteps.loginAsAdmin();
  }
  /* @Test
  public void testCreatedCategoryIsAddedToTheList() {
    addCategorySteps.openAddCategoryPage();
    enteredTitle = addCategorySteps.fillInTheField(AddCategorySteps.FieldName.TITLE);
    enteredDescription = addCategorySteps.fillInTheField(AddCategorySteps.FieldName.DESCRIPTION);
    enteredPath = addCategorySteps.fillInTheField(AddCategorySteps.FieldName.PATH);
    addCategorySteps.clickSaveButton();
    categoriesSteps.openCategoriesPage();
    categoriesSteps.verifyThatCategoryIsAddedToTheList(enteredTitle, enteredDescription);
  }
  */
}
