package PageTest;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_002 extends TestBase {
    //1. Login to the system
    LoginPage loginPage = new LoginPage();
    //2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();
    //3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer newCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();
    private static final Logger log = LogManager.getLogger(TC_002.class);


    @Test
    public void verifyNewCustomerMenuElements()  {

        log.info("Step 1: Logging in with valid username and password");
        loginPage.login("vyvanviet@gmail.com", "abc123");

        log.info("Step 2: Navigate to 'Create Customer' page");
        customerListView.clickCustomerMenu();
        customerListView.clickCreateCustomerMenu();

        // 3.1. Name Field: Enabled & Blank by default
        log.info("Step 3.1: Verify Name field is enabled & blank by default");
        softAssert.assertTrue(newCustomerPage.isNameFieldEmpty(), "Name field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isNameFieldEnabled(), "Name field is NOT enabled.");

        // 3.2. Email Field: Enabled & Blank by default
        log.info("Step 3.2: Verify Email field is enabled & blank by default");
        softAssert.assertTrue(newCustomerPage.isEmailFieldEmpty(), "Email field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isEmailFieldEnabled(), "Email field is NOT enabled.");

        // 3.3. Phone Field: Enabled & Blank by default
        log.info("Step 3.3: Verify Phone field is enabled & blank by default");
        softAssert.assertTrue(newCustomerPage.isPhoneFieldEmpty(), "Phone field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isEmailFieldEnabled(), "Phone field is NOT enabled.");

        // 3.4. Address Field: Enabled & Blank by default
        log.info("Step 3.4: Verify Address field is enabled & blank by default");
        softAssert.assertTrue(newCustomerPage.isAddressFieldEmpty(), "Address field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isAddressFieldEnabled(), "Address field is NOT enabled.");

        // 3.5 "Create a Customer" button is enabled
        log.info("Step 3.5: Verify 'Create a Customer' button is enabled");
        softAssert.assertTrue(newCustomerPage.isCreateCustomerButtonEnabled(), "'Create a Customer' button is NOT enabled.");

        log.info("Step 4: Assert all");
        softAssert.assertAll();

        System.out.println("Passed");
    }
}