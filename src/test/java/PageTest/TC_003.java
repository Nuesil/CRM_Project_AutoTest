package PageTest;

import Pages.CreateNewCustomer;
import Pages.CustomerListView;
import Pages.LoginPage;
import TestBase.TestBase;
import Utils.Config;
import Utils.FakerData;
import models.Customer;
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

    Customer randomCustomer = FakerData.generateRandomCustomer();

    @Test
    public void verifyValidationEmailFieldWorking() {
        loginPage.login(Config.VALID_USERNAME, Config.VALID_PASSWORD);
        customerListView.clickNewCustomerButton();

        randomCustomer.setEmail("an.hoang");
        createCustomerPage.createNewCustomer(randomCustomer);

        softAssert.assertEquals(createCustomerPage.getEmailErrorMessage(), "The email is not valid (ex: abc@abc)");
        softAssert.assertAll();

        System.out.println("Passed");
    }
}
