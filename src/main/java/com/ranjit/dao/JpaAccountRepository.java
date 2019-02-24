package com.ranjit.dao;

import com.ranjit.model.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Account> findAll() {
        return entityManager.createQuery("select a from Account a", Account.class)                                            .getResultList();
    }

    @Override
    public Account findById(Integer id) {
        return entityManager.find(Account.class, id);
    }

    @Override
    public void saveOrUpdate() {

    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
