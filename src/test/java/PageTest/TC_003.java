package PageTest;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import Utils.Config;
import Utils.FakerData;
import models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TC_003 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_003.class);
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
        loginPage.login(Config.VALID_USERNAME, Config.VALID_PASSWORD);

        log.info("Step 2: Open Create New Customer form");
        customerListView.clickNewCustomerButton();

        log.info("Step 3: Input invalid email into the Email field");
        randomCustomer.setEmail("an.hoang");
        createCustomerPage.createNewCustomer(randomCustomer);

        log.info("Step 4: Verify error message for invalid email");
        softAssert.assertEquals(createCustomerPage.getEmailErrorMessage(), "The email is not valid (ex: abc@abc)");

        log.info("Step 5: Assert all soft assertions");
        softAssert.assertAll();

        System.out.println("Passed");
    }
}
