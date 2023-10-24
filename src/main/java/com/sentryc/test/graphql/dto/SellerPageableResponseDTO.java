package com.sentryc.test.graphql.dto;

import lombok.Data;

import java.util.List;

@Data
public class SellerPageableResponseDTO {
    private MetaDTO meta;
    private List<SellerInfoResponseDTO> data;
}
