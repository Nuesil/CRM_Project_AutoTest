package Pages;

import models.Campaign;
import org.openqa.selenium.By;

public class ShowAllCampaignType extends BasePage {

    private final By newCampaignType = By.linkText("New Campagin Type");
    private final By campaignTypeNameFilter = By.id("formcampaigntype:j_idt72:j_idt73:filter");
    private final By listCampaignType = By.id("formcampaigntype:j_idt72_data");
    private final By firstColumnCells = By.xpath("//tbody[@id='formcampaigntype:j_idt72_data']//tr/td[1]");
    private final By IdEditLocator = By.xpath("//tbody[@id='formcampaigntype:j_idt72_data']//tr/td[2]/a");
    private final By deleteLocator = By.cssSelector("input[type='submit']");



    public void filterCampaignTypeName(Campaign campaign) {
        type(campaignTypeNameFilter, campaign.getCampaignTypeName());
    }

    public String getCampaignTypeNameText(Campaign campaign) {
        waitForTextToBePresent(firstColumnCells, campaign.getCampaignTypeName());
        return getText(firstColumnCells);
    }


    public void openCreateCampaignType() {
        click(newCampaignType);
    }



    public void clickEditCampaignType() {
        click(IdEditLocator);
    }


    public void delete() {
        click(deleteLocator);
    }



}
