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
    private Integer expectedRevenue;
    private Integer budgetedCost;
    private Integer actualCost;
    private String description;



    public String getListCampaignTypeData(Campaign campaign) { //move
        return campaign.getCampaignTypeName();
    }

//    public List<String> toList() {
//        List<String> data = new ArrayList<>();
//        data.add(getCampaignName());
//        data.add(getType());
//        data.add(getStatus());
//        data.add(String.valueOf(getStartDate()));
//        data.add(String.valueOf(getEndDate()));
//        return data;
//    }

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

