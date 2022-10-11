package com.res.morderservice.repository;

import com.res.morderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
      List<Order> findOrderByCustomerNameAndActive(String customerName,boolean status);

      List<Order> findOrderByCustomerNameIgnoreCaseAndActiveIsTrue(String customerName);

 }
