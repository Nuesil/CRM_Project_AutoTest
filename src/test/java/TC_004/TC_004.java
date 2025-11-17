package TC_004;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.Login;
import TestBase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_004 extends TestBase {
    //1. Login to the system
    Login loginPage = new Login();

    //2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();

    //3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer createCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyValidationEmailFieldWorking() {
        loginPage.login("vyvanviet@gmail.com", "abc123");
        customerListView.clickCreateCustomerMenu();
        createCustomerPage.createNewCustomer("An Hoang", "thlien100595@gmail.com", "09080988tg", "75 Chu Van An, Da Nang");
    }
}
