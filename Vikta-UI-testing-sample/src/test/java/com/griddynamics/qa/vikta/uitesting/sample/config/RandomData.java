package com.griddynamics.qa.vikta.uitesting.sample.config;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;

public class RandomData {

  TestDataAndProperties getData() {
    return DataProvider.get();
  }

  FakeValuesService randomString = new FakeValuesService(new Locale("en-GB"), new RandomService());

  private String generateRandomString(int stringLength) {
    String candidate = randomString.regexify("[a-z]{" + stringLength + "}");
    return candidate;
  }

  public String generateRandomEmail() {
    String email = randomString.bothify("?##????#@gmail.com");
    return email;
  }

  public String generateRandomString() {
    return generateRandomString(getData().stringLength());
  }
}
