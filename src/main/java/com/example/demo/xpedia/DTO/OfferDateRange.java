package com.example.demo.xpedia.DTO;

import lombok.Data;
import java.util.List;

@Data
public class OfferDateRange {
    private List<Integer> travelStartDate;
    private List<Integer> travelEndDate;
    private String formattedTravelStartDate;
    private String formattedTravelEndDate;
    private int lengthOfStay;
}
