package Pages;

import org.openqa.selenium.By;
import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerListView {
    private final By newCustomerButtonLocator = By.xpath("//a[@class='btn btn-primary']");
    private final By customerMenuLocator = By.xpath("//span[@class='nav-label' and normalize-space()='Customer']");
    private final By createCustomerMenuLocator = By.xpath("//a[normalize-space()='Create Customer']");

    public void clickNewCustomerButton() {
        Driver.WEB_DRIVER.findElement(newCustomerButtonLocator).click();
    }
    public void clickCustomerMenu() {
        Driver.WEB_DRIVER.findElement(customerMenuLocator).click();
    }
    public void clickCreateCustomerMenu() {
        Driver.WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(createCustomerMenuLocator));
        Driver.WEB_DRIVER.findElement(createCustomerMenuLocator).click();
    }
}
