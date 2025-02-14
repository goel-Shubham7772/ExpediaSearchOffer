package com.expedia.service.serviceImpl;

import com.expedia.model.response.ExpediaResponse;
import com.expedia.service.ExpediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ExpediaServiceImpl implements ExpediaService {
    private static final Logger log = LoggerFactory.getLogger(ExpediaServiceImpl.class);

    @Value("${expedia.url}")
    private String expediaApiUrl;

    private final RestTemplate restTemplate;

    public ExpediaServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public ExpediaResponse getPackageOffers(String originCity, String destinationCity) {
        log.info("In serviceImpl before calling thirdParty api");
        String url = UriComponentsBuilder.fromHttpUrl(expediaApiUrl)
                .queryParam("scenario", "deal-finder")
                .queryParam("page", "foo")
                .queryParam("uid", "test")
                .queryParam("productType", "Package")
                .queryParam("clientId", "test")
                .queryParam("originCity", originCity)
                .queryParam("destinationCity", destinationCity)
                .toUriString();
        log.info("Third party endpoint generated as {}",url);

        return restTemplate.getForObject(url, ExpediaResponse.class);
    }
}
