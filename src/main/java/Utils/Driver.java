package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {
    public static WebDriver WEB_DRIVER;



    public static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void setDrivers(WebDriver driver) {
        drivers.set(driver);
    }

    public static WebDriver getWebDriver() {
        return drivers.get();
    }

    public static WebDriverWait getWebdriverWait() {
        return new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }
}
