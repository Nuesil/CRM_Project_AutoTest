package Pages;

import io.qameta.allure.Step;
import models.Campaign;
import org.openqa.selenium.By;

import java.util.List;

public class ShowAllCampaignType extends BasePage {

    private final By newCampaignType = By.linkText("New Campagin Type");
    private final By campaignTypeNameFilter = By.id("formcampaigntype:j_idt72:j_idt73:filter");
    private final By listCampaignType = By.id("formcampaigntype:j_idt72_data");
    private final By firstColumnCells = By.xpath("//tbody[@id='formcampaigntype:j_idt72_data']//tr/td[1]");  // todo: name fix
    private final By IdEditLocator = By.xpath("//tbody[@id='formcampaigntype:j_idt72_data']//tr/td[2]/a");
    private final By deleteLocator = By.cssSelector("input[type='submit']");

    @Step("Filter Campaign Type Name")
    public void filterCampaignTypeName(Campaign campaign) {
        type(campaignTypeNameFilter, campaign.getCampaignTypeName());
        waitForTextToBePresent(firstColumnCells, campaign.getCampaignTypeName());
    }

    public String getCampaignTypeNameText() {
        return getText(firstColumnCells);
    }

    @Step("Open Create Campaign Type Page")
    public void openCreateCampaignType() {
        click(newCampaignType);
    }

    @Step("Edit Campaign Type")
    public void clickEditCampaignType() {
        click(IdEditLocator);
    }

}
