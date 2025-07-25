package org.afaqy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.afaqy.utils.BrowserActions;
import org.afaqy.utils.ElementActions;
import org.afaqy.utils.LogsUtil;
import org.afaqy.utils.PropertiesUtils;

public class SignupPage {
    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements
    private final By newUserName = By.name("name");
    private final By newUserEmail = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");
    private final By gender = By.id("id_gender1");
    private final By password = By.name("password");
    private final By day = By.id("days");
    private final By month = By.id("months");
    private final By year = By.id("years");
    private final By newsletter = By.id("newsletter");
    private final By specialOffers = By.id("optin");
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address = By.id("address1");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipCode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    // Actions

    public SignupPage navigateToHomePage() {
        BrowserActions.navigateToURL(driver, PropertiesUtils.getPropertyValue("baseURL"));
        return this;
    }
    public SignupPage enterNewUserName(String userName) {
        LogsUtil.info("Enter new user name: " + userName);
        ElementActions.sendData(driver, newUserName, userName);
        return this;
    }

    public SignupPage enterNewUserEmail(String userEmail) {
        LogsUtil.info("Enter new user email: " + userEmail);
        ElementActions.sendData(driver, newUserEmail, userEmail);
        return this;
    }

    public SignupPage clickSignupButton() {
        LogsUtil.info("Click on signup button");
        ElementActions.clickElement(driver, signupButton);
        return this;
    }

    public SignupPage selectGender() {
        LogsUtil.info("Select gender");
        ElementActions.clickElement(driver, gender);
        return this;
    }

    public SignupPage enterPassword(String userPassword) {
        LogsUtil.info("Enter password: " + userPassword);
        ElementActions.sendData(driver, password, userPassword);
        return this;
    }

    public SignupPage selectDateOfBirth(String day, String month, String year) {
        LogsUtil.info("Select date of birth: " + day + "/" + month + "/" + year);
        ElementActions.selectFromDropdown(driver, this.day, day);
        ElementActions.selectFromDropdown(driver, this.month, month);
        ElementActions.selectFromDropdown(driver, this.year, year);
        return this;
    }

    public SignupPage selectNewsletter() {
        LogsUtil.info("Select newsletter");
        ElementActions.clickElement(driver, newsletter);
        return this;
    }

    public SignupPage selectSpecialOffers() {
        LogsUtil.info("Select special offers");
        ElementActions.clickElement(driver, specialOffers);
        return this;
    }

    public SignupPage enterFirstName(String firstName) {
        LogsUtil.info("Enter first name: " + firstName);
        ElementActions.sendData(driver, this.firstName, firstName);
        return this;
    }

    public SignupPage enterLastName(String lastName) {
        LogsUtil.info("Enter last name: " + lastName);
        ElementActions.sendData(driver, this.lastName, lastName);
        return this;
    }

    public SignupPage enterCompany(String company) {
        LogsUtil.info("Enter company: " + company);
        ElementActions.sendData(driver, this.company, company);
        return this;
    }

    public SignupPage enterAddress(String address) {
        LogsUtil.info("Enter address: " + address);
        ElementActions.sendData(driver, this.address, address);
        return this;
    }

    public SignupPage enterState(String state) {
        LogsUtil.info("Enter state: " + state);
        ElementActions.sendData(driver, this.state, state);
        return this;
    }

    public SignupPage enterCity(String city) {
        LogsUtil.info("Enter city: " + city);
        ElementActions.sendData(driver, this.city, city);
        return this;
    }

    public SignupPage enterZipCode(String zipCode) {
        LogsUtil.info("Enter zip code: " + zipCode);
        ElementActions.sendData(driver, this.zipCode, zipCode);
        return this;
    }

    public SignupPage enterMobileNumber(String mobileNumber) {
        LogsUtil.info("Enter mobile number: " + mobileNumber);
        ElementActions.sendData(driver, this.mobileNumber, mobileNumber);
        return this;
    }

    public AfterSignupPage clickCreateAccountButton() {
        LogsUtil.info("Click on submit button");
        ElementActions.clickElement(driver, createAccountButton);
        return new AfterSignupPage(driver);
    }


}
