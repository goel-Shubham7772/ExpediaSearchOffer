package com.expedia.model.response;

import lombok.Data;

@Data
public class PackageOffer {
    private OfferDateRange offerDateRange;
    private Destination destination;
    private HotelInfo hotelInfo;
    private HotelPricingInfo hotelPricingInfo;
    private FlightInfo flightInfo;
    private FlightPricingInfo flightPricingInfo;
    private PackageInfo packageInfo;
    private PackagePricingInfo packagePricingInfo;
    private PackageUrls packageUrls;
    private Origin origin;
}
