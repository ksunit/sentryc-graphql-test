package com.sentryc.graphql.entity;

import com.sentryc.graphql.dto.enums.SellerState;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "sellers")
@Data
public class Seller {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "seller_info_id", referencedColumnName = "id")
    private SellerInfo sellerInfo;

    @ManyToOne
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @Enumerated(EnumType.STRING)
    private SellerState state;

}
