package com.assignment.apidev.dto;

import lombok.Data;

@Data
public class MemberCreateRequestDto {
    private String name;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String email;
    private String genderType;
}
