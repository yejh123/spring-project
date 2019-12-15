package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_15 14:15
 */

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @description: TODO
 **/
public class C3P0Test {
    private ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("c3p0.xml");

    @Test
    public void test() throws SQLException {
        //DataSource dataSource = (DataSource) ioc.getBean("dataSource");

        DataSource bean = ioc.getBean(DataSource.class);
        System.out.println(bean.getConnection());

    }

}
