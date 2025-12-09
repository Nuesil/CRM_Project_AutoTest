package Pages;

import io.qameta.allure.Step;
import models.Campaign;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.Arrays;
import java.util.List;

public class CreateCampaignPage extends BasePage {

    private final By pageTitle = By.xpath("//h2[text()='Create Campaign']");
    private final By campaignNameLocator = By.id("j_idt70:cn");    // ByChained ( By.
    private final By typeLocator = By.name("j_idt70:j_idt74");
    private final By statusLocator = By.name("j_idt70:j_idt77");
    private final By startDateLocator = By.id("j_idt70:sd");
    private final By endDateLocator = By.id("j_idt70:ed");
    private final By revenueLocator = By.id("j_idt70:er");
    private final By budgetLocator = By.id("j_idt70:bc");
    private final By actualCostLocator = By.id("j_idt70:ac");
    private final By desLocator = By.id("j_idt70:de");
    private final By createLocator = By.name("j_idt70:j_idt93");
    private final By getDesError = By.xpath("//textarea[@id='j_idt70:de']/preceding-sibling::span");

    private By getErrorMessage(By locator) {
        return new ByChained(locator, By.xpath("preceding-sibling::span"));
    }

    public List<String> getActualErrorMessages() {
        return Arrays.asList(
                getText(getErrorMessage(campaignNameLocator)),
                getText(getErrorMessage(startDateLocator)),
                getText(getErrorMessage(endDateLocator)),
                getText(getErrorMessage(revenueLocator)),
                getText(getErrorMessage(budgetLocator)),
                getText(getErrorMessage(actualCostLocator)),
                getText(getDesError)
        );
    }

    @Step("Fill form")
    public void fillForm(Campaign campaign) {
        type(campaignNameLocator, campaign.getCampaignName());
        type(typeLocator, campaign.getType());
        type(statusLocator, campaign.getStatus());
        type(startDateLocator, String.valueOf(campaign.getStartDate()));
        type(endDateLocator, String.valueOf(campaign.getEndDate()));
        type(revenueLocator, String.valueOf(campaign.getExpectedRevenue()));
        type(budgetLocator, String.valueOf(campaign.getBudgetedCost()));
        type(actualCostLocator, String.valueOf(campaign.getActualCost()));
        type(desLocator, campaign.getDescription());

    }

    @Step ("Click Create")
    public void clickCreate() {
        click(createLocator);
    }

    @Step("Get Title")
    public String getTitle() {
        return getText(pageTitle);
    }

}
