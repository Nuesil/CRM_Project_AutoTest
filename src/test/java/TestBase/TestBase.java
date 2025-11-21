package TestBase;

import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utils.Driver;

public class TestBase {

    @BeforeMethod
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guests");
        Driver.WEB_DRIVER = new ChromeDriver(options);
        Driver.WEB_DRIVER.manage().window().maximize();
        Driver.WEB_DRIVER.get("http://14.176.232.213:8080/CRMweb/faces/login.xhtml");
        LoginPage loginPage = new LoginPage();
        loginPage.login("vyvanviet@gmail.com", "abc123");
    }

    @AfterMethod
    public void cleanUp() {
        Driver.WEB_DRIVER.close();
    }
}
