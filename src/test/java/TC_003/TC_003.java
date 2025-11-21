package TC_003;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import Utils.FakerData;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_003 extends TestBase {
    //1. Login to the system
    LoginPage loginPage = new LoginPage();
    //2. Navigate to "Create Customer" page
    CustomerListView customerListView = new CustomerListView();
    //3. Initialize Page Object for CreateNewCustomer
    CreateNewCustomer createCustomerPage = new CreateNewCustomer();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyValidationEmailFieldWorking() {
        loginPage.login("vyvanviet@gmail.com", "abc123");
        customerListView.clickNewCustomerButton();
        createCustomerPage.createNewCustomer("An Hoang", "an@hoang", "0908098898", "75 Chu Van An, Da Nang");

        softAssert.assertEquals(createCustomerPage.getEmailErrorMessage(), "The email is not valid (ex: abc@abc)");
        softAssert.assertAll();

        System.out.println("Passed");
    }
}
