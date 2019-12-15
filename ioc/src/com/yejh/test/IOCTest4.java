package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_15 20:56
 */

import com.yejh.dao.BookDao;
import com.yejh.factory.BookStaticFactory;
import com.yejh.service.BookService;
import com.yejh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description: TODO
 * Spring的单元测试
 * 1、导入spring-test包
 * 2、@ContextConfiguration(locations = "classpath:？？？")来指定Spring的配置文件的位置
 * 3、@RunWith指定用哪种驱动来进行单元测试，默认就是junit
 * @RunWith(SpringJUnit4ClassRunner.class)
 **/

@ContextConfiguration(locations = "classpath:ioc4.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest4 {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookStaticFactory bookStaticFactory;

    @Test
    public void test1() {
        System.out.println(bookStaticFactory);
    }

    @Test
    public void test2() {
        bookService.save();
        userService.save();
    }
}
