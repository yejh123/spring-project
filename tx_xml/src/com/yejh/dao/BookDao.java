package com.yejh.dao;/**
 * @author yejh
 * @create 2019-11_18 17:11
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @description: TODO
 *
 **/
@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void updateBalance(String userName, int price){
        String sql = "update account set balance =balance-? where username=?";
        jdbcTemplate.update(sql, price, userName);
    }

    public int getPrice(String isbn){
        String sql = "select price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);

    }

    public void updateStock(String isbn){
        String sql = "update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql, isbn);
    }

    public void setPrice(String isbn, int price){
        String sql = "update book set price=? where isbn=?";
        jdbcTemplate.update(sql, price, isbn);
    }
}
