package Pages;

import Utils.Driver;
import models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewCustomer extends BasePage {
    private final By nameFieldLocator = By.name("j_idt70:name");
    private final By emailFieldLocator = By.name("j_idt70:email");
    private final By phoneFieldLocator = By.name("j_idt70:phone");
    private final By addressFieldLocator = By.name("j_idt70:address");
    private final By createCustomerButtonLocator = By.name("j_idt70:j_idt80");
    private final By errorEmailMessageLocator = By.xpath("//input[@id='j_idt70:email']/preceding-sibling::span");
    private final By errorPhoneLocator = By.xpath("//input[@id='j_idt70:phone']/preceding-sibling::span");

    private WebElement getElement(By locator) {
        return Driver.getWebDriver().findElement(locator);
    }

    //1. Name field is BLANK & ENABLED
    public boolean isNameFieldEmpty() {
        return Driver.getWebDriver().findElement(nameFieldLocator).getText().isEmpty();

    }

    public boolean isNameFieldEnabled() {
        return Driver.getWebDriver().findElement(nameFieldLocator).isEnabled();
    }

    //2. Customer Email field is BLANK & ENABLED
    public boolean isEmailFieldEmpty() {
        return Driver.getWebDriver().findElement(emailFieldLocator).getText().isEmpty();
    }

    public boolean isEmailFieldEnabled() {
        return Driver.getWebDriver().findElement(emailFieldLocator).isEnabled();
    }

    //3. Phone field is BLANK & ENABLED
    public boolean isPhoneFieldEmpty() {
        return Driver.getWebDriver().findElement(phoneFieldLocator).getText().isEmpty();
    }

    public boolean isPhoneFieldEnabled() {
        return Driver.getWebDriver().findElement(phoneFieldLocator).isEnabled();
    }

    //4. Address field is BLANK & ENABLED
    public boolean isAddressFieldEmpty() {
        return Driver.getWebDriver().findElement(addressFieldLocator).getText().isEmpty();
    }

    public boolean isAddressFieldEnabled() {
        return Driver.getWebDriver().findElement(addressFieldLocator).isEnabled();
    }

    //5. Create Customer button is ENABLED
    public boolean isCreateCustomerButtonEnabled() {
        return Driver.getWebDriver().findElement(createCustomerButtonLocator).isEnabled();
    }

    public void createNewCustomer(Customer customer) {
        enterName(customer.getName());
        enterEmail(customer.getEmail());
        enterPhone(customer.getPhone());
        enterAddress(customer.getAddress());
        clickCreateCustomerButton();
    }

    public void fillForm(Customer customer) {
        type(nameFieldLocator, customer.getName());
        type(emailFieldLocator, customer.getEmail());
        type(phoneFieldLocator, customer.getPhone());
        type(addressFieldLocator, customer.getAddress());
    }

    public void enterName(String name) {
        Driver.getWebDriver().findElement(nameFieldLocator).sendKeys(name);
    }

    public void enterEmail(String emailCustomer) {
        Driver.getWebDriver().findElement(emailFieldLocator).sendKeys(emailCustomer);
    }

    public void enterPhone(String phone) {
        Driver.getWebDriver().findElement(phoneFieldLocator).sendKeys(phone);
    }

    public void enterAddress(String address) {
        Driver.getWebDriver().findElement(addressFieldLocator).sendKeys(address);

    }

    public void clickCreateCustomerButton() {
        Driver.getWebDriver().findElement(createCustomerButtonLocator).click();

    }

    public String getEmailErrorMessage() {
        return Driver.getWebDriver().findElement(errorEmailMessageLocator).getText();
    }

    public String getPhoneErrorMessage() {
        return Driver.getWebDriver().findElement(errorPhoneLocator).getText();
    }
}
