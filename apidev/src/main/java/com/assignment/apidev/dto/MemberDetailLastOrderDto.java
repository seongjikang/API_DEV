package com.assignment.apidev.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDetailLastOrderDto extends MemberDto{
    private String lastOrderNum;
    private String productName;
    private String paymentDate;

    public MemberDetailLastOrderDto(String name, String nickname, String phoneNumber, String email, String genderType, String lastOrderNum, String productName, String paymentDate) {
        super(name, nickname, phoneNumber, email, genderType);
        this.lastOrderNum = lastOrderNum;
        this.productName = productName;
        this.paymentDate = paymentDate;
    }
}
