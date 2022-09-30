package com.res.morderservice.controller;


import com.res.morderservice.dto.RestaurantOrder;
import com.res.morderservice.response.OrderResponse;
import com.res.morderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "The Restaurant application ")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    @Operation(summary = "This API takes a new order from the customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    ResponseEntity<OrderResponse> createOrder(@RequestBody RestaurantOrder restaurantOrder){

        if(null == restaurantOrder ||
                null == restaurantOrder.getDishOrdered()){

            return ResponseEntity.badRequest().build();
        }

        var orderResponse = orderService.createOrder(restaurantOrder);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

}
