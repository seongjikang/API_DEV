package com.assignment.apidev.controller;

import com.assignment.apidev.dto.MemberCreateRequestDto;
import com.assignment.apidev.dto.MemberSearchConditionDto;
import com.assignment.apidev.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public Result join(@RequestBody @Valid MemberCreateRequestDto requestDto) {
        Long memberId = memberService.join(requestDto);
        return new Result(memberId);
    }

    @GetMapping("/members/{memberId}")
    public Result findOne(@PathVariable("memberId") Long memberId) {
        return new Result(memberService.findOne(memberId));
    }

    @GetMapping("/members")
    public Result findAll(MemberSearchConditionDto memberSearchCondition, Pageable pageable) {
        return new Result(memberService.findAll(memberSearchCondition, pageable));
    }

    @GetMapping("/members/orders/{memberId}")
    public Result findOrders(@PathVariable("memberId") Long memberId) {
        return new Result(memberService.findOrders(memberId));
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}
