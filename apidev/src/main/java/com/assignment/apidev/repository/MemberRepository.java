package com.assignment.apidev.repository;

import com.assignment.apidev.entity.Member;
import com.assignment.apidev.entity.Order;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public User findUserById(Long id) {
        return em.find(User.class, id);
    }

    public List<Order> findUserOrdersById(Long id) {
        return em.createQuery("SELECT o FROM Order o WHERE o.id = :id", Order.class)
                .setParameter("id",  id)
                .getResultList();
    }

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u" , User.class).getResultList();
    }
}
