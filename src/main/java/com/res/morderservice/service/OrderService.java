package com.res.morderservice.service;

import com.res.morderservice.dto.RestaurantOrder;
import com.res.morderservice.dto.RestaurantOrderUpdate;
import com.res.morderservice.entity.Order;
import com.res.morderservice.repository.OrderRepo;
import com.res.morderservice.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {

    OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderResponse createOrder(RestaurantOrder restaurantOrder) {

        var order = new Order();
        BeanUtils.copyProperties(restaurantOrder, order);
        order.setActive(true);
        var savedOrder = orderRepo.save(order);

        return OrderResponse.builder()
                .orderDetails(savedOrder.getDishOrdered())
                .orderId(savedOrder.getOrderId())
                .build();
    }

    public List<OrderResponse> getAllOrder() {
        var orderList = orderRepo.findAll();
        var orderResponseList = orderList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return orderResponseList;
    }

    public List<OrderResponse> getOrderForCustomer(String customerName) {

       var orderList = orderRepo.findOrderByCustomerNameAndActive(customerName,true);
        var orderResponseList = orderList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        return orderResponseList;
    }

    public String updateOrder(RestaurantOrderUpdate restaurantOrder) {

        var orderOptional = orderRepo.findById(restaurantOrder.getOrderId());

        if(orderOptional.isEmpty()){
            return  "Sorry no active order found";
        }else{
           var order = orderOptional.get();
           order.setDishOrdered(restaurantOrder.getDishOrdered());
           orderRepo.save(order);
           return "Your order with Id :"+order.getOrderId()+
                   " has been updated for dish :"+restaurantOrder.getDishOrdered();
        }

    }

    private OrderResponse mapToDto(Order order) {

        var restaurantOrder = OrderResponse.builder().build();
        restaurantOrder.setOrderId(order.getOrderId());
        restaurantOrder.setOrderDetails(order.getDishOrdered());
        return restaurantOrder;
    }



}
