package com.assignment.apidev.service;

import com.assignment.apidev.dto.*;
import com.assignment.apidev.entity.Member;
import com.assignment.apidev.entity.Order;
import com.assignment.apidev.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(MemberCreateRequestDto requestDto) {
        Member member = new Member();
        member.setName(requestDto.getName());
        member.setNickname(requestDto.getNickname());
        member.setEmail(requestDto.getEmail());
        member.setPhoneNumber(requestDto.getPhoneNumber());
        member.setPassword(requestDto.getPassword());
        member.setGenderType(requestDto.getGenderType());
        memberRepository.save(member);
        return member.getId();
    }

    public MemberDto findOne(Long memberId) {
        Member findMember = memberRepository.findMemberById(memberId);
        return new MemberDto(findMember.getName(),findMember.getNickname(), findMember.getPhoneNumber(), findMember.getEmail(), findMember.getGenderType());
    }

    public Page<MemberDetailDto> findAll(MemberSearchConditionDto memberSearchCondition, Pageable pageable) {
        return memberRepository.searchMemberList(memberSearchCondition, pageable);
    }

    public List<Order> findOrders(Long memberId) {
        Member findMember = memberRepository.findMemberById(memberId);
        return memberRepository.findMemberOrdersByMember(findMember);
    }
}
