package com.ranjit.dao;

import com.ranjit.config.AppConfig;
import com.ranjit.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("test")
public class JpaAccountRepositoryTest {
    @Autowired
    private AccountRepository jpaAccountRepository;

    @Test
    public void findAll() {
        List<Account> all = jpaAccountRepository.findAll();
        assertThat(all).hasSize(3);
    }

    @Test
    public void create(){
        Account account = jpaAccountRepository.findById(1);
        assertThat(account).isEqualTo(new Account(1, new BigDecimal(100)));
    }
}