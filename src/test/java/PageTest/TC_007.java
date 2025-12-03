package PageTest;

import TestBase.TestBase;
import Pages.CreateCampaignPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.Config;
import data.TestData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_007 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_007.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    CreateCampaignPage createCampaignPage = new CreateCampaignPage();
    TestData testData = new TestData();

    @Test(description = "Test 007: Verify that campaign creation fails when the user leaves campaign Name blank")
    public void Test007() {

        log.info("Step 1: Logging in with valid username and password");
        loginPage.login(Config.VALID_USERNAME, Config.VALID_PASSWORD);

        log.info("Step 2: Click Campaign");
        homePage.clickCampaigns();

        log.info("Step 3: Click Show All Campaign");
        homePage.clickShowAllCampaign();

        log.info("Step 4: Open Create Campaign Page");
        homePage.openCreateCampaignPage();

        log.info("Step 5: Click Create");
        createCampaignPage.clickCreate();

        log.info("Step 5: Assert Error message matches");
        Assert.assertEquals(createCampaignPage.getActualErrorMessages(), testData.expectedErrorMessages, "Error message do not match");

        System.out.println(createCampaignPage.getActualErrorMessages());
    }
}
