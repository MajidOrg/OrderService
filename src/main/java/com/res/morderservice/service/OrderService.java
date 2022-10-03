package com.res.morderservice.service;

import com.res.morderservice.dto.RestaurantOrder;
import com.res.morderservice.entity.Order;
import com.res.morderservice.repository.OrderRepo;
import com.res.morderservice.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    OrderRepo orderRepo;
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderResponse createOrder(RestaurantOrder restaurantOrder) {

        var order = new Order();
        BeanUtils.copyProperties(restaurantOrder,order);
        var savedOrder = orderRepo.save(order);

        return OrderResponse.builder()
                .orderDetails(savedOrder.getDishOrdered())
                .orderId(savedOrder.getOrderId())
                .build();
    }
}
