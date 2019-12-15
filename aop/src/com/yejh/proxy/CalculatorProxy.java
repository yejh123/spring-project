package com.yejh.proxy;/**
 * @author yejh
 * @create 2019-11_16 10:52
 */

import com.yejh.inter.Calculator;
import com.yejh.utils.LogUtils;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @description: TODO
 * 帮Calculator生成代理对象的类
 *
 * ※※※如果目标对象没有实现任何接口，则无法创建任何代理
 * ※※※代理对象和被代理对象唯一能产生的关联就是实现了相同的接口
 **/
public class CalculatorProxy {
//    public static Calculator getProxy(final Calculator calculator) {
//        ClassLoader loader = calculator.getClass().getClassLoader();
//        Class<?>[] interfaces = calculator.getClass().getInterfaces();
//        //方法执行器
//        InvocationHandler h = new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object res = null;
//                try {
//                    LogUtils.logStart(method, args);
//                    //proxy：代理对象，给jdk使用
//                    res = method.invoke(calculator, args);
//                    //返回值要返回，外界才能拿到
//                    LogUtils.logReturn(method, res);
//                } catch (Exception e) {
//                    LogUtils.logException(method, e);
//                } finally {
//                    LogUtils.logEnd(method);
//                }
//
//
//                return res;
//            }
//        };
//        //proxy为目标对象创建代理对象
//        Calculator proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);
//        return proxy;
//
//    }
}
