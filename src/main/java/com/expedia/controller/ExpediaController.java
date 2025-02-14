package com.expedia.controller;

import com.expedia.model.response.ExpediaResponse;
import com.expedia.service.ExpediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpediaController {

    private static final Logger log = LoggerFactory.getLogger(ExpediaController.class);

    @Autowired
    private ExpediaService expediaService;

    @GetMapping("/search")
    public ResponseEntity<ExpediaResponse> fetchPackages(@RequestParam("originCity") String originCity,
                                                        @RequestParam("destinationCity") String destinationCity) {
        log.info("inside Controller, fetching data from service");
        ExpediaResponse response = expediaService.getPackageOffers(originCity, destinationCity);
        return ResponseEntity.ok(response);
    }
}
