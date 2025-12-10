package PageTest;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import Utils.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_001 extends TestBase {
    //1. Login to the system
    LoginPage loginPage = new LoginPage();
    // 2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();
    // 3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer createCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();
    private static final Logger log = LogManager.getLogger(TC_001.class);


    @Test
    public void verifyCreateCustomerPageElements() {

        log.info("Step 1: Logging in with valid username and password");
        loginPage.login(Config.VALID_USERNAME, Config.VALID_PASSWORD);

        log.info("Step 2: Navigate to Create Customer page");
        customerListView.clickNewCustomerButton();

        // T.1. Name Field: Enabled & Blank by default
        log.info("T.1: Verify Name field is enabled & blank by default");
        softAssert.assertTrue(createCustomerPage.isNameFieldEmpty(), "Name field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isNameFieldEnabled(), "Name field is NOT enabled.");

        // T.2. Email Field: Enabled & Blank by default
        log.info("T.2: Verify Email field is enabled & blank by default");
        softAssert.assertTrue(createCustomerPage.isEmailFieldEmpty(), "Email field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isEmailFieldEnabled(), "Email field is NOT enabled.");

        // T.3. Phone Field: Enabled & Blank by default
        log.info("T.3: Verify Phone field is enabled & blank by default");
        softAssert.assertTrue(createCustomerPage.isPhoneFieldEmpty(), "Phone field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isPhoneFieldEnabled(), "Phone field is NOT enabled.");

        // T.4. Address Field: Enabled & Blank by default
        log.info("T.4: Verify Address field is enabled & blank by default");
        softAssert.assertTrue(createCustomerPage.isAddressFieldEmpty(), "Address field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isAddressFieldEnabled(), "Address field is NOT enabled.");

        // T.5 "Create a Customer" button is enabled
        log.info("T.5: Verify 'Create a Customer' button is enabled");
        softAssert.assertTrue(createCustomerPage.isCreateCustomerButtonEnabled(), "'Create a Customer' button is NOT enabled.");

        log.info("Step 3: Assert all validations");
        softAssert.assertAll();

        System.out.println("Passed");
    }
}

