package com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions;

import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.RegistrationPage;
import com.griddynamics.qa.vikta.uitesting.sample.pageObjects.UsersPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class UsersPageSteps extends BaseSteps {
    public UsersPageSteps(WebDriver driver) {
        super(driver);
    }

    /*  final String loginName = create
      //*[@id="trUser_qwe"]/td[2]*/
    @Step
    public void openUsersPage(){
        getDriver().get(getData().usersPageUrl());
    }

    @Step
    public void specifyUserDetailsInTheSearchField(String email, String loginName) {
        page().clickInSearchField();
        page().searchField().sendKeys(email+"+"+loginName);
        page().clickSearchButton();
    }

    @Step
    public void verifyTheSearchResults(String loginName, String email){
        String loginNameXpath = page().userLoginNameXpath(loginName);
        String emailXpath = page().userEmailXpath(loginName);
        WebElement userLoginName = getDriver().findElement(By.xpath(loginNameXpath));
        WebElement userEmail = getDriver().findElement(By.xpath(emailXpath));
        assertEquals(userLoginName.getText(), loginName);
        assertEquals(userEmail.getText(), email);
    }

    @Step
    public void verifyThatUserIsAdded(String loginName){
        String xPath = page().userLoginNameXpath(loginName);
        WebElement userLoginName = getDriver().findElement(By.xpath(xPath));
        assertTrue(userLoginName.isDisplayed());
    }

    @Step
    public void verifyThatUserIsDeleted(String loginName) {
        String xPath = page().userDeleteButtonXpath(loginName);
        WebElement userDeleteButton = getDriver().findElement(By.xpath(xPath));
        userDeleteButton.click();
        assertTrue(page().tMessage().isDisplayed());
    }

    private UsersPage page() {
        return getPage(UsersPage.class);
    }
}
