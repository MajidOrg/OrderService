package com.res.morderservice.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderResponse {

    @Schema(description = "The order reference number")
    private Long orderId;
    @Schema(description = "The details of the order")
    private String orderDetails;
}
