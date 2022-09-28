package com.res.morderservice.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderResponse {

    private Long orderId;
    private String orderDetails;
}
