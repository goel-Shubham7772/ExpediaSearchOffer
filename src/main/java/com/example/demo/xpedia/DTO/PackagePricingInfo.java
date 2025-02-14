package com.example.demo.xpedia.DTO;

import lombok.Data;

@Data
public class PackagePricingInfo {
    private String currencyCode;
    private double perPsgrPackagePrice;
    private double totalPackagePrice;
    private double perPsgrSavings;
    private double totalSavings;
    private int percentSavings;
}
