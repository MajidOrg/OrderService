package com.res.morderservice.service;

import com.res.morderservice.dto.RestaurantOrder;
import com.res.morderservice.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {


    public OrderResponse createOrder(RestaurantOrder restaurantOrder) {

        //TODO -: Need to add business logic to save order
        return OrderResponse.builder()
                .orderDetails("Mango")
                .orderId(123L)
                .build();
    }
}
