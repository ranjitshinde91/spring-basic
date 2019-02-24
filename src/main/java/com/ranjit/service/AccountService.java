package com.ranjit.service;

import com.ranjit.dao.AccountRepository;
import com.ranjit.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class AccountService {
    @Autowired
    private AccountRepository jdbcAccountRepository;

}
