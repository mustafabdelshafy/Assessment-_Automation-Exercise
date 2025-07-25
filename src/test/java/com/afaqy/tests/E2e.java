package com.afaqy.tests;

import org.openqa.selenium.WebDriver;
import org.afaqy.drivers.DriverManager;
import org.afaqy.listeners.TestNGListeners;
import org.afaqy.pages.*;
import org.afaqy.utils.*;
import org.testng.annotations.*;

import static org.afaqy.utils.PropertiesUtils.getPropertyValue;

@Listeners(TestNGListeners.class)
public class E2e {
    // variables


    private WebDriver driver;
    private AfterSignupPage afterSignupPage;
    private HomePage homePage;
    private SignupPage signupPage;
    private String firstName=TestDataGenerator.generateFirstName();
    private String lastName=TestDataGenerator.generateLastName();
    private String fullName = TestDataGenerator.generateFullName();
    @BeforeClass
    public void setUp() {
        PropertiesUtils.loadProperties();
        System.out.println("⚙️ Running on automationexercise");


        driver = DriverManager.createInstance(getPropertyValue("browserType"));
        signupPage = new SignupPage(driver);
        afterSignupPage = new AfterSignupPage(driver);
        homePage = new HomePage(driver);
    }


    @Test(priority = 1, description = "Verify that user can signup with valid data")
    public void signupTest() {
        signupPage
                .navigateToHomePage().enterNewUserName(fullName)
                .enterNewUserEmail(TestDataGenerator.generateEmail()).clickSignupButton()
                .selectGender().enterPassword(TestDataGenerator.generatePassword())
                .selectDateOfBirth(TestDataGenerator.generateDay(), TestDataGenerator.generateMonth(), TestDataGenerator.generateYear())
                .selectNewsletter().selectSpecialOffers().enterFirstName(firstName)
                .enterLastName(lastName).enterCompany(TestDataGenerator.generateCompany())
                .enterAddress(TestDataGenerator.generateAddress()).enterState(TestDataGenerator.generateState())
                .enterCity(TestDataGenerator.generateCity()).enterZipCode(TestDataGenerator.generateZipCode())
                .enterMobileNumber(TestDataGenerator.generatePhoneNumber()).clickCreateAccountButton();
                //.assertSuccessfulLoginSoft();
    }
    @Test(priority = 2,dependsOnMethods = "signupTest", description = "Verify that the user account created Successfully")
    public void createdAccount() {
        afterSignupPage.checkSuccessMessage().checkCurrentUrl()
                .clickContinueButton().verifyHomePage();

    }
    @Test(priority = 3,dependsOnMethods = "createdAccount", description = "Verify that user can logout")
    public void logout() {
        String ActualFullName = homePage.getFullName();
        Validations.validateEquals(ActualFullName, fullName, "Logout failed");
        homePage.logout().verifyLogout();
    }

   /* @AfterClass // If you want to close the browser after tests -> remove the comment slash
    public void tearDown() {
      BrowserActions.closeBrowser(driver);
        CustomSoftAssertion.customAssertAll();
    }*/
}
