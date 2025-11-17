package Pages;

import org.openqa.selenium.By;
import Utils.Driver;

public class CustomerListView {
    private final By newCustomerButtonLocator = By.xpath("//a[@class='btn btn-primary']");

    public void clickOnNewCustomerButton() {
        Driver.WEB_DRIVER.findElement(newCustomerButtonLocator).click();
    }
}
