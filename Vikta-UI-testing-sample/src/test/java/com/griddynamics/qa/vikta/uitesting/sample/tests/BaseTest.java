package com.griddynamics.qa.vikta.uitesting.sample.tests;

import com.griddynamics.qa.vikta.uitesting.sample.auxiliary.DriverManager;
import com.griddynamics.qa.vikta.uitesting.sample.config.DataProvider;
import com.griddynamics.qa.vikta.uitesting.sample.stepsDefinitions.*;
import io.qameta.allure.Attachment;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest implements Steps{

  // TODO: Think about some IoC/DI here.
  private DriverManager driverManager;

  LoginSteps loginSteps;
  RegistrationSteps registrationSteps;
  HomePageSteps homePageSteps;
  CreateUserPageSteps createUserPageSteps;
  UsersPageSteps usersPageSteps;
  AddCategorySteps addCategorySteps;
  CategoriesSteps categoriesSteps;

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
  //  loginSteps = new LoginSteps(driverManager.get());
   // registrationSteps = new RegistrationSteps(driverManager.get());
    setLoginSteps(loginSteps);
    setRegistrationSteps(registrationSteps);
    setHomePageSteps(homePageSteps);
    setCreateUserPageSteps(createUserPageSteps);
    setUsersPageSteps(usersPageSteps);
    setAddCategorySteps(addCategorySteps);
    setCategoriesSteps(categoriesSteps);
   /* homePageSteps = new HomePageSteps(driverManager.get());
    createUserPageSteps = new CreateUserPageSteps(driverManager.get());
    usersPageSteps = new UsersPageSteps(driverManager.get());
    addCategorySteps = new AddCategorySteps(driverManager.get());
    categoriesSteps = new CategoriesSteps(driverManager.get());*/
  }

  //TODO: Do a screenshot at the end upon test failure. Hint: @AfterMethod + Allure. done+

  @AfterClass
  void tearDownClass() {
    driverManager.quite();
  }
@Override
  public void setLoginSteps(LoginSteps loginSteps) {
    this.loginSteps = new LoginSteps(driverManager.get());
  }

  @Override
  public void setRegistrationSteps(RegistrationSteps registrationSteps) {
    this.registrationSteps = new RegistrationSteps(driverManager.get());
  }

  @Override
  public void setHomePageSteps(HomePageSteps homePageSteps) {
    this.homePageSteps = new HomePageSteps(driverManager.get());

  }

  @Override
  public void setCreateUserPageSteps(CreateUserPageSteps createUserPageSteps) {
    this.createUserPageSteps = new CreateUserPageSteps(driverManager.get());
  }

  @Override
  public void setUsersPageSteps(UsersPageSteps usersPageSteps) {
    this.usersPageSteps = new UsersPageSteps(driverManager.get());
  }

  @Override
  public void setAddCategorySteps(AddCategorySteps addCategorySteps) {
    this.addCategorySteps = new AddCategorySteps(driverManager.get());
  }

  @Override
  public void setCategoriesSteps(CategoriesSteps categoriesSteps) {
    this.categoriesSteps = new CategoriesSteps(driverManager.get());
  }
}
