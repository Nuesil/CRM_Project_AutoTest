//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package PageTest;

import TestBase.TestBase;
import Pages.CreateCampaignPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_006 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_006.class);
    LoginPage loginPage = new LoginPage();
    HomePage homepage = new HomePage();
    CreateCampaignPage createCampaignPage = new CreateCampaignPage();

    @Test(description = "Test 06: Verify “New Campaign” button navigates to Create Campaign page")
    public void Test06() {

        log.info("Step 1: Logging in with valid username and password");
        loginPage.Login(Config.VALID_USERNAME, Config.VALID_PASSWORD);

        log.info("Step 2: Click Campaign");
        homepage.clickCampaigns();

        log.info("Step 3: Click Show All Campaign");
        homepage.clickShowAllCampaign();

        log.info("Step 4: Open Create Campaign Page");
        homepage.openCreateCampaignPage();

        log.info("Step 5: Assert url matches");
        Assert.assertTrue(createCampaignPage.getTitle().contains("Create Campaign"), "Create Campaign is not displayed");

    }
}
