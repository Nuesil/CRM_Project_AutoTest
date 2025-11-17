package TC_002;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.Login;
import TestBase.TestBase;
import Utils.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC_002 extends TestBase {
    //1. Login to the system
    Login loginPage = new Login();
    //2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();
    //3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer newCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyNewCustomerMenuElements() {
        loginPage.login("vyvanviet@gmail.com", "abc123");
        customerListView.clickCustomerMenu();
        customerListView.clickCreateCustomerMenu();

        // 3.1. Name Field: Enabled & Blank by default
        softAssert.assertTrue(newCustomerPage.isNameFieldEmpty(), "Name field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isNameFieldEnabled(), "Name field is NOT enabled.");

        // 3.2. Email Field: Enabled & Blank by default
        softAssert.assertTrue(newCustomerPage.isEmailFieldEmpty(), "Email field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isEmailFieldEnabled(), "Email field is NOT enabled.");

        // 3.3. Phone Field: Enabled & Blank by default
        softAssert.assertTrue(newCustomerPage.isPhoneFieldEmpty(), "Phone field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isEmailFieldEnabled(), "Phone field is NOT enabled.");

        // 3.4. Address Field: Enabled & Blank by default
        softAssert.assertTrue(newCustomerPage.isAddressFieldEmpty(), "Address field is NOT empty.");
        softAssert.assertTrue(newCustomerPage.isAddressFieldEnabled(), "Address field is NOT enabled.");

        // 3.5 "Create a Customer" button is enabled
        softAssert.assertTrue(newCustomerPage.isCreateCustomerButtonEnabled(), "'Create a Customer' button is NOT enabled.");

        softAssert.assertAll();

        System.out.println("Passed");
    }
}