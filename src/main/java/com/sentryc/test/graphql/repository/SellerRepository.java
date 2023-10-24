package com.sentryc.test.graphql.repository;

import com.sentryc.test.graphql.entity.Seller;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SellerRepository extends JpaRepository<Seller, UUID> {
    List<Seller> findAll(Specification<Seller> specification);
}
