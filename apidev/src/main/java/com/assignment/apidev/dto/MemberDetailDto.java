package com.assignment.apidev.dto;

import com.assignment.apidev.entity.Order;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberDetailDto extends MemberDto{
    private List<Order> orders;

    @QueryProjection
    public MemberDetailDto(String name, String nickname, String phoneNumber, String email, String genderType, List<Order> orders) {
        super(name, nickname, phoneNumber, email, genderType);
        this.orders = orders;
    }
}
