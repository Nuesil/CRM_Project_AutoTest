package Pages;

import io.qameta.allure.Step;
import models.Campaign;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class ShowAllCampaignPage extends BasePage {

    private final By filterCampaignName = By.id("j_idt72:j_idt73:j_idt74:filter");
    private final By listCampaign = By.id("j_idt72:j_idt73_data");
    private final By firstColumnCells = By.xpath("//tbody[@id='j_idt72:j_idt73_data']//tr[1]/td");
    private final By NewCampaignButton = By.cssSelector("a[href='/CRMweb/faces/createCampaign.xhtml']");

    @Step("Open Create Campaign Page")
    public void openCreateCampaignPage() {
        click(NewCampaignButton);
    }

    @Step("Filter Campaign Name")
    public void filterCampaignName(Campaign campaign) {
        type(filterCampaignName,campaign.getCampaignName());
        waitForTextToBePresent(firstColumnCells, campaign.getCampaignName());
    }

    public List<String> getFirstCampaignName() {
        return getTextInList(firstColumnCells)
                .stream()
                .map(text -> text.replaceAll("\\s*Edit.*", "").trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

}

