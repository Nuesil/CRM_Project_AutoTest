package TC_001;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.Login;
import TestBase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_001 extends TestBase {
    //1. Login to the system
    Login loginPage = new Login();
    // 2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();
    // 3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer createCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyCreateCustomerPageElements() {
        loginPage.login("vyvanviet@gmail.com", "abc123");
        customerListView.clickNewCustomerButton();

        // T.1. Name Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isNameFieldEmpty(), "Name field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isNameFieldEnabled(), "Name field is NOT enabled.");

        // T.2. Email Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isEmailFieldEmpty(), "Email field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isEmailFieldEnabled(), "Email field is NOT enabled.");

        // T.3. Phone Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isPhoneFieldEmpty(), "Phone field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isPhoneFieldEnabled(), "Phone field is NOT enabled.");

        // T.4. Address Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isAddressFieldEmpty(), "Address field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isAddressFieldEnabled(), "Address field is NOT enabled.");

        // T.5 "Create a Customer" button is enabled
        softAssert.assertTrue(createCustomerPage.isCreateCustomerButtonEnabled(), "'Create a Customer' button is NOT enabled.");

        softAssert.assertAll();

        System.out.println("Passed");
    }
}

