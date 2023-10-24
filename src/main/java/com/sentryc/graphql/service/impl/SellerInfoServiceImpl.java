package com.sentryc.graphql.service.impl;

import com.sentryc.graphql.dto.*;
import com.sentryc.graphql.dto.enums.SellerSortBy;
import com.sentryc.graphql.repository.SellerRepository;
import com.sentryc.graphql.service.SellerInfoService;
import com.sentryc.graphql.entity.Seller;
import com.sentryc.graphql.repository.SellerInfoRepository;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public SellerPageableResponseDTO getSellerInfosByFilter(SellerFilterDTO filter, PageInputDTO page, SellerSortBy sortBy) {
        Specification<Seller> specification = getSellerSpecification(filter);
        List<Seller> sellerList = sellerRepository.findAll(specification);
        List<SellerInfoResponseDTO> sellerInfoResponseDTOList = new ArrayList<>();
        Map<SellerAndMarketPlaceDTO, List<Seller>> sellerInfoListMap = sellerList.stream().collect(Collectors.groupingBy(sellerInfo -> new SellerAndMarketPlaceDTO(sellerInfo.getSellerInfo().getExternalId(), sellerInfo.getSellerInfo().getMarketPlace().getId(), sellerInfo.getSellerInfo().getName())));
        sellerInfoListMap.forEach((sellerAndMarketPlace, sellersList) -> createSellerInfoResponseDTO(sellerAndMarketPlace, sellersList, sellerInfoResponseDTOList));

        sortSellerResponse(sortBy, sellerInfoResponseDTOList);
        PageImpl<SellerInfoResponseDTO> pageable = getSellerResponsePage(page, sellerInfoResponseDTOList);
        SellerPageableResponseDTO sellerPageableResponseDTO = getSellerPageableResponseDTO(page, pageable, sellerInfoResponseDTOList);
        return sellerPageableResponseDTO;
    }

    private static SellerPageableResponseDTO getSellerPageableResponseDTO(PageInputDTO page, PageImpl<SellerInfoResponseDTO> pageable, List<SellerInfoResponseDTO> sellerInfoResponseDTOList) {
        SellerPageableResponseDTO sellerPageableResponseDTO = new SellerPageableResponseDTO();
        sellerPageableResponseDTO.setData(pageable.getContent());
        sellerPageableResponseDTO.setMeta(new MetaDTO(page.getPage(), page.getSize(), sellerInfoResponseDTOList.size()));
        return sellerPageableResponseDTO;
    }

    private static PageImpl<SellerInfoResponseDTO> getSellerResponsePage(PageInputDTO page, List<SellerInfoResponseDTO> sellerInfoResponseDTOList) {
        int start = page.getPage() * page.getSize();
        int end = Math.min(start + page.getSize(), sellerInfoResponseDTOList.size());
        List<SellerInfoResponseDTO> sellerInfoResponseDTOListPageable = sellerInfoResponseDTOList.subList(start, end);
        PageImpl<SellerInfoResponseDTO> pageable =  new PageImpl<>(sellerInfoResponseDTOListPageable, PageRequest.of(page.getPage(), page.getSize()), sellerInfoResponseDTOList.size());
        return pageable;
    }

    private static void sortSellerResponse(SellerSortBy sortBy, List<SellerInfoResponseDTO> sellerInfoResponseDTOList) {
        switch (sortBy) {
            case SELLER_INFO_EXTERNAL_ID_ASC -> sellerInfoResponseDTOList.sort(Comparator.comparing(SellerInfoResponseDTO::getExternalId));
            case SELLER_INFO_EXTERNAL_ID_DESC -> sellerInfoResponseDTOList.sort(Comparator.comparing(SellerInfoResponseDTO::getExternalId).reversed());
            case NAME_ASC -> sellerInfoResponseDTOList.sort(Comparator.comparing(SellerInfoResponseDTO::getSellerName));
            case NAME_DESC -> sellerInfoResponseDTOList.sort(Comparator.comparing(SellerInfoResponseDTO::getSellerName).reversed());
            case MARKETPLACE_ID_ASC -> sellerInfoResponseDTOList.sort(Comparator.comparing(SellerInfoResponseDTO::getMarketplaceId));
            case MARKETPLACE_ID_DESC -> sellerInfoResponseDTOList.sort(Comparator.comparing(SellerInfoResponseDTO::getMarketplaceId).reversed());
        }
    }

    private static void createSellerInfoResponseDTO(SellerAndMarketPlaceDTO sellerAndMarketPlace, List<Seller> sellersList, List<SellerInfoResponseDTO> sellerInfoResponseDTOList) {
        SellerInfoResponseDTO sellerInfoResponseDTO = new SellerInfoResponseDTO();
        sellerInfoResponseDTO.setSellerName(sellerAndMarketPlace.getName());
        sellerInfoResponseDTO.setExternalId(sellerAndMarketPlace.getExternalId());
        sellerInfoResponseDTO.setMarketplaceId(sellerAndMarketPlace.getMarketPlaceId());

        List<ProducerSellerStateDTO> producerSellerStateDTOList = new ArrayList<>();
        sellersList.forEach(seller -> {
            createProducerSellerStateDTO(seller, producerSellerStateDTOList);
        });
        sellerInfoResponseDTO.setProducerSellerStates(producerSellerStateDTOList);
        sellerInfoResponseDTOList.add(sellerInfoResponseDTO);
    }

    private static void createProducerSellerStateDTO(Seller seller, List<ProducerSellerStateDTO> producerSellerStateDTOList) {
        ProducerSellerStateDTO producerSellerStateDTO = new ProducerSellerStateDTO();
        producerSellerStateDTO.setSellerId(seller.getSellerInfo().getId().toString());
        producerSellerStateDTO.setSellerState(seller.getState());
        producerSellerStateDTO.setProducerName(seller.getProducer().getName());
        producerSellerStateDTO.setProducerId(seller.getProducer().getId().toString());
        producerSellerStateDTOList.add(producerSellerStateDTO);
    }

    private static Specification<Seller> getSellerSpecification(SellerFilterDTO filter) {
        Specification<Seller> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.isNotBlank(filter.getSearchByName())) {
                predicates.add(criteriaBuilder.like(root.get("sellerInfo").get("name"), "%" + filter.getSearchByName() + "%"));
            }
            if (filter.getProducerIds() != null && !filter.getProducerIds().isEmpty()) {
                predicates.add(root.get("producer").get("id").in(filter.getProducerIds()));
            }
            if (filter.getMarketplaceIds() != null && !filter.getMarketplaceIds().isEmpty()) {
                predicates.add(root.get("sellerInfo").get("marketPlace").get("id").in(filter.getMarketplaceIds()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return specification;
    }
}
