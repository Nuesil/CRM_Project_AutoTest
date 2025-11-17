package Pages;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;


public class BasePage {

    // getter động driver()
    protected WebDriver driver() {
        return Driver.getWebDriver();
    }

    // getter động
    protected WebDriverWait getWait() {
        return Driver.getWebdriverWait();
    }

    protected void click(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected void clear(By locator) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

    protected String getText(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }


    protected List<String> getTextInList(By locator) {
        List<WebElement> elements = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    protected void waitForTextToBePresent(By locator, String expectedText) {
        getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }


    protected WebElement waitForLocatorToBePresent(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement find(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}

