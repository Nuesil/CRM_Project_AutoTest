package Pages;

import io.qameta.allure.Step;
import models.Campaign;
import org.openqa.selenium.By;

public class CreateCampaignTypePage extends BasePage {


    private final By saveLocator = By.cssSelector("input[type='submit']");
    private final By campaignTypeName = By.id("campaigntypeform:ctn");

    @Step("Enter Campaign Type Name")
    public void enterCampaignTypeName(Campaign campaign) {
        type(campaignTypeName, campaign.getCampaignTypeName());
        click(saveLocator);
    }


}

