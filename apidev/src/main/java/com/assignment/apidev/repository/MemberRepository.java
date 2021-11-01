package com.assignment.apidev.repository;

import com.assignment.apidev.dto.MemberDetailDto;
import com.assignment.apidev.dto.MemberSearchConditionDto;
import com.assignment.apidev.dto.QMemberDetailDto;
import com.assignment.apidev.entity.Member;
import com.assignment.apidev.entity.Order;
import com.assignment.apidev.entity.QMember;
import com.assignment.apidev.entity.QOrder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.apache.tomcat.jni.Library;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository implements MemberRepositoryCustom{
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findMemberById(Long id) {
        return em.find(Member.class, id);
    }

    public List<Order> findMemberOrdersByMember(Member member) {
        return em.createQuery("SELECT o FROM Order o WHERE o.member = :member", Order.class)
                .setParameter("member",  member)
                .getResultList();
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m" , Member.class).getResultList();
    }

    @Override
    public Page<MemberDetailDto> searchMemberList(MemberSearchConditionDto memberSearchCondition, Pageable pageable) {

        List<MemberDetailDto> content = queryFactory
                .select(new QMemberDetailDto(
                        QMember.member.name,
                        QMember.member.nickname,
                        QMember.member.phoneNumber,
                        QMember.member.email,
                        QMember.member.genderType,
                        QMember.member.orders
                )).from(QMember.member)
                .where(
                        memberNameLike(memberSearchCondition.getName()),
                        memberEmailLike(memberSearchCondition.getEmail())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Member> countQuery = queryFactory
                .select(QMember.member)
                .from(QMember.member)
                .where(
                       memberNameLike(memberSearchCondition.getName()),
                       memberEmailLike(memberSearchCondition.getEmail())
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

    private BooleanExpression memberNameLike(String name) {
        return StringUtils.hasText(name) ? QMember.member.name.like(name) : null;
    }

    private BooleanExpression memberEmailLike(String email) {
        return StringUtils.hasText(email) ? QMember.member.email.like(email) : null;
    }
}
