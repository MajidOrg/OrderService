package com.res.morderservice.controller;


import com.res.morderservice.dto.RestaurantOrder;
import com.res.morderservice.dto.RestaurantOrderUpdate;
import com.res.morderservice.response.OrderResponse;
import com.res.morderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    public ResponseEntity<List<OrderResponse>> getAllOrder() {

        var orderResList = orderService.getAllOrder();
        return ResponseEntity.status(HttpStatus.OK).body(orderResList);
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getOrderByCustomerName(@PathVariable String customerName) {

        if (null == customerName) {
            return ResponseEntity.badRequest().build();
        } else {
            var orderResList = orderService.getOrderForCustomer(customerName);
            return ResponseEntity.status(HttpStatus.OK).body(orderResList);
        }

    }

    public ResponseEntity<String> updateOrder(@RequestBody RestaurantOrderUpdate restaurantOrder) {

        if (null == restaurantOrder ||
                null == restaurantOrder.getOrderId()) {
            return ResponseEntity.badRequest().build();
        }
        var orderResponse = orderService.updateOrder(restaurantOrder);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

    @Override
    public ResponseEntity<String> deleteOrder(@PathVariable String orderId) {
        if (null == orderId ){
            return ResponseEntity.badRequest().build();
        }
        var orderResponse = orderService.deleteOrder(Long.valueOf(orderId));
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }
}
