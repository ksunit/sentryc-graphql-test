package com.sentryc.graphql.controller;

import com.sentryc.graphql.dto.PageInputDTO;
import com.sentryc.graphql.dto.SellerFilterDTO;
import com.sentryc.graphql.dto.SellerPageableResponseDTO;
import com.sentryc.graphql.dto.enums.SellerSortBy;
import com.sentryc.graphql.service.SellerInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class SellerInfoControllerIntegrationTest {

    @Autowired
    private SellerInfoController sellerInfoController;

    @Test
    public void TestGetSellerInfosByFilter() {
        SellerFilterDTO sellerFilterDTO = new SellerFilterDTO();
        sellerFilterDTO.setSearchByName("Amazon US");
        sellerFilterDTO.setProducerIds(List.of(UUID.fromString("64eb76cb-2b62-4891-b59e-50694a48f376")));
        sellerFilterDTO.setMarketplaceIds(List.of("amazon.ae"));

        PageInputDTO pageInputDTO = new PageInputDTO();
        pageInputDTO.setPage(0);
        pageInputDTO.setSize(10);

        SellerPageableResponseDTO sellerPageableResponseDTO = sellerInfoController.getSellerInfosByFilter(sellerFilterDTO, pageInputDTO, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC);
        assertEquals(sellerPageableResponseDTO.getData().get(0).getExternalId(), "A2QUTRSO1ZHRN9");
    }
}
