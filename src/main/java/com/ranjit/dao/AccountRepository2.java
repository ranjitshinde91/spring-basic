package com.ranjit.dao;

import com.ranjit.model.Account;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Profile("test")
public interface AccountRepository2 extends JpaRepository<Account, Integer> {
    public List<Account> findAccountsByBalanceGreaterThanEqual(BigDecimal balance);

    public List<Account> findAccountsByBalanceLessThanEqual(BigDecimal balance);
}
