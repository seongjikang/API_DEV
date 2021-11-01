package com.assignment.apidev;

import com.assignment.apidev.entity.GenderType;
import com.assignment.apidev.entity.Member;
import com.assignment.apidev.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDBData {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.memberInit();
        initService.orderInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void memberInit() {
            for(int i=0; i<5; i++) {
                Member member = new Member();
                member.setName("testName"+i);
                member.setNickname("testNickName"+i);
                member.setPassword("testPw1234");
                member.setPhoneNumber("010000000"+i);
                member.setEmail("test"+i+"@gmail.com");
                member.setGenderType(GenderType.MALE);
                em.persist(member);
            }

            for(int i=5; i<10; i++) {
                Member member = new Member();
                member.setName("testName"+i);
                member.setNickname("testNickName"+i);
                member.setPassword("testPw1234");
                member.setPhoneNumber("010000000"+i);
                member.setEmail("test"+i+"@gmail.com");
                member.setGenderType(GenderType.FEMALE);
                em.persist(member);
            }
        }

        public void orderInit() {
            for(int i = 0 ; i<10; i=i+2) {
                Member member = em.find(Member.class, (long)i+1);
                Order order1 = new Order();
                order1.setOrderNum("10000000000"+i);
                order1.setProductName("product"+i);
                order1.setPaymentDate(LocalDateTime.of(2021,03, 01,00,00,0+i));
                order1.setMember(member);
                em.persist(order1);

                Order order2 = new Order();
                order2.setOrderNum("20000000000"+i);
                order2.setProductName("product"+i);
                order2.setPaymentDate(LocalDateTime.of(2021,03, 01,00,00,0+i));
                order2.setMember(member);
                em.persist(order2);
            }
        }

    }
}
