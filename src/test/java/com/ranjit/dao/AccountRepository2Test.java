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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("test")
public class AccountRepository2Test {

    @Autowired
    private AccountRepository2 accountRepository2;

    @Test
    public void findAll(){
        List<Account> accounts = accountRepository2.findAll();
        assertThat(accounts).hasSize(3);
    }

    @Test
    public void find(){
        Account account = accountRepository2.findById(1).get();
        assertThat(account).isEqualTo(new Account(1, new BigDecimal(100)));
    }

    @Test
    public void findAllByBalance(){
        List<Account> accounts = accountRepository2.findAccountsByBalanceGreaterThanEqual(new BigDecimal(200));
        assertThat(accounts).hasSize(2);
    }

    @Test
    public void findAccountByBalance(){
        List<Account> accounts= accountRepository2.findAccountsByBalanceLessThanEqual(new BigDecimal(200));
        assertThat(accounts).hasSize(2);
    }

}