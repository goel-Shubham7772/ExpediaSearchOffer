package com.expedia.model.response;

import lombok.Data;

@Data
public class HotelInfo {
    private String hotelId;
    private String hotelName;
    private String localizedHotelName;
    private String hotelDestination;
    private String hotelDestinationRegionID;
    private String hotelLongDestination;
    private String hotelStreetAddress;
    private String hotelCity;
    private String hotelProvince;
    private String hotelCountryCode;
    private double hotelLatitude;
    private double hotelLongitude;
    private String hotelStarRating;
    private double hotelGuestReviewRating;
    private int hotelReviewTotal;
    private String hotelImageUrl;
    private String bigHotelImageUrl;
}
