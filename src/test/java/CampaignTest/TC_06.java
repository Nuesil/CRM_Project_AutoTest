//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package PageTest;

import Base.TestBase;
import Pages.CreateCampaignPage;
import Pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_06 extends TestBase {
    private static final Logger log = LogManager.getLogger(TC_06.class);
    Login login = new Login();
    HomePage homePage = new HomePage();
    CreateCampaignPage createCampaignPage = new CreateCampaignPage();

    @Test
    public void Test06() {
        log.info("Verify “New Campaign” button navigates to Create Campaign page");
        log.info("Step 1: Logging in with valid username and password");
        this.login.Login("vyvanviet@gmail.com", "abc123");
        log.info("Step 2: Click Campaign");
        this.homePage.clickCampaigns();
        log.info("Step 3: Click Show All Campaign");
        this.homePage.clickShowAllCampaign();
        log.info("Step 4: Open Create Campaign Page");
        this.homePage.openCreateCampaignPage();
        log.info("Step 5: Assert url matches");
        Assert.assertTrue(this.createCampaignPage.getTitle().contains("Create Campaign"), "Create Campaign is not displayed");
    }
}
