package Pages;

import org.openqa.selenium.By;
import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerListView {
    private final By newCustomerButtonLocator = By.xpath("//a[@class='btn btn-primary']");
    private final By customerMenuLocator = By.xpath("//span[@class='nav-label' and normalize-space()='Customer']");
    private final By createCustomerMenuLocator = By.xpath("//a[normalize-space()='Create Customer']");
    private final By filterNameLocator = By.id("j_idt71:tbl:j_idt72:filter");
    private final By filterEmailLocator = By.id("j_idt71:tbl:j_idt75:filter");
    private final By filterAddressLocator = By.id("j_idt71:tbl:j_idt78:filter");
    private final By filterPhoneLocator = By.id("j_idt71:tbl:j_idt81:filter");
    private final By noRecordFoundLocator = By.xpath("//table/tbody/tr[contains(@class, 'ui-widget-content ui-datatable-empty-message')]");
    private final By nameTitleTableLocator = By.xpath("//table/thead/tr/th/span[contains(@class,'ui-column-title')]");

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
    public void enterNameField(String name) {
        Driver.WEB_DRIVER.findElement(filterNameLocator).sendKeys(name);
    }
    public void enterEmailField(String email) {
        Driver.WEB_DRIVER.findElement(filterEmailLocator).sendKeys(email);
    }
    public void enterAddressField(String address) {
        Driver.WEB_DRIVER.findElement(filterAddressLocator).sendKeys(address);
    }
    public void enterPhoneField(String phone) {
        Driver.WEB_DRIVER.findElement(filterPhoneLocator).sendKeys(phone);
    }
    public String getNoRecordFound() {
        return Driver.WEB_DRIVER.findElement(noRecordFoundLocator).getText();
    }

    private String searchCustomerResult(String columnName, int compareRow) {
        List<WebElement> columns = Driver.getWebDriver().findElements(nameTitleTableLocator);

        List<String> columnTexts = columns.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        int colIdx = columnTexts.indexOf(columnName.trim());

        if (colIdx == -1) {
            throw new RuntimeException(
                    "Column not found: " + columnName + " | Headers = " + columnTexts
            );
        }

        // +1 vì XPath index bắt đầu từ 1
        colIdx = colIdx + 1;

        Driver.WEB_DRIVER_WAIT.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]"))
        );

        String cellXpath = "//table/tbody/tr[" + compareRow + "]/td[" + colIdx + "]";
        WebElement cell = Driver.getWebDriver().findElement(By.xpath(cellXpath));

        return cell.getText().trim();
    }

    public String getValueName() {
        return searchCustomerResult("Name", 1);
    }

    public String getValueEmail() {
        return searchCustomerResult("Email", 1);
    }

    public String getValueAdd() {
        return searchCustomerResult("Address", 1);
    }

    public String getValuePhone() {
        return searchCustomerResult("Phone", 1);
    }
}
