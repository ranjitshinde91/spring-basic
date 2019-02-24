package com.ranjit.dao;

import com.ranjit.config.AppConfig;
import com.ranjit.model.Account;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("test")
public class JdbcCrudRepositoryTest {

    @Autowired
    private CrudRepository<Account, Integer> repository;


    @Test
    public void list() {
        List<Account> list = repository.findAll();
        assertThat(list).hasSize(3);
    }

    @Test
    public void get(){
        Account account =  repository.findById(1);
        assertThat(account).isEqualTo(new Account(1, new BigDecimal(100)));
    }

    @Test
    @Ignore
    public void delete() {
        int n= repository.delete(1);
        assertThat(n).isEqualTo(1);
    }
}