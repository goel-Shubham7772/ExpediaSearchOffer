package com.example.demo.xpedia.DTO;

import lombok.Data;

@Data
public class HotelPricingInfo {
    private double hotelPerPsgrBaseRate;
    private double hotelPerPsgrTaxesAndFees;
    private double hotelPerPsgrTotalRate;
    private double hotelTotalBaseRate;
    private double hotelTotalTaxesAndFees;
    private double hotelTotalRate;
    private String currency;
}
