package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_18 17:21
 */

import com.yejh.service.BookService;
import com.yejh.service.MultiService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: TODO
 * 有事务的业务逻辑，容器中保存的是这个业务逻辑的代理对象
 **/
public class TxTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");

    @Test
    public void test1() {
        BookService bookService = ioc.getBean(BookService.class);
        bookService.checkout("Tom", "ISBN-001");
    }

    @Test
    public void test2() {
        BookService bookService = ioc.getBean(BookService.class);
        System.out.println(bookService.getClass());
        //class com.yejh.service.BookService$$EnhancerBySpringCGLIB$$617e4a09
    }

    @Test
    public void test3() {
        MultiService multiService = ioc.getBean(MultiService.class);
        multiService.txTest();
    }
}
