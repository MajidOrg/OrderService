package com.res.morderservice.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestaurantOrder {

    private String customerName;
    private String dishOrdered;
}
