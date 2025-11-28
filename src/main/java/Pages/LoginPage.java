package Pages;

import Utils.Driver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    // Customer Attribute: Locator
    private final By emailFieldLocator = By.id("campaigntypeform:email");
    private final By passwordFieldLocator = By.id("campaigntypeform:pass");
    private final By loginButtonLocator = By.name("campaigntypeform:j_idt14");

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }

    public void enterEmail(String email) {
        Driver.getWebDriver().findElement(emailFieldLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        Driver.getWebDriver().findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickOnLoginButton() {
        Driver.getWebDriver().findElement(loginButtonLocator).click();
    }
}
