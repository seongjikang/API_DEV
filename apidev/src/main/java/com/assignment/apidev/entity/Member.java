package com.assignment.apidev.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member_tb")
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull @Column(length = 20)
    private String name;
    @NotNull @Column(length = 30)
    private String nickname;
    @NotNull
    private String password;
    @NotNull @Column(unique = true, length = 20)
    private String phoneNumber;
    @NotNull @Column(unique = true, length = 100)
    private String email;
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
