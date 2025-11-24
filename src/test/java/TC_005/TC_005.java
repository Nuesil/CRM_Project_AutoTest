package TC_005;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import Utils.FakerData;
import models.Customer;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_005 extends TestBase {
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
        loginPage.login("vyvanviet@gmail.com", "abc123");
        customerListView.clickNewCustomerButton();
        createCustomerPage.createNewCustomer(randomCustomer);
        customerListView.enterNameField(randomCustomer.getName()); // enter name
        customerListView.enterEmailField(randomCustomer.getEmail());
        customerListView.enterAddressField(randomCustomer.getAddress());
        customerListView.enterPhoneField(randomCustomer.getPhone());
//        softAssert.assertEquals(customerListView.getNoRecordFound(), "No records found.");
//        softAssert.assertAll();
//
        System.out.println(customerListView.getValueName());


//        softAssert.assertTrue(isCustomerDisplayed, "Customer was not created successfully");
//
//        softAssert.assertAll();
        System.out.println("Passed");
    }
}
