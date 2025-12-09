package TestBase;

import Utils.Driver;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--guest"});
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        Driver.setDrivers(new ChromeDriver(options));
        Driver.getWebDriver().get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(5000));
    }

    @AfterMethod
    public void cleanUp() {
        Driver.getWebDriver().close();
    }
}
