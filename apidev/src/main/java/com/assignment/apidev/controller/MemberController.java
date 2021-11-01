package com.assignment.apidev.controller;

import com.assignment.apidev.dto.MemberCreateRequestDto;
import com.assignment.apidev.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
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

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}
