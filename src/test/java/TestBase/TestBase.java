package TestBase;

import Pages.Login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.Driver;

import java.time.Duration;

public class TestBase {
    @BeforeMethod
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        Driver.WEB_DRIVER = new ChromeDriver(options);
        Driver.WEB_DRIVER.manage().window().maximize();
        Driver.WEB_DRIVER.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");

        Driver.WEB_DRIVER_WAIT = new WebDriverWait(Driver.WEB_DRIVER, Duration.ofSeconds(3));
    }

    @AfterMethod
    public void cleanUp() {
        Driver.WEB_DRIVER.close();
    }
}
