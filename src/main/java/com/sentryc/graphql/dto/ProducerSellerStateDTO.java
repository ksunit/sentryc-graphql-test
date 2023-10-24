package com.sentryc.graphql.dto;

import com.sentryc.graphql.dto.enums.SellerState;
import lombok.Data;

@Data
public class ProducerSellerStateDTO {
    private String producerId;
    private String producerName;
    private SellerState sellerState;
    private String sellerId;
}
