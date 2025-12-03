package PageTest;

import TestBase.TestBase;
import Pages.CreateCampaignPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShowAllCampaignPage;
import Utils.Config;
import data.campaignData;
import io.qameta.allure.Allure;
import models.Campaign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_008 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_008.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ShowAllCampaignPage showAllCamPaignPage = new ShowAllCampaignPage();
    CreateCampaignPage createCampaignPage = new CreateCampaignPage();
    Campaign campaign = campaignData.generateCampaign();

    @Test (description = "Test 08: Verify users creates Campaign successfully")
    public void Test08() {

        log.info("Step 1: Logging in with valid username and password");
        loginPage.login(Config.VALID_USERNAME, Config.VALID_PASSWORD);

        log.info("Step 2: Click Campaign");
        homePage.clickCampaigns();

        log.info("Step 3: Click Show All Campaign");
        homePage.clickShowAllCampaign();

        log.info("Step 4: Open Create Campaign Page");
        showAllCamPaignPage.openCreateCampaignPage();

        log.info("Step 5: Create Campaign");
        createCampaignPage.fillForm(campaign);
        createCampaignPage.clickCreate();

        log.info("Step 6: Filter Campaign Name");
        showAllCamPaignPage.filterCampaignName(campaign);

        log.info("Step 7: Assert Campaign name matches");
        Allure.step("Verify the newly created campaign is displayed correctly");
        Assert.assertEquals(showAllCamPaignPage.getFirstCampaignName(), campaign.getCampaignData());
     }

}
