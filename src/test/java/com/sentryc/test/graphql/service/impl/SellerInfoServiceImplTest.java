package com.sentryc.test.graphql.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sentryc.test.graphql.dto.MetaDTO;
import com.sentryc.test.graphql.dto.PageInputDTO;
import com.sentryc.test.graphql.dto.SellerFilterDTO;
import com.sentryc.test.graphql.dto.SellerPageableResponseDTO;
import com.sentryc.test.graphql.dto.enums.SellerSortBy;
import com.sentryc.test.graphql.repository.SellerRepository;
import com.sentryc.test.graphql.entity.Seller;
import com.sentryc.test.graphql.repository.SellerInfoRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SellerInfoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SellerInfoServiceImplTest {
    @MockBean
    private SellerInfoRepository sellerInfoRepository;

    @Autowired
    private SellerInfoServiceImpl sellerInfoServiceImpl;

    @MockBean
    private SellerRepository sellerRepository;

    /**
     * Method under test: {@link SellerInfoServiceImpl#getSellerInfosByFilter(SellerFilterDTO, PageInputDTO, SellerSortBy)}
     */
    @Test
    void testGetSellerInfosByFilter() {
        when(sellerRepository.findAll(Mockito.<Specification<Seller>>any())).thenReturn(new ArrayList<>());

        SellerFilterDTO filter = new SellerFilterDTO();
        filter.setMarketplaceIds(new ArrayList<>());
        filter.setProducerIds(new ArrayList<>());
        filter.setSearchByName("Search By Name");
        PageInputDTO page = mock(PageInputDTO.class);
        when(page.getPage()).thenReturn(0);
        when(page.getSize()).thenReturn(3);
        doNothing().when(page).setPage(anyInt());
        doNothing().when(page).setSize(anyInt());
        page.setPage(1);
        page.setSize(3);
        SellerPageableResponseDTO actualSellerInfosByFilter = sellerInfoServiceImpl.getSellerInfosByFilter(filter, page,
                SellerSortBy.SELLER_INFO_EXTERNAL_ID_ASC);
        assertTrue(actualSellerInfosByFilter.getData().isEmpty());
        MetaDTO meta = actualSellerInfosByFilter.getMeta();
        assertEquals(0, meta.getPage());
        assertEquals(0, meta.getTotalRecords());
        assertEquals(3, meta.getSize());
        verify(sellerRepository).findAll(Mockito.<Specification<Seller>>any());
        verify(page, atLeast(1)).getPage();
        verify(page, atLeast(1)).getSize();
        verify(page).setPage(anyInt());
        verify(page).setSize(anyInt());
    }
}

