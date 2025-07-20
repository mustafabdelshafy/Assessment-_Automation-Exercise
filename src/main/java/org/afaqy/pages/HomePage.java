package org.afaqy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.afaqy.utils.*;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By fullName = By.xpath("//li/a[contains(text(),'Logged in as')]/b");
    private final By logoutButton = By.xpath("//a[@href='/logout']");

/*public HomePage navigateToHomePage() {
        BrowserActions.navigateToURL(driver, PropertiesUtils.getPropertyValue("homeURL"));
        return this;
    }*/

    public String getFullName() {
       LogsUtil.info("Getting full name");
       return ElementActions.getText(driver, fullName);
    }

    public HomePage logout() {
        LogsUtil.info("Logging out");
        ElementActions.clickElement(driver, logoutButton);
        return this;
    }
    public HomePage verifyLogout() {
        LogsUtil.info("Verifying logout");
        Validations.validateEquals(BrowserActions.getCurrentURL(driver),
                PropertiesUtils.getPropertyValue("loginURL"), "Logout failed");
        return this;
    }



}
