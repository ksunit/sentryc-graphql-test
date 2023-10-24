package com.sentryc.test.graphql.dto;

import com.sentryc.test.graphql.dto.enums.SellerState;
import lombok.Data;

@Data
public class ProducerSellerStateDTO {
    private String producerId;
    private String producerName;
    private SellerState sellerState;
    private String sellerId;
}
