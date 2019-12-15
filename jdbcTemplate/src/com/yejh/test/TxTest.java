package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_17 20:08
 */

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 **/
public class TxTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1() throws SQLException {
        DataSource dataSource = ioc.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
connection.close();

    }

    @Test
    public void test2() {
        JdbcTemplate iocBean = ioc.getBean(JdbcTemplate.class);
        System.out.println(iocBean);

    }

    @Test
    public void test3() {
        JdbcTemplate iocBean = ioc.getBean(JdbcTemplate.class);
        System.out.println(iocBean);

        String sql = "update employee set salary=? where emp_id=?";
        int update = iocBean.update(sql, 1300, 5);
        System.out.println(update);
    }

    /*
        回顾书城的批量插入：QueryRunner

     */
    @Test
    public void test4() {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "insert into employee(emp_name, salary) values(?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"sbchang1", 9999.99});
        batchArgs.add(new Object[]{"sbchang2", 19999.99});
        batchArgs.add(new Object[]{"sbchang3", 29999.99});

        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));

    }

    //RowMapper
    @Test
    public void test5() {
        JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
        String sql = "select ";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"sbchang1", 9999.99});
        batchArgs.add(new Object[]{"sbchang2", 19999.99});
        batchArgs.add(new Object[]{"sbchang3", 29999.99});

        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));

    }

}
