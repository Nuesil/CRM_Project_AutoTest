package Pages;

import io.qameta.allure.Step;
import models.Campaign;
import org.openqa.selenium.By;

public class EditCampaignType extends BasePage {

    private final By campaignTypeName = By.id("editformcampaigntype:ctn");
    private final By saveLocator = By.cssSelector("input[type='submit'");

    @Step("Enter Campaign Type name")
    public void enterCampaignTypeName(Campaign campaign) {
        clear(campaignTypeName);
        type(campaignTypeName, campaign.getCampaignTypeName());
        click(saveLocator);
    }
}
