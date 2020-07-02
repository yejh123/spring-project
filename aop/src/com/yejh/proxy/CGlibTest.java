package com.yejh.proxy;/**
 * @author yejh
 * @create 2020-03_24 20:24
 */

import com.yejh.impl.MyMathCalculator;
import com.yejh.impl.MyMathCalculator2;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: TODO
 **/
public class CGlibTest implements MethodInterceptor {
    private Object proxy;

    public Object getInstance(Object proxy) {
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }
    //回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>>before invoking");
        //真正调用
        Object ret = methodProxy.invokeSuper(o, objects);
        System.out.println(">>>>after invoking");
        return ret;
    }

    public static void main(String[] args) {
        CGlibTest cGlibTest = new CGlibTest();
        MyMathCalculator2 calculator = (MyMathCalculator2) cGlibTest.getInstance(new MyMathCalculator2());
        int i = calculator.add(2, 5);
        System.out.println(i);
    }
}
