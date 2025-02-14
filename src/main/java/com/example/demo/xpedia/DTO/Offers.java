package com.example.demo.xpedia.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Offers {
    @JsonProperty("Package")
    private List<PackageOffer> packageOffers;
}
