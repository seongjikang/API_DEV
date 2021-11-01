package com.assignment.apidev.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String name;
    private String nickname;
    private String phoneNumber;
    private String email;
    private String genderType;

    public MemberDto(String name, String nickname, String phoneNumber, String email, String genderType) {
        this.name = name;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.genderType = genderType;
    }
}
