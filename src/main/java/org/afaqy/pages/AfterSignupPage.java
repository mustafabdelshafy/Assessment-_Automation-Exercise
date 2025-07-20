package org.afaqy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.afaqy.utils.*;

public class AfterSignupPage {
    private WebDriver driver;

    public AfterSignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Element locators
    private final By successMessage = By.cssSelector("h2[data-qa='account-created']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    // Actions

    public String getSuccessMessageText() {
        LogsUtil.info("Getting success message text");
       return ElementActions.getText(driver, successMessage);
    }
    public AfterSignupPage checkSuccessMessage() {
        String actualValue = getSuccessMessageText();
        LogsUtil.info("Actual value: " + actualValue);
        Validations.validateEquals(actualValue, "ACCOUNT CREATED!", "Success message not matched");
        LogsUtil.info("Success message matched");
        return this;
    }
    public AfterSignupPage checkCurrentUrl() {
        String actualValue = driver.getCurrentUrl();
        LogsUtil.info("Actual value: " + actualValue);
        Validations.validateEquals(actualValue, PropertiesUtils.getPropertyValue("CreatedURL"), "Current URL not matched");
        LogsUtil.info("Current URL matched");
        return this;
    }

    public AfterSignupPage clickContinueButton() {
        LogsUtil.info("Click on continue button");
        ElementActions.clickElement(driver, continueButton);
        return new AfterSignupPage(driver);
    }
    public AfterSignupPage verifyHomePage() {
        LogsUtil.info("Verifying Home Page");
        Validations.validateEquals(BrowserActions.getCurrentURL(driver),
                PropertiesUtils.getPropertyValue("homeURL"), "Home Page not loaded");
        return this;
    }

}
