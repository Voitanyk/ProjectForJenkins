package com.griddynamics.qa.vikta.uitesting.sample.config;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;

public class RandomData {

  TestDataAndProperties getData() {
    return DataProvider.get();
  }

  FakeValuesService randomString = new FakeValuesService(new Locale("en-GB"), new RandomService());
  Faker randomValue = new Faker();

  private String generateRandomString(int stringLength) {
    String candidate = randomString.regexify("[a-z]{" + stringLength + "}");
    return candidate;
  }

  public String generateRandomEmail() {
    String email = randomString.bothify("?##????#@gmail.com");
    return email;
  }

  public String generateRandomNumber() {
    return randomString.numerify("####");
  }

  public String generateRandomString() {
    return generateRandomString(getData().stringLength());
  }

  public String generateCardNumber() {
    String cardNumber = randomString.numerify("################");
    return cardNumber;
  }

  public String generateCardExpiryDate() {
    String cardExpiry = randomValue.business().creditCardExpiry();
    return cardExpiry;
  }

  public String generateName() {
    String cardName = randomValue.name().fullName();
    return cardName;
  }

  public String generateStreetName() {
    String streetName = randomValue.address().streetName();
    return streetName;
  }

  public String generateCityName() {
    String cityName = randomValue.address().cityName();
    return cityName;
  }

  public String generateRegionName() {
    String regionName = randomValue.address().state();
    return regionName;
  }

  public String generatePostalCode() {
    String postalCode = randomValue.address().zipCode();
    return postalCode;
  }
}
