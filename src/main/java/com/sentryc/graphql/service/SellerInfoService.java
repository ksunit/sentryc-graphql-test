package com.sentryc.graphql.service;

import com.sentryc.graphql.dto.PageInputDTO;
import com.sentryc.graphql.dto.SellerFilterDTO;
import com.sentryc.graphql.dto.SellerPageableResponseDTO;
import com.sentryc.graphql.dto.enums.SellerSortBy;

public interface SellerInfoService {
    SellerPageableResponseDTO getSellerInfosByFilter(SellerFilterDTO filter, PageInputDTO page, SellerSortBy sortBy);
}
