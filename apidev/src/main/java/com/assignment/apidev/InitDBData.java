package com.assignment.apidev;

import com.assignment.apidev.entity.GenderType;
import com.assignment.apidev.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDBData {
    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.memberInit();
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
                member.setPassword("testPw");
                member.setPhoneNumber("010000000"+i);
                member.setEmail("test"+i+"@gmail.com");
                member.setGenderType(GenderType.MALE);
                em.persist(member);
            }

            for(int i=5; i<10; i++) {
                Member member = new Member();
                member.setName("testName"+i);
                member.setNickname("testNickName"+i);
                member.setPassword("testPw");
                member.setPhoneNumber("010000000"+i);
                member.setEmail("test"+i+"@gmail.com");
                member.setGenderType(GenderType.FEMALE);
                em.persist(member);
            }
        }

    }
}
