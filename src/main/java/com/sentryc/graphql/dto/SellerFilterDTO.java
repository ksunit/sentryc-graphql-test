package com.sentryc.graphql.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class SellerFilterDTO {
    private String searchByName;
    private List<UUID> producerIds;
    private List<String> marketplaceIds;
}
