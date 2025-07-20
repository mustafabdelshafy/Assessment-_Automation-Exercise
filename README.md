📋 Automated Sign-Up Test – Automation Exercise
✅ Objective
This project automates the sign-up process on the Automation Exercise using:

Java + Selenium WebDriver

TestNG (Test framework)

Page Object Model (POM)

Data Driven Testing (random user generation)

Optional integrations: Allure Reports, Soft Assertions, and Listeners

📂 Project Structure
src
├── main
│   └── java/org/afaqy
│       ├── drivers        → WebDriver setup & browser factories
│       ├── listeners      → TestNG listeners
│       ├── pages          → POM: SignupPage, AfterSignupPage, HomePage
│       └── utils          → Custom utilities (Assertions, Actions, Logging, Properties)
│
├── test
│   └── java/com/afaqy/tests → Test class: E2e.java
│
└── testng                  → testng-e2e.xml config
🧪 Test Scenario
The test validates user registration with dynamic data:

Navigate to https://automationexercise.com/

Click Signup/Login

Fill all registration fields with randomly generated test data

Click Create Account

Verify that the account is created

Click Continue

Verify the user is logged in successfully

Click Logout

Verify the user is redirected to the login page

📦 Tech Stack
Tool/Library	Purpose
Java	-> Programming Language

Selenium WebDriver ->	UI Automation

TestNG	->   Test Management

POM	 -> Page Object Pattern

Random Data -> Utils	Dynamic test data

Allure -> Reporting

Log4j	-> Logging

Soft Assertions ->	Flexible validation

🔁 Data Driven Testing
Instead of hard-coded data, user data is generated dynamically using the TestDataGenerator utility:
String firstName = TestDataGenerator.generateFirstName();
String email = TestDataGenerator.generateEmail();
String password = TestDataGenerator.generatePassword();
▶️ How to Run the Tests
Clone the repository

Make sure all dependencies are resolved (Maven/Gradle)

Update automationexercise.properties with correct URLs:
baseURL=https://automationexercise.com/
CreatedURL=https://automationexercise.com/account_created
homeURL=https://automationexercise.com/
loginURL=https://automationexercise.com/login
browserType=chrome

Run using TestNG XML file:
testng/testng-e2e.xml
📜 Sample TestNG XML (testng-e2e.xml)
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="AutomationExercise E2E Test Suite">
    <listeners>
        <listener class-name="org.afaqy.listeners.TestNGListeners"/>
    </listeners>

    <test name="Signup & Logout Test">
        <classes>
            <class name="com.afaqy.tests.E2e">
                <methods>
                    <include name="signupTest"/>
                    <include name="createdAccount"/>
                    <include name="logout"/>
                </methods>
            </class>
        </classes>
    </test>
</suite>

 Reports
This project optionally supports:
Allure Reports
Screenshot on failure
