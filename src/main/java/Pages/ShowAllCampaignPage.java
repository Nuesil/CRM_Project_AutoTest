package Pages;

import models.Campaign;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class ShowAllCampaignPage extends BasePage {

    private final By filterCampaignName = By.id("j_idt72:j_idt73:j_idt74:filter");
    private final By listCampaign = By.id("j_idt72:j_idt73_data");
    private final By firstColumnCells = By.xpath("//tbody[@id='j_idt72:j_idt73_data']//tr[1]/td");
    private final By NewCampaignButton = By.cssSelector("a[href='/CRMweb/faces/createCampaign.xhtml']");

    public void openCreateCampaignPage() {
        click(NewCampaignButton);
    }

    public void filterCampaignName(Campaign campaign) {
        type(filterCampaignName,campaign.getCampaignName());
    }

    public List<String> getFirstCampaignName(Campaign campaign) {
        waitForTextToBePresent(firstColumnCells, campaign.getCampaignName());
        return getTextInList(firstColumnCells)
                .stream()
                .map(text -> text.replaceAll("\\s*Edit.*", "").trim())
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public String getFirstCampaignAsString(Campaign campaign) {
        List<String> campaignData = getFirstCampaignName(campaign);
        return String.join(" ", campaignData);
    }


    public String getListCampaignDataString(Campaign campaign) {
        List<String> campaignData = Campaign.getListCampaignData(campaign);
        return String.join(" ",campaignData);
    }


//
//    private By editLocator(Integer id) {
//        return By.cssSelector(String.format("a[href='/CRMweb/faces/editCampaign.xhtml?id=%d']", id));
//    }
//
//    public void clickEditCampaign(Integer id) {
//        By getId = editLocator(id);
//        click(getId);
//    }



}

