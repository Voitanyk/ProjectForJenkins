package com.griddynamics.qa.vikta.uitesting.sample.config;

import org.aeonbits.owner.Config;

// If you are curious - http://owner.aeonbits.org/docs/singleton/
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "system:env", "system:properties", "classpath:app.properties" })
public interface TestDataAndProperties extends Config {
  String browser();

  int pageLoadTimeout();

  int waitTimeout();
  String baseHost();
  String basePort();
  String baseUrl();

  String loginPageUrl();
  String registrationPageUrl();

  String adminName();
  String adminPassword();

  String userName();
  String userPassword();
  int stringLength();
  String existingEmail();
  String userRole();
  String adminRole();
  String createUserPageUrl();
  String avatarPicture();
  String usersPageUrl();
  String addCategoryPageUrl();
  String categoriesPageUrl();
  String categoryPicture();
  String addImagePageUrl();
  String imagePageUrl();
  String hutPageUrl();
  String regularUserAddCardPageUrl();
  String regularUserCardsPageUrl();
  String adminCardsPageUrl();
  String addAddressPageUrl();
  String addressesPageUrl();
}
