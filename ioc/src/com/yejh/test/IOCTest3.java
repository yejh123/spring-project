package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_15 19:42
 */

import com.yejh.bean.Book;
import com.yejh.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description: TODO
 **/

public class IOCTest3 {

    ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");

    @Test
    public void test4(){
        Book book1 = (Book) ioc3.getBean("book1");
        System.out.println(book1);
    }

    @Test
    public void test5(){
        Object person01 = ioc3.getBean("person01");
        System.out.println(person01);
    }

    @Test
    public void test6(){
        Object bookStaticFactory = ioc3.getBean("bookStaticFactory");
        System.out.println(bookStaticFactory);

        Object book = ioc3.getBean("book");
        System.out.println(book);
    }

    @Test
    public void test7(){
        BookService bookService = (BookService) ioc3.getBean("bookService");
        bookService.addBook();
    }
}
