package Pages;

import models.Campaign;
import org.openqa.selenium.By;

public class CreateCampaignTypePage extends BasePage {


    private final By saveLocator = By.cssSelector("input[type='submit']");
    private final By campaignTypeName = By.id("campaigntypeform:ctn");

    public void save() {
        click(saveLocator);
    }

    public void enterCampaignTypeName(Campaign campaign) {
        type(campaignTypeName, campaign.getCampaignTypeName());
    }



}

