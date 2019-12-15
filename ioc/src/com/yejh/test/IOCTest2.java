package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_13 15:16
 */

import com.yejh.bean.Book;
import com.yejh.bean.Person;
import com.yejh.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: TODO
 **/
public class IOCTest2 {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

    @Test
    public void test1(){
        //ApplicationContext代表ioc容器
        //当前应用的xml配置文件在ClassPath下
        Person person02 = (Person) ioc.getBean("person02");
        System.out.println(person02);

    }

    @Test
    public void test2(){
        //如果尝试获取一个abstract为true的bean，则会报错
        //org.springframework.beans.factory.BeanIsAbstractException: Error creating bean with name 'person03': Bean definition is abstract
        //Person person03 = (Person) ioc.getBean("person03");
        //System.out.println(person03);

    }

    @Test
    public void test3(){
        Person person1 = (Person) ioc.getBean("person04");
        Person person2 = (Person) ioc.getBean("person04");
        System.out.println(person1 == person2);

        Person person3 = (Person) ioc.getBean("person05");
        Person person4 = (Person) ioc.getBean("person05");
        System.out.println(person3 == person4);
    }

}
