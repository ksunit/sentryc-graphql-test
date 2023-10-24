package com.sentryc.graphql.controller;

import com.sentryc.graphql.dto.PageInputDTO;
import com.sentryc.graphql.dto.SellerFilterDTO;
import com.sentryc.graphql.dto.enums.SellerSortBy;
import com.sentryc.graphql.dto.SellerPageableResponseDTO;
import com.sentryc.graphql.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SellerInfoController {

    @Autowired
    private SellerInfoService sellerInfoService;

    @QueryMapping("sellers")
    public SellerPageableResponseDTO getSellerInfosByFilter(@Argument SellerFilterDTO filter, @Argument PageInputDTO page, @Argument SellerSortBy sortBy) {
        return sellerInfoService.getSellerInfosByFilter(filter, page, sortBy);
    }
}
