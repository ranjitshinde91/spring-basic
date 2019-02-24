package com.ranjit.dao;

import com.ranjit.model.Account;

import java.util.List;


public interface AccountRepository {

    public List<Account> findAll();

    public Account findById(Integer id);

    public void saveOrUpdate();

    public int delete(Integer id);

}
