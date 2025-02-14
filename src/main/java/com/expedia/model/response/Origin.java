package com.expedia.model.response;

import lombok.Data;

@Data
public class Origin {
    private String regionID;
    private String longName;
    private String country;
    private String province;
    private String city;
    private String tla;
}
