package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.AddCategorySteps;
import org.testng.annotations.Test;

public class AddCategoryTest extends BaseTest{
    @Test
    public void testAdminCanCreateCategory(){
        loginSteps.openLoginPage();
        loginSteps.loginAsAdmin();
        addCategorySteps.openAddCategoryPage();
        addCategorySteps.fillInTheField(AddCategorySteps.FieldName.TITLE);
        addCategorySteps.fillInTheField(AddCategorySteps.FieldName.DESCRIPTION);
        addCategorySteps.fillInTheField(AddCategorySteps.FieldName.PATH);
        addCategorySteps.clickSaveButton();
        addCategorySteps.verifyMessageOfCategoryCreation();
    }
}
