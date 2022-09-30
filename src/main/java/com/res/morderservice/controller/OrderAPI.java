package com.res.morderservice.controller;

import com.res.morderservice.dto.RestaurantOrder;
import com.res.morderservice.response.OrderResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@Tag(name = "The Restaurant application ")
@OpenAPIDefinition
public interface OrderAPI {

    @Operation(summary = "This API takes a new order from the customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @PostMapping("/createOrder")
    ResponseEntity<OrderResponse> createOrder(@RequestBody RestaurantOrder restaurantOrder);

    @GetMapping("/getOrderByCustomerName/{customerName}")
    ResponseEntity<OrderResponse> getOrderByCustomerName(@PathVariable String customerName);
}
