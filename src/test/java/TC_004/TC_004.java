package TC_004;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import Utils.FakerData;
import models.Customer;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_004 extends TestBase {
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
        loginPage.login("vyvanviet@gmail.com", "abc123");
        customerListView.clickNewCustomerButton();
        randomCustomer.setPhone("098a778543");
        createCustomerPage.createNewCustomer(randomCustomer);

        softAssert.assertEquals(createCustomerPage.getPhoneErrorMessage(), "Only numbers 0-9");
        softAssert.assertAll();

        System.out.println("Passed");
    }
}
