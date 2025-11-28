package PageTest;

import TestBase.TestBase;
import Pages.CreateCampaignTypePage;
import Pages.EditCampaignType;
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

public class TC_010 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_010.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    ShowAllCampaignType showAllCampaignType = new ShowAllCampaignType();
    CreateCampaignTypePage createCampaignTypePage = new CreateCampaignTypePage();
    EditCampaignType editCampaignType = new EditCampaignType();
    Campaign campaign = campaignData.generateCampaign();
    Campaign newcampaign = campaignData.generateCampaign();

    @Test(description = "Test 10: Verify users edit Campaign Type successfully")
    public void Test10() throws InterruptedException {


        log.info("Step 1: Logging in with valid username and password");
        loginPage.login(Config.VALID_USERNAME, Config.VALID_PASSWORD);

        log.info("Step 2: Click on Campaigns in homepage");
        homePage.clickCampaigns();

        log.info("Step 3: Click Create Campaign Type");
        homePage.clickCreateCampaignType();

        log.info("Step 4: Enter campaign type name");
        createCampaignTypePage.enterCampaignTypeName(campaign);


        log.info("Step 6: Filter campaign type name");
        showAllCampaignType.filterCampaignTypeName(campaign);

        log.info("Step 7: Click Edit Campaign Type Name");
        showAllCampaignType.clickEditCampaignType();

        log.info("Step 8 : Edit Campaign Type name");
        editCampaignType.enterCampaignTypeName(newcampaign);


        log.info("Step 10: Filter campaign type name after edit");
        showAllCampaignType.filterCampaignTypeName(newcampaign);

        log.info("Step 11: Assert campaign name matches");
        Assert.assertEquals(newcampaign.getCampaignTypeData(), showAllCampaignType.getCampaignTypeNameText());
    }
}
