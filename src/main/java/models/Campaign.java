package models;
import lombok.Data;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
public class Campaign {

    private String campaignTypeName;
    private String campaignName;
    private String type;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String expectedRevenue;
    private String budgetedCost;
    private String actualCost;
    private String description;



    public String getListCampaignTypeData(Campaign campaign) { //move
        return campaign.getCampaignTypeName();
    }


    public static List<String> getListCampaignData(Campaign campaign) {   // Campaign Class
        List<String> data = new ArrayList<>();
        data.add(campaign.getCampaignName());
        data.add(campaign.getType());
        data.add(campaign.getStatus());
        data.add(String.valueOf(campaign.getStartDate()));
        data.add(String.valueOf(campaign.getEndDate()));
        return data;
    }

}

