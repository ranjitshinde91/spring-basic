package com.ranjit.dao;

import com.ranjit.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCrudRepository implements CrudRepository<Account, Integer> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCrudRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Account> findAll(){
        return  jdbcTemplate.query("select * from account", new AccoutMapper());
    }

    @Override
    public Account findById(Integer id) {
        String sqlText = "select * from account where id = ?";
        return jdbcTemplate.queryForObject(sqlText, new Object[] { id }, new AccoutMapper());
    }

    @Override
    public void saveOrUpdate() {

    }

    @Override
    public int delete(Integer id) {
        String sqlText = "delete from account where id = ?";
        return jdbcTemplate.update(sqlText, id);
    }

    private class AccoutMapper implements RowMapper<Account>{

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setBalance(resultSet.getBigDecimal("balance"));
            return account;
        }
    }

}
