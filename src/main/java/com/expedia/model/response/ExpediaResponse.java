package com.expedia.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpediaResponse {
    private OfferInfo offerInfo;
    private UserInfo userInfo;
    private DebugInfo debugInfo;
    private AbInfo abInfo;
    private PricingSummaries pricingSummaries;
    private Offers offers;
}
