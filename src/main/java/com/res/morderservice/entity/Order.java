package com.res.morderservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "T_RES_ORDER")
public class Order {

    @Id
    @Column(name = "orderId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customerOrder")
    private String dishOrdered;
}
