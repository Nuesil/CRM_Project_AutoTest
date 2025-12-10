package PageTest;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import Utils.FakerData;
import models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_004 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_004.class);
    //1. Login to the system
    LoginPage loginPage = new LoginPage();

    //2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();

    //3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer createCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();
    Customer randomCustomer = FakerData.generateRandomCustomer();

    @Test
    public void verifyValidationEmailFieldWorking() {
        log.info("Step 1: Logging in with valid username and password");
        loginPage.login("vyvanviet@gmail.com", "abc123");

        log.info("Step 2: Navigate to Create New Customer page");
        customerListView.clickNewCustomerButton();

        log.info("Step 3: Input invalid phone number into the Phone field");
        randomCustomer.setPhone("098a778543");
        createCustomerPage.createNewCustomer(randomCustomer);

        log.info("Step 4: Verify error message for invalid phone number");
        softAssert.assertEquals(createCustomerPage.getPhoneErrorMessage(), "Only numbers 0-9");

        log.info("Step 5: Assert all soft assertions");
        softAssert.assertAll();

        System.out.println("Passed");
    }
}
