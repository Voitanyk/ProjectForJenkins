package com.griddynamics.qa.vikta.uitesting.sample.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage extends BasePage {

  @FindBy(id = "aAddUser")
  private WebElement aAddUser;

  @FindBy(id = "btnSave")
  private WebElement btnSave;

  @FindBy(id = "tbPathToAvatarImage")
  private WebElement tbPathToAvatarImage;

  @FindBy(id = "lSurname")
  private WebElement lSurname;

  @FindBy(id = "lMiddleName")
  private WebElement lMiddleName;

  @FindBy(xpath = "//*[@id=\'divMsgOrErr\']/span")
  private WebElement successUserCreationMessage;

  @FindBy(xpath = "//*[@id=\'lPassword\']")
  private WebElement errorPasswordMessage;


    //TODO: Add missing elements.+


  public void clickSaveTheChanges() {
    btnSave.click();
  }

  public WebElement ErrorPasswordMessage() {
    return errorPasswordMessage;
  }

  private void typeIn(String value, WebElement targetElement) {
    targetElement.clear();
    targetElement.sendKeys(value);
  }

  public void typeInAvatarImage(String value) {
    typeIn(value, tbPathToAvatarImage);
  }

  public String getSurnameWarningMessage() {
    return lSurname.getText();
  }

  public String getSuccessUserCreationMessage() {
    return successUserCreationMessage.getText();
  }

  public String getPasswordWarningMessage() {
    return errorPasswordMessage.getText();
  }

  public String getPatronimWarningMessage() {
    return lMiddleName.getText();
  }
}
