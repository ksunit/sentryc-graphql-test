package com.sentryc.graphql.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellerInfoResponseDTO {
    private String sellerName;
    private String externalId;
    private String marketplaceId;
    private List<ProducerSellerStateDTO> producerSellerStates;
}
