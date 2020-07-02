package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_03 17:32
 */

import com.yejh.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.Properties;

/**
 * @description: TODO
 * <p>
 * ioc是一个容器，帮我们管理所有的组件
 * 1、依赖注入：@Autowired：自动赋值
 * 2、某个组件要使用Spring提供的更多（IOC、AOP）必须先加入到容器中
 * 体会
 * 1、容器启动，创建所有单实例bean
 * 2、autowired自动装配时，从容器中找到符合要求的bean
 * 3、ioc.getBean(String id)也是从容器中找到这个bean
 * 4、容器中包括了所有的bean
 * 5、调试spring的源码，容器到底是什么？其实就是一个map
 * 6、这个map中保存所有创建好的bean，并提供外界获取功能
 * 7、...
 **/
public class IOCTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

    @Test
    public void test0() {
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        System.out.println("beanDefinitionNames: ");
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test1() {
        //ApplicationContext代表ioc容器
        //当前应用的xml配置文件在ClassPath下
        Person person01 = (Person) ioc.getBean("person01");
        System.out.println(person01);

    }

    @Test
    public void test2() {
        Person person02 = ioc.getBean("person02", Person.class);
    }

    @Test
    public void test3() {
        Person person03 = ioc.getBean("person03", Person.class);
        System.out.println(person03);
    }

    @Test
    public void test5() {
        Person person05 = ioc.getBean("person05", Person.class);
        System.out.println(person05);
    }

    @Test
    public void test6() {
        Person person06 = ioc.getBean("person06", Person.class);
        System.out.println(person06);
    }

    @Test
    public void test8() {
        Person person08 = ioc.getBean("person08", Person.class);
        System.out.println(person08);
    }

    @Test
    public void test9() {
        Person person09 = ioc.getBean("person09", Person.class);
        System.out.println(person09);
    }

    @Test
    public void test10() {
        Person person10 = ioc.getBean("person10", Person.class);
        System.out.println(person10);
    }

    @Test
    public void test11() {
        Person person11 = ioc.getBean("person11", Person.class);
        System.out.println(person11);
        Properties properties = person11.getProperties();
        Collection<Object> values = properties.values();
        for (Object o : values) {
            System.out.println(o.getClass() + " " + o);
        }
    }
}
