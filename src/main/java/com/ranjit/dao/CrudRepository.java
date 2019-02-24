package com.ranjit.dao;

import com.ranjit.model.Account;

import java.util.List;


public interface CrudRepository<T, K> {

    public List<T> findAll();

    public T findById(K id);

    public void saveOrUpdate();

    public int delete(K id);

}
