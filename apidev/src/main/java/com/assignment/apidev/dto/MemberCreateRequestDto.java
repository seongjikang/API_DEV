package com.assignment.apidev.dto;

import com.assignment.apidev.entity.GenderType;
import com.assignment.apidev.entity.Member;
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
