package com.sentryc.test.graphql.controller;

import com.sentryc.test.graphql.dto.PageInputDTO;
import com.sentryc.test.graphql.dto.SellerFilterDTO;
import com.sentryc.test.graphql.dto.enums.SellerSortBy;
import com.sentryc.test.graphql.dto.SellerPageableResponseDTO;
import com.sentryc.test.graphql.service.SellerInfoService;
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
