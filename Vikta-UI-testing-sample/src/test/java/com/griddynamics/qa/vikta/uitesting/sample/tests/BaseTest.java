package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.auxiliary.DriverManager;
import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.*;
import io.qameta.allure.Attachment;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;

public class BaseTest {

  // TODO: Think about some IoC/DI here.
  private DriverManager driverManager;

  LoginSteps loginSteps;
  RegistrationSteps registrationSteps;
  HomePageSteps homePageSteps;
  CreateUserPageSteps createUserPageSteps;
  UsersPageSteps usersPageSteps;
  AddCategorySteps addCategorySteps;

  BaseTest() {
    driverManager = new DriverManager(DataProvider.get());
  }
  @AfterMethod
  public void screenshotUponFailure(ITestResult result){
    if (result.getStatus() == ITestResult.FAILURE){
      saveScreenshot(driverManager.takeScreenshot());
}
  }
  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenshot(byte[] screenShot) {
    return screenShot;
  }

  @BeforeClass
  void setupClass() {
    driverManager.instantiateDriver();

    loginSteps = new LoginSteps(driverManager.get());
    registrationSteps = new RegistrationSteps(driverManager.get());
    homePageSteps = new HomePageSteps(driverManager.get());
    createUserPageSteps = new CreateUserPageSteps(driverManager.get());
    usersPageSteps = new UsersPageSteps(driverManager.get());
    addCategorySteps = new AddCategorySteps(driverManager.get());
  }

  //TODO: Do a screenshot at the end upon test failure. Hint: @AfterMethod + Allure. done+

  @AfterClass
  void tearDownClass() {
    driverManager.quite();
  }
}
