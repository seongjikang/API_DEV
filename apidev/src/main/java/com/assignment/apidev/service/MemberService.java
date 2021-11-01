package com.assignment.apidev.service;

import com.assignment.apidev.dto.MemberCreateRequestDto;
import com.assignment.apidev.entity.GenderType;
import com.assignment.apidev.entity.Member;
import com.assignment.apidev.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
        if(requestDto.getGenderType().equals("M")) member.setGenderType(GenderType.MALE);
        else member.setGenderType(GenderType.FEMALE);
        memberRepository.save(member);
        return member.getId();
    }
}
