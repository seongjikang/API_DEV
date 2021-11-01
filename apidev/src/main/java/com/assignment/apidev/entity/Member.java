package com.assignment.apidev.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull @Size(min = 10)
    private String password;
    @NotNull @Column(unique = true, length = 20)
    private String phoneNumber;
    @NotNull @Column(unique = true, length = 100)
    private String email;

    private String genderType;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
