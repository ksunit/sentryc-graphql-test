package com.sentryc.graphql.repository;

import com.sentryc.graphql.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerInfoRepository extends JpaRepository<SellerInfo, UUID> {
}
