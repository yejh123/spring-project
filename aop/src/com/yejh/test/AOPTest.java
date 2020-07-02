package com.yejh.test;/**
 * @author yejh
 * @create 2019-11_16 11:02
 */

import com.yejh.impl.MyMathCalculator;
import com.yejh.impl.MyMathCalculator2;
import com.yejh.inter.Calculator;
import com.yejh.proxy.CalculatorProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * @description: TODO
 * 通知方法执行顺序
 * try{
 * @Before method.invoke(obj, args);
 * @AfterReturning }catch(){
 * @AfterThrowing }finnaly{
 * @After }
 * <p>
 * 正常执行：@Before（前置通知）---->@After---->@AfterReturning
 * 异常执行：@Before---->@After---->@AfterThrowing
 *
 * 如果目标对象的实现类实现了接口，Spring AOP 将会采用 JDK 动态代理来生成 AOP 代理类；
 * 如果目标对象的实现类没有实现接口，Spring AOP 将会采用 CGLIB 来生成 AOP 代理类——
 * 不过这个选择过程对开发者完全透明、开发者也无需关心。
 *
 **/
public class AOPTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1() {
        Calculator calculator = new MyMathCalculator();
        Calculator proxy = CalculatorProxy.getProxy(calculator);
        System.out.println(proxy + " , " + proxy.getClass());
        System.out.println(proxy instanceof Proxy); //true，表明proxy是一个继承proxy类的MyMathCalculator的匿名内部类
        proxy.add(2, 5);
        proxy.div(5, 0);
    }

    @Test
    public void test2() {
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1, 2);
        System.out.println(calculator.getClass());
        System.out.println(calculator);//com.yejh.impl.MyMathCalculator@5fbe4146
    }

    @Test
    public void test3() {
        //如果MyMathCalculator没有实现接口，则代理类是自身的内部类
        //MyMathCalculator calculator = ioc.getBean(MyMathCalculator.class);
        MyMathCalculator2 calculator = (MyMathCalculator2) ioc.getBean("myMathCalculator2");
        System.out.println(calculator.getClass());
        //class com.yejh.impl.MyMathCalculator2$$EnhancerBySpringCGLIB$$4c724736

        calculator.add(2, 5);
        //calculator.div(5, 0);
        calculator.add(8, 6);
    }
}
