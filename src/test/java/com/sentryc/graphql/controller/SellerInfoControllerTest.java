package com.sentryc.graphql.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.graphql.dto.MetaDTO;
import com.sentryc.graphql.dto.PageInputDTO;
import com.sentryc.graphql.dto.SellerFilterDTO;
import com.sentryc.graphql.dto.SellerPageableResponseDTO;
import com.sentryc.graphql.dto.enums.SellerSortBy;
import com.sentryc.graphql.service.SellerInfoService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerInfoController.class})
@ExtendWith(SpringExtension.class)
class SellerInfoControllerTest {
    @Autowired
    private SellerInfoController sellerInfoController;

    @MockBean
    private SellerInfoService sellerInfoService;

    /**
     * Method under test: {@link SellerInfoController#getSellerInfosByFilter(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter() {
        SellerPageableResponseDTO sellerPageableResponseDTO = new SellerPageableResponseDTO();
        sellerPageableResponseDTO.setData(new ArrayList<>());
        sellerPageableResponseDTO.setMeta(new MetaDTO(1, 3, 1));
        when(sellerInfoService.getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponseDTO);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponseDTO,
                sellerInfoController.getSellerInfosByFilter(filter, page, SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC));
        verify(sellerInfoService).getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerInfoController#getSellerInfosByFilter(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter2() {
        SellerPageableResponseDTO sellerPageableResponseDTO = new SellerPageableResponseDTO();
        sellerPageableResponseDTO.setData(new ArrayList<>());
        sellerPageableResponseDTO.setMeta(new MetaDTO(1, 3, 1));
        when(sellerInfoService.getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponseDTO);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponseDTO,
                sellerInfoController.getSellerInfosByFilter(filter, page, SellerSortBy.SELLER_INFO_EXTERNAL_ID_DESC));
        verify(sellerInfoService).getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerInfoController#getSellerInfosByFilter(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter3() {
        SellerPageableResponseDTO sellerPageableResponseDTO = new SellerPageableResponseDTO();
        sellerPageableResponseDTO.setData(new ArrayList<>());
        sellerPageableResponseDTO.setMeta(new MetaDTO(1, 3, 1));
        when(sellerInfoService.getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponseDTO);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponseDTO,
                sellerInfoController.getSellerInfosByFilter(filter, page, SellerSortBy.NAME_ASC));
        verify(sellerInfoService).getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerInfoController#getSellerInfosByFilter(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter4() {
        SellerPageableResponseDTO sellerPageableResponseDTO = new SellerPageableResponseDTO();
        sellerPageableResponseDTO.setData(new ArrayList<>());
        sellerPageableResponseDTO.setMeta(new MetaDTO(1, 3, 1));
        when(sellerInfoService.getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponseDTO);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponseDTO,
                sellerInfoController.getSellerInfosByFilter(filter, page, SellerSortBy.NAME_DESC));
        verify(sellerInfoService).getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerInfoController#getSellerInfosByFilter(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter5() {
        SellerPageableResponseDTO sellerPageableResponseDTO = new SellerPageableResponseDTO();
        sellerPageableResponseDTO.setData(new ArrayList<>());
        sellerPageableResponseDTO.setMeta(new MetaDTO(1, 3, 1));
        when(sellerInfoService.getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponseDTO);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponseDTO,
                sellerInfoController.getSellerInfosByFilter(filter, page, SellerSortBy.MARKETPLACE_ID_ASC));
        verify(sellerInfoService).getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }

    /**
     * Method under test: {@link SellerInfoController#getSellerInfosByFilter(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter6() {
        SellerPageableResponseDTO sellerPageableResponseDTO = new SellerPageableResponseDTO();
        sellerPageableResponseDTO.setData(new ArrayList<>());
        sellerPageableResponseDTO.setMeta(new MetaDTO(1, 3, 1));
        when(sellerInfoService.getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any())).thenReturn(sellerPageableResponseDTO);

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");

        PageInputDTO page = new PageInputDTO();
        page.setPage(1);
        page.setSize(3);
        assertSame(sellerPageableResponseDTO,
                sellerInfoController.getSellerInfosByFilter(filter, page, SellerSortBy.MARKETPLACE_ID_DESC));
        verify(sellerInfoService).getSellerInfosByFilter(Mockito.<SellerFilterDTO>any(), Mockito.<PageInputDTO>any(),
                Mockito.<SellerSortBy>any());
    }
}

