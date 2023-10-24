package com.sentryc.test.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetaDTO {
    private int page;
    private int size;
    private int totalRecords;
}
