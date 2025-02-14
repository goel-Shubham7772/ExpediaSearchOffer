package com.example.demo.xpedia.DTO;

import lombok.Data;

@Data
public class FlightPricingInfo {
    private String currencyCode;
    private double flightTotalBaseFare;
    private double flightTotalTax;
    private double flightTotalPrice;
    private double flightPerPsgrBaseFare;
    private double flightPerPsgrTax;
}
