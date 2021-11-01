package com.assignment.apidev.dto;

import com.assignment.apidev.entity.Order;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private String memberName;
    private String orderNum;
    private String productName;
    private LocalDateTime paymentDate;

    public OrderDto(Order order) {
        this.memberName = order.getMember().getName();
        this.orderNum = order.getOrderNum();
        this.productName = order.getProductName();
        this.paymentDate = order.getPaymentDate();
    }
}