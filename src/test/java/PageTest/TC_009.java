package PageTest;

import TestBase.TestBase;
import Pages.CreateCampaignTypePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ShowAllCampaignType;
import Utils.Config;
import data.campaignData;
import models.Campaign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_009 extends TestBase {
    public static final Logger log = LogManager.getLogger(TC_009.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ShowAllCampaignType showAllCampaignType = new ShowAllCampaignType();
    CreateCampaignTypePage createCampaignTypePage = new CreateCampaignTypePage();
    Campaign campaign = campaignData.generateCampaign();

    @Test(description = "Test 009: Verify users creates Campaign Type successfully")
    public void Test09() {

        log.info("Step 1: Logging in with valid username and password");
        loginPage.Login(Config.VALID_USERNAME, Config.VALID_PASSWORD);

        log.info("Step 2: Click Campaign");
        homePage.clickCampaigns();

        log.info("Step 3: Click Show All Campaign Type");
        homePage.clickShowAllCampaignType();

        log.info("Step 4: Click New Campaign Type");
        showAllCampaignType.openCreateCampaignType();

        log.info("Step 5: Enter Campaign Type Name");
        createCampaignTypePage.enterCampaignTypeName(campaign);

        log.info("Step 7: Filter Campaign Type Name");
        showAllCampaignType.filterCampaignTypeName(campaign);

        log.info("Step 8: Assert Campaign Name matches");
        Assert.assertEquals(showAllCampaignType.getCampaignTypeNameText(), campaign.getListCampaignTypeData(campaign));

    }
}
