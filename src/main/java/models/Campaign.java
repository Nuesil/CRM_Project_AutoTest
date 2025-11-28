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



    public List<String> getCampaignTypeData() {
        List<String> data = new ArrayList<>();
        data.add(getCampaignTypeName());
        return data;
    }

    public List<String> getCampaignData() {
        List<String> data = new ArrayList<>();
        data.add(getCampaignName());
        data.add(getType());
        data.add(getStatus());
        data.add(String.valueOf(getStartDate()));
        data.add(String.valueOf(getEndDate()));
        return data;
    }




}

