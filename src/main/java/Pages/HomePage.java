package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By campaignsLocator = By.className("fa-university");
    private final By showAllCampaign = By.linkText("Show All Campaigns");
    private final By createCampaign = By.linkText("Create Campaign");
    private final By listCampaign = By.linkText("Show All Campaign Types");
    private final By campaignType = By.linkText("Create Campaign Type");

    private final By NewCampaignButton = By.linkText("New Campaign");

    @Step("Click Campaign")
    public void clickCampaigns() {
        click(campaignsLocator);
    }

    @Step("Open Show All Campaign Page")
    public void clickShowAllCampaign() {
        click(showAllCampaign);
    }

    @Step("Open Create Campaign Page")
    public void clickCreateCampaign() {
        click(createCampaign);
    }

    @Step("Open Show All Campaign Type Page")
    public void clickShowAllCampaignType() {
        click(listCampaign);
    }

    @Step("Open Create Campaign Type Page")
    public void clickCreateCampaignType() {
        click(campaignType);
    }

    @Step("Open Create Campaign Page")
    public void openCreateCampaignPage() {
        click(NewCampaignButton);
    }
}
