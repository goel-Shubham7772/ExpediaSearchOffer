package com.expedia.service;

import com.expedia.model.response.ExpediaResponse;

public interface ExpediaService {

    public ExpediaResponse getPackageOffers(String originCity, String destinationCity);
}
