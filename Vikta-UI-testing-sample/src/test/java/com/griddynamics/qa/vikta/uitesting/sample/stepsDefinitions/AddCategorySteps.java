package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.AddCategoryPage;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.CreateUserPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class AddCategorySteps extends BaseSteps {
    public enum FieldName {
        TITLE,
        DESCRIPTION,
        PATH,
    }

    @Step
    public void openAddCategoryPage(){
        getDriver().get(getData().addCategoryPageUrl());
    }
    @Step
    public String fillInTheField(FieldName fieldName){
        String valueToReturn;
        switch (fieldName){
            case TITLE:
                valueToReturn = randomData.generateRandomString();
                page().typeInTitle(valueToReturn);
                break;
            case DESCRIPTION:
                valueToReturn = randomData.generateRandomString();
                page().typeInDescription(valueToReturn);
                break;
            case PATH:
                valueToReturn = randomData.generateRandomUrl();
                page().typeInPathToImage(valueToReturn);
                break;
            default:
                throw new IllegalArgumentException(
                        "Unsupported Registration page field name: " + fieldName
                );
        }
        return valueToReturn;
    }
    @Step
    public void clickSaveButton(){
        page().clickSaveButton();
    }
    @Step
    public void clickToTheListOfCategoriesButton(){
        page().clickSaveButton();
    }

    @Step
    public void verifyMessageOfCategoryCreation(){
        assertThat(page().categoryCreatedMessage().isDisplayed());
    }

    public AddCategorySteps(WebDriver driver) {
        super(driver);
    }

    private AddCategoryPage page() {
        return getPage(AddCategoryPage.class);
    }
}
