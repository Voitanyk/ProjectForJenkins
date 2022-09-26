package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends BasePage{
    @FindBy(id = "btnSearch")
    private WebElement btnSearch;

    public void clickSearchButton(){
        btnSearch.click();
    }

    @FindBy(id = "aCategories")
    private WebElement aCategories;

    public void clickCategoriesButton(){
        aCategories.click();
    }

    @FindBy(id = "tbTerm")
    private WebElement searchField;

    public WebElement searchField(){return searchField;}

    @FindBy(id = "btnResetSearchCriteria")
    private WebElement btnResetSearchCriteria;

    public void clickResetButton(){
        btnResetSearchCriteria.click();
    }


    public String titleXpath(String title){
        String xPath = "//a[contains(text(),'"+title+"')]";
        return xPath;
    }
    public String descriptionXpath(String description){
        String xPath = "//a[contains(text(),'"+description+"')]";
        return xPath;
    }

    @FindBy(partialLinkText = "data-kind=\"description\">")
    private WebElement description;

    public WebElement categoryDescription(){ return description;}
}
