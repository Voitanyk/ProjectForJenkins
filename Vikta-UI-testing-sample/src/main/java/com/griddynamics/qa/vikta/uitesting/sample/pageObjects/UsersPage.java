package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {

    @FindBy (id = "tMessage")
    private WebElement tMessage;
    @FindBy(id = "btnSearch")
    private WebElement btnSearch;

    @FindBy(id = "tbTerm")
    private WebElement tbTerm;
    @FindBy (xpath = "//*[@id=\"trUser_qq\"]/td[2]")
    private WebElement registeredUserQqLoginName;

    @FindBy (xpath = "//*[@id=\"trUser_qq\"]/td[3]")
    private WebElement registeredUserQqEmail;

    public void clickSearchButton() {
        btnSearch.click();
    }

    public void clickInSearchField() {
        tbTerm.click();
    }

    public WebElement searchField(){
        return tbTerm;
    }

    public String getUserQqLoginName() {
        return registeredUserQqLoginName.getText();
    }

    public String getUserQqEmail() {
        return registeredUserQqEmail.getText();
    }
    public String userLoginNameXpath(String loginName){
        String xPath = "//*[@id=\"trUser_"+loginName+"\"]/td[2]/a";
        return xPath;
    }

    public String userEmailXpath(String loginName){
        String xPath = "//*[@id=\"trUser_"+loginName+"\"]/td[3]";
        return xPath;
    }
    public String userDeleteButtonXpath(String loginName){
        String xPath = "//*[@id=\"trUser_"+loginName+"\"]/td[7]/a";
        return xPath;
    }
    public WebElement tMessage(){
        return tMessage;
    }

}
