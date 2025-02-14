package com.example.demo.xpedia.controller;

import com.example.demo.xpedia.DTO.ExpediaResponse;
import com.example.demo.xpedia.service.ExpediaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/expedia")
public class ExpediaController {

    private static final Logger log = LoggerFactory.getLogger(ExpediaController.class);

    private final ExpediaService expediaService;

    public ExpediaController(ExpediaService expediaService) {
        this.expediaService = expediaService;
    }

    @GetMapping("/offers")
    public ExpediaResponse getExpediaOffers(
            @RequestParam("originCity") String originCity,
            @RequestParam("destinationCity") String destinationCity) {
        log.info("inside Controller, fetching data from service");
        return expediaService.getOffers(originCity, destinationCity);
    }
}
