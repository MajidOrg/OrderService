package com.res.morderservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestaurantOrderUpdate {

    @Schema(description = "Restaurant order id")
    private Long orderId;
    @Schema(description = "Menu that customer prefer to eat")
    private String dishOrdered;
}
