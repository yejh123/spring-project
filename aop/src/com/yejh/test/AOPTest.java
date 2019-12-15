package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_16 11:02
 */

import com.yejh.impl.MyMathCalculator;
import com.yejh.inter.Calculator;
import com.yejh.proxy.CalculatorProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: TODO
 * 通知方法执行顺序
 * try{
 * @Before
 * method.invoke(obj, args);
 * @AfterReturning
 * }catch(){
 * @AfterThrowing
 * }finnaly{
 * @After
 * }
 *
 * 正常执行：@Before（前置通知）---->@After---->@AfterReturning
 * 异常执行：@Before---->@After---->@AfterThrowing
 **/
public class AOPTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

//    @Test
//    public void test1(){
//        Calculator calculator = new MyMathCalculator();
//        Calculator proxy = CalculatorProxy.getProxy(calculator);
//        System.out.println(proxy + " , " + proxy.getClass());
//        proxy.add(2, 5);
//        proxy.div(5, 0);
//    }

    @Test
    public void test2(){
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1, 2);
        System.out.println(calculator.getClass());
    }

    @Test
    public void test3(){
        //如果MyMathCalculator没有实现接口，则代理类是自身的内部类
        MyMathCalculator calculator = ioc.getBean(MyMathCalculator.class);
        //        MyMathCalculator calculator = (MyMathCalculator)ioc.getBean("myMathCalculator");
        System.out.println(calculator.getClass());
        //class com.yejh.impl.MyMathCalculator$$EnhancerBySpringCGLIB$$272f05b5

        calculator.add(2, 5);
        calculator.div(5, 0);
        calculator.add((8), 6);
    }
}
