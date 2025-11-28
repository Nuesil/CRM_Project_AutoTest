package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

//    public static WebDriver WEB_DRIVER;
//    public static WebDriverWait WEB_DRIVER_WAIT;

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
