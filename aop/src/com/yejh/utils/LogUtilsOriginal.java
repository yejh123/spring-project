package com.yejh.utils;/**
 * @author yejh
 * @create 2020-03_24 19:59
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: TODO
 **/
public class LogUtilsOriginal {

    //@Pointcut("execution(* com.yejh.impl.MyMathCalculator.*(..))")
    public void myPoint() {
    }


    //在执行目标方法之前运行，写入切入点表达式
    //execution(方法签名）
    //@Before("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")               //前置通知
    public static void logStart(Method method, Object... args) {
        System.out.println("【" + method.getName() + "】方法开始执行，args【" + Arrays.toString(args) + "】");
    }

    //在目标方法正常执行完成之后执行
    //@AfterReturning("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")     //返回通知
    public static void logReturn(Method method, Object res) {
        System.out.println("【" + method.getName() + "】方法开始完毕，res=" + res);
    }

    //在目标方法出现异常时执行
    //@AfterThrowing("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")          //
    public static void logException(Method method, Exception e) {
        System.out.println("【" + method.getName() + "】方法出现异常，异常信息：" + e.getCause());
    }

    //在目标方法执行结束之后执行
    //@After("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")                //后置通知
    public static void logEnd(Method method) {
        System.out.println("【" + method.getName() + "】方法结束");
    }


}
