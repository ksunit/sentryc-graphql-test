package com.sentryc.test.graphql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marketplaces")
@Data
public class MarketPlace {

    @Id
    private String id;

    private String description;
}
