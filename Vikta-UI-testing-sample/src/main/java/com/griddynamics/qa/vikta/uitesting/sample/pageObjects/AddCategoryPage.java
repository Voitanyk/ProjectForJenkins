package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCategoryPage extends BasePage{
    @FindBy(id = "tbTitle")
    private WebElement tbTitle;

    public void clickInTitleField(){
        tbTitle.click();
    }
    @FindBy (xpath = "//*[@id=\"divMsgOrErr\"]/span")
    private WebElement categoryCreatedMessage;

    @FindBy(id = "tbDescription")
    private WebElement tbDescription;

    public void clickInDescriptionField(){
        tbDescription.click();
    }
    @FindBy(id = "tbPathToCatImage")
    private WebElement tbPathToCatImage;

    public void clickInPathToImageField(){
        tbPathToCatImage.click();
    }
    @FindBy(id = "btnSave")
    private WebElement btnSave;

    public void clickSaveButton(){
        btnSave.click();
    }
    @FindBy(id = "aBack")
    private WebElement aBack;

    public void clickToTheListOfCategoriesButton(){
        aBack.click();
    }
    public void typeInTitle(String value) {
        typeIn(value, tbTitle);
    }

    public WebElement categoryCreatedMessage(){
        return categoryCreatedMessage;
    }
    public void typeInDescription(String value) {
        typeIn(value, tbDescription);
    }
    public void typeInPathToImage(String value) {
        typeIn(value, tbPathToCatImage);
    }
    private void typeIn(String value, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(value);
    }

}
