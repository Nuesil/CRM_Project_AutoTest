package Pages;

import Utils.Driver;
import models.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerListView extends BasePage {
    private final By newCustomerButtonLocator = By.linkText("New Customer");
    private final By customerMenuLocator = By.xpath("//span[@class='nav-label' and normalize-space()='Customer']");
    private final By createCustomerMenuLocator = By.xpath("//a[normalize-space()='Create Customer']");
    private final By filterNameLocator = By.id("j_idt71:tbl:j_idt72:filter");
    private final By filterEmailLocator = By.id("j_idt71:tbl:j_idt75:filter");
    private final By filterAddressLocator = By.id("j_idt71:tbl:j_idt78:filter");
    private final By filterPhoneLocator = By.id("j_idt71:tbl:j_idt81:filter");
    private final By noRecordFoundLocator = By.xpath("//table/tbody/tr[contains(@class, 'ui-widget-content ui-datatable-empty-message')]");
    private final By nameTitleTableLocator = By.xpath("//table/thead/tr/th/span[contains(@class,'ui-column-title')]");
    private final By listRecordLocator = By.xpath("//table/tbody/tr");

    public void clickNewCustomerButton() {
//        Driver.WEB_DRIVER.findElement(newCustomerButtonLocator).click();
        click(newCustomerButtonLocator);
    }

    public void clickCustomerMenu() {
        Driver.getWebDriver().findElement(customerMenuLocator).click();
    }

    public void clickCreateCustomerMenu() {
        Driver.getWebdriverWait().until(ExpectedConditions.elementToBeClickable(createCustomerMenuLocator));
        Driver.getWebDriver().findElement(createCustomerMenuLocator).click();
    }

    public void filterByName(String name) {
        Driver.getWebDriver().findElement(filterNameLocator).sendKeys(name);
        Driver.getWebdriverWait().until(ExpectedConditions.stalenessOf(Driver.getWebDriver().findElement(By.id("j_idt71:tbl_data")).findElement(By.cssSelector("td"))));
    }

    public void enterEmailField(String email) {
        Driver.getWebDriver().findElement(filterEmailLocator).sendKeys(email);
    }

    public void enterAddressField(String address) {
        Driver.getWebDriver().findElement(filterAddressLocator).sendKeys(address);
    }

    public void enterPhoneField(String phone) {
        Driver.getWebDriver().findElement(filterPhoneLocator).sendKeys(phone);
    }

    public String getNoRecordFound() {
        return Driver.getWebDriver().findElement(noRecordFoundLocator).getText();
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

        Driver.getWebdriverWait().until(
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

    public String getValueAddress() {
        return searchCustomerResult("Address", 1);
    }

    public String getValuePhone() {
        return searchCustomerResult("Phone", 1);
    }

    public Customer getCustomer() {
//        List<WebElement> listRecord = Driver.getWebdriverWait().until(
//                ExpectedConditions.numberOfElementsToBe(listRecordLocator, 1)
//        );
//
//        // Optional safety check
//        if (listRecord.size() != 1) {
//            throw new RuntimeException("Expected exactly 1 customer record but found: " + listRecord.size());
//        }



        return new Customer(
                getValueName(),
                getValueEmail(),
                getValuePhone(),
                getValueAddress()
        );
    }
}
