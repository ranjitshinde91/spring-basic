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

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("test")
public class JdbcAccountRepositoryTest {

    @Autowired
    private AccountRepository jdbcAccountRepository;


    @Test
    public void list() {
        List<Account> list = jdbcAccountRepository.findAll();
        assertThat(list).hasSize(3);
    }

    @Test
    public void get(){
        Account account =  jdbcAccountRepository.findById(1);
        assertThat(account).isEqualTo(new Account(1, new BigDecimal(100)));
    }

    @Test
    @Ignore
    public void delete() {
        int n= jdbcAccountRepository.delete(1);
        assertThat(n).isEqualTo(1);
    }
}