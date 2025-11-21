package Pages;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewCustomer {
    private final By nameFieldLocator = By.name("j_idt70:name");
    private final By emailFieldLocator = By.name("j_idt70:email");
    private final By phoneFieldLocator = By.name("j_idt70:phone");
    private final By addressFieldLocator = By.name("j_idt70:address");
    private final By createCustomerButtonLocator = By.name("j_idt70:j_idt80");
    private final By errorEmailMessageLocator = By.xpath("//input[@id='j_idt70:email']/preceding-sibling::span");

    private WebElement getElement(By locator) {
        return Driver.WEB_DRIVER.findElement(locator);
    }

    //1. Name field is BLANK & ENABLED
    public boolean isNameFieldEmpty() {
        return Driver.WEB_DRIVER.findElement(nameFieldLocator).getText().isEmpty();
    }

    public boolean isNameFieldEnabled() {
        return Driver.WEB_DRIVER.findElement(nameFieldLocator).isEnabled();
    }

    //2. Customer Email field is BLANK & ENABLED
    public boolean isEmailFieldEmpty() {
        return Driver.WEB_DRIVER.findElement(emailFieldLocator).getText().isEmpty();
    }

    public boolean isEmailFieldEnabled() {
        return Driver.WEB_DRIVER.findElement(emailFieldLocator).isEnabled();
    }

    //3. Phone field is BLANK & ENABLED
    public boolean isPhoneFieldEmpty() {
        return Driver.WEB_DRIVER.findElement(phoneFieldLocator).getText().isEmpty();
    }

    public boolean isPhoneFieldEnabled() {
        return Driver.WEB_DRIVER.findElement(phoneFieldLocator).isEnabled();
    }

    //4. Address field is BLANK & ENABLED
    public boolean isAddressFieldEmpty() {
        return Driver.WEB_DRIVER.findElement(addressFieldLocator).getText().isEmpty();
    }

    public boolean isAddressFieldEnabled() {
        return Driver.WEB_DRIVER.findElement(addressFieldLocator).isEnabled();
    }

    //5. Create Customer button is ENABLED
    public boolean isCreateCustomerButtonEnabled() {
        return Driver.WEB_DRIVER.findElement(createCustomerButtonLocator).isEnabled();
    }

    public void createNewCustomer(String name, String email, String phone, String address) {
        enterName(name);
        enterEmail(email);
        enterPhone(phone);
        enterAddress(address);
        clickCreateCustomerButton();
    }

    public void enterName(String name) {
        Driver.WEB_DRIVER.findElement(nameFieldLocator).sendKeys(name);
    }

    public void enterEmail(String emailCustomer) {
        Driver.WEB_DRIVER.findElement(emailFieldLocator).sendKeys(emailCustomer);
    }

    public void enterPhone(String phone) {
        Driver.WEB_DRIVER.findElement(phoneFieldLocator).sendKeys(phone);
    }

    public void enterAddress(String address) {
        Driver.WEB_DRIVER.findElement(addressFieldLocator).sendKeys(address);
    }

    public void clickCreateCustomerButton() {
        Driver.WEB_DRIVER.findElement(createCustomerButtonLocator).click();
    }

    public String getEmailErrorMessage() {
        return Driver.WEB_DRIVER.findElement(errorEmailMessageLocator).getText();
    }
}
