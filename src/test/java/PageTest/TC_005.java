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

public class TC_005 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_005.class);
    //1. Login to the system
    LoginPage loginPage = new LoginPage();

    //2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();

    //3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer createCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();
    Customer randomCustomer = FakerData.generateRandomCustomer();

    @Test
    public void verifyCreateCustomerSuccessfully() {
        log.info("Step 1: Logging in with valid username and password");
        loginPage.login("vyvanviet@gmail.com", "abc123");

        log.info("Step 2: Navigate to Create Customer page");
        customerListView.clickNewCustomerButton();

        log.info("Step 3: Create new customer with valid data");
        createCustomerPage.createNewCustomer(randomCustomer);

        log.info("Step 4: Filter customer list by newly created customer's name");
        customerListView.filterByName(randomCustomer.getName());

        log.info("Step 5: Verify created customer is displayed in the list");
        softAssert.assertEquals(randomCustomer, customerListView.getCustomer());

        log.info("Step 6: Assert all validations");
        softAssert.assertAll();
        System.out.println("Passed");
    }
}
