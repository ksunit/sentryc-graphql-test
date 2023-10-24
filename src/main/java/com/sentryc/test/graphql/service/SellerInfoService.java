package com.sentryc.test.graphql.service;

import com.sentryc.test.graphql.dto.PageInputDTO;
import com.sentryc.test.graphql.dto.SellerFilterDTO;
import com.sentryc.test.graphql.dto.SellerPageableResponseDTO;
import com.sentryc.test.graphql.dto.enums.SellerSortBy;

public interface SellerInfoService {
    SellerPageableResponseDTO getSellerInfosByFilter(SellerFilterDTO filter, PageInputDTO page, SellerSortBy sortBy);
}
