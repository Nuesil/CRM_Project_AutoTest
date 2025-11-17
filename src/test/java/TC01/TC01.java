package TC01;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import TestBase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01 extends TestBase {

    @Test
    public void verifyCreateCustomerPageElements() {
        // 1. Navigate to "Create Customer" page
        CustomerListView customerListView = new CustomerListView();
        customerListView.clickOnNewCustomerButton();

        // 2. Initialize Page Object for CreateNewCustomer
        CreateNewCustomer createCustomerPage = new CreateNewCustomer();

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Verify 'Create Customer' page is displayed");

        System.out.println("Verify all fields are Enabled & Blank by default");

        // 3.1. Name Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isNameFieldEmpty(), "Name field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isNameFieldEnabled(), "Name field is NOT enabled.");

        // 3.2. Email Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isEmailFieldEmpty(), "Email field is NOT empty.");
        softAssert.assertTrue(createCustomerPage.isEmailFieldEnabled(), "Email field is NOT enabled.");

        // 3.3. Phone Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isPhoneFieldEmpty(), "Phone field is NOT empty.");
        softAssert.assertEquals(createCustomerPage.isEmailFieldEnabled(), "Phone field is NOT enabled.");

        // 3.4. Address Field: Enabled & Blank by default
        softAssert.assertTrue(createCustomerPage.isAddressFieldEmpty(), "Address field is NOT empty.");
        softAssert.assertEquals(createCustomerPage.isAddressFieldEnabled(), "Address field is NOT enabled.");

        // 3.5 "Create a Customer" button is enabled
        softAssert.assertTrue(createCustomerPage.isCreateCustomerButtonClickable(), "'Create a Customer' button is NOT enabled.");

        softAssert.assertAll();

        System.out.println("Passed");
    }
}

