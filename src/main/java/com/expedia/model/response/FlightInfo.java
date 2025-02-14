package com.expedia.model.response;

import lombok.Data;

@Data
public class FlightInfo {
    private String flightDealCarrier;
    private String flightDealCarrierName;
    private int lengthOfStay;
    private String flightDealCarrierImageUrl;
    private String tripType;
}
