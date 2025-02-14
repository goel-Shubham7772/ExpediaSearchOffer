package com.example.demo.xpedia.service;

import com.example.demo.xpedia.DTO.ExpediaResponse;
import com.example.demo.xpedia.controller.ExpediaController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service

public class ExpediaService {

    private static final Logger log = LoggerFactory.getLogger(ExpediaService.class);

    private final WebClient webClient;

    public ExpediaService(WebClient webClient) {
        this.webClient = webClient;
    }

    public ExpediaResponse getOffers(String originCity, String destinationCity) {
        log.info("calling web client to expedia endpoint");
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("scenario", "deal-finder")
                        .queryParam("page", "foo")
                        .queryParam("uid", "test")
                        .queryParam("productType", "Package")
                        .queryParam("clientId", "test")
                        .queryParam("OriginCity", originCity)
                        .queryParam("DestinationCity", destinationCity)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,this::handleWebClientException)
                .onStatus(HttpStatusCode::is5xxServerError,this::handleWebClientException)
                .bodyToMono(ExpediaResponse.class)
                .block();
    }

    public Mono<Throwable> handleWebClientException(ClientResponse response){
        return response
                .bodyToMono(String.class)
                .flatMap(errorBody->{
                    try{
                        ObjectMapper mapper = new ObjectMapper();
                        ErrorResponse errorMessage = mapper.readValue(errorBody,ErrorResponse.class);
                        return Mono.error(new RuntimeException("Error while calling API"));
                    }
                    catch (JsonProcessingException e){
                        log.error("Exception caught {} unable to map error response {}",e,errorBody);
                        return Mono.error(new RuntimeException("Error while calling API"));
                    }
                });
    }
}
