package Pages;

import models.Campaign;
import org.openqa.selenium.By;

public class EditCampaignType extends BasePage {

    private final By campaignTypeName = By.id("editformcampaigntype:ctn");


    public void enterCampaignTypeName(Campaign campaign) {
        clear(campaignTypeName);
        type(campaignTypeName, campaign.getCampaignTypeName());
    }
}
