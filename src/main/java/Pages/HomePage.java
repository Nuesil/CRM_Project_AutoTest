package Pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By campaignsLocator = By.className("fa-university");
    private final By showAllCampaign = By.linkText("Show All Campaigns");
    private final By createCampaign = By.linkText("Create Campaign");
    private final By listCampaign = By.linkText("Show All Campaign Types");
    private final By campaignType = By.linkText("Create Campaign Type");

    // Create Campaign button
    private final By NewCampaignButton = By.linkText("New Campaign");

    public void clickCampaigns() {
        click(campaignsLocator);
    }

    public void clickShowAllCampaign() {
        click(showAllCampaign);
    }

    public void clickCreateCampaign() {
        click(createCampaign);
    }

    public void clickShowAllCampaignType() {
        click(listCampaign);
    }

    public void clickCreateCampaignType() {
        click(campaignType);
    }

    public void openCreateCampaignPage() {
        click(NewCampaignButton);
    }
}
