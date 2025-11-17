package data;

import Utils.FakerData;
import models.Campaign;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class campaignData {


    public static Campaign generateCampaign() {
        Campaign campaign = new Campaign();
        campaign.setCampaignName("Sale" + FakerData.faker.commerce().department());
        campaign.setType(FakerData.faker.options().option("discount 10%", "discount 30%", "discount 60%"));
        campaign.setStatus(FakerData.faker.options().option("Done", "Yet"));
        campaign.setStartDate(LocalDate.now());
        campaign.setEndDate(LocalDate.now().plusDays(7));
        campaign.setExpectedRevenue(String.valueOf(FakerData.faker.number().numberBetween(1000,3000))); // kieu du lieu
        campaign.setActualCost(String.valueOf(FakerData.faker.number().numberBetween(1000,3000)));
        campaign.setDescription(FakerData.faker.lorem().sentence());
        campaign.setCampaignTypeName("discount" + FakerData.faker.number().numberBetween(1, 100) + "%");
        return campaign;
    }







}
