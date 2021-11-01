package com.assignment.apidev.repository;

import com.assignment.apidev.dto.MemberDetailDto;
import com.assignment.apidev.dto.MemberSearchConditionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {
    Page<MemberDetailDto> searchMemberList(MemberSearchConditionDto memberSearchCondition, Pageable pageable);
}
