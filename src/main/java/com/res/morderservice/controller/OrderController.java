package com.res.morderservice.controller;


import com.res.morderservice.dto.RestaurantOrder;
import com.res.morderservice.response.OrderResponse;
import com.res.morderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderAPI {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<OrderResponse> createOrder(@RequestBody RestaurantOrder restaurantOrder) {

        if (null == restaurantOrder ||
                null == restaurantOrder.getDishOrdered()) {
            return ResponseEntity.badRequest().build();
        }
        var orderResponse = orderService.createOrder(restaurantOrder);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

}
