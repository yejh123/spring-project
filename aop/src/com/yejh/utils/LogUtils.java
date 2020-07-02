package com.yejh.utils;/**
 * @author yejh
 * @create 2019-11_16 11:35
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description: TODO
 * 切面类
 * <p>
 * 通配符
 * *
 * （1）匹配一个或多个字符
 * execution(public int com.yejh.impl.MyMath*r.*(int, int))
 * （2）匹配任意一个参数
 * *      execution(public int com.yejh.impl.MyMath*r.*(int, *))
 * （3）匹配一层路径
 * （4）权限位置不能用*，不写即可
 * <p>
 * ..
 * （1）匹配任意多个参数
 * execution(public int com.yejh.impl.MyMath*r.*(..))
 * （2）匹配任意多层路径
 * execution(public int com..MyMath*r.*(..))
 * <p>
 * 最精确的：execution(public int com.yejh.impl.MyMathCalculator.add(int,int))
 * <p>
 * 最模糊的：execution(* *.*(..)) 千万别写
 * <p>
 * &&：切入的位置满足两个表达式
 * execution(public int com.yejh..MyMath*.*(..))&&execution(* *.*(int,int))
 * <p>
 * !：只要不是这个位置的都切入
 * <p>
 * ||：切入的位置满足两个表达式其中一个
 * <p>
 * 抽取可重用的切入点表达式
 * <p>
 * <p>
 * 环绕通知：优先于普通通知执行
 * [普通前置]
 * {
 *     try{
 *         环绕前置
 *         目标方法执行
 *         环绕返回
 *     }catch(){
 *         环绕出现异常
 *     }
 *     finally{
 *         环绕后置
 *     }
 * }
 * [普通后置]
 * [普通方法返回/方法异常]
 *
 * 环绕前置---->普通前置---->目标方法执行---->环绕正常返回/出现异常---->环绕后置---->普通后置---->普通返回/出现异常
 **/

@Component
@Aspect
public class LogUtils {

    @Pointcut("execution(* com.yejh.impl.MyMathCalculator.*(..))")
    public void myPoint() {}

    @Pointcut("execution(* com.yejh.impl.MyMathCalculator2.*(..))")
    public void myPoint2(){}

    @Around(value = "myPoint2()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws RuntimeException {
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("【" + proceedingJoinPoint.getSignature() + "】方法开始执行，args【" + Arrays.toString(args) + "】");
            result = proceedingJoinPoint.proceed(args);
            System.out.println("【" + proceedingJoinPoint.getSignature() + "】方法开始完毕，res=" + result);
        } catch (Throwable throwable) {
            System.out.println("【" + proceedingJoinPoint.getSignature() + "】方法出现异常，异常信息：" + throwable);
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("【" + proceedingJoinPoint.getSignature() + "】方法结束");
        }
        return result;
    }

    //在执行目标方法之前运行，写入切入点表达式
    //execution(方法签名）
//    @Before("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")               //前置通知
//    public static void logStart(Method method, Object...args){
//        System.out.println("【" + method.getName() + "】方法开始执行，args【" + Arrays.toString(args) + "】");
//    }
//
//    //在目标方法正常执行完成之后执行
//    @AfterReturning("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")     //返回通知
//    public static void logReturn(Method method, Object res){
//        System.out.println("【" + method.getName() + "】方法开始完毕，res=" + res);
//    }
//
//    //在目标方法出现异常时执行
//    @AfterThrowing("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")          //
//    public static void logException(Method method, Exception e){
//        System.out.println("【" + method.getName() + "】方法出现异常，异常信息：" + e.getCause());
//    }
//
//    //在目标方法执行结束之后执行
//    @After("execution(public int com.yejh.impl.MyMathCalculator.*(int, int))")                //后置通知
//    public static void logEnd(Method method){
//        System.out.println("【" + method.getName() + "】方法结束");
//    }

    //在执行目标方法之前运行，写入切入点表达式
    //execution(方法签名）
    /* JoinPoint：封装了当前目标方法的详细信息

     */
    @Before("myPoint()")               //前置通知
    public static void logStart(JoinPoint joinPoint){
        //获取目标方法运行时参数
        Object[] args = joinPoint.getArgs();

        //获取目标方法签名
        Signature signature = joinPoint.getSignature();
//        System.out.println(signature.getName());        //add
//        System.out.println(signature.getDeclaringType());       //class com.yejh.impl.MyMathCalculator
//        System.out.println(signature.getDeclaringTypeName());   //com.yejh.impl.MyMathCalculator
//        System.out.println(signature.getModifiers());           //1
//        System.out.println(signature.getClass());               //class org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$MethodSignatureImpl

//        System.out.println(joinPoint.getKind());        //method-execution
//        System.out.println(joinPoint.getSourceLocation());      //org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$SourceLocationImpl@696da30b
//        System.out.println(joinPoint.getStaticPart());      //execution(int com.yejh.impl.MyMathCalculator.add(int,int))
//        System.out.println(joinPoint.getTarget());      //com.yejh.impl.MyMathCalculator@4e7912d8
//        System.out.println(joinPoint.getThis());        //com.yejh.impl.MyMathCalculator@4e7912d8
//        System.out.println(joinPoint.getClass());       //class org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
        System.out.println("【" + signature+  "】方法开始执行，args【" + "】");
    }

    //在目标方法正常执行完成之后执行
    //告诉spring哪个参数用来接收返回值
    //joinPoint必须是参数的第一位
    @AfterReturning(value = "myPoint()", returning = "result")     //返回通知
    public static void logReturn(JoinPoint joinPoint, Object result){
        System.out.println("【" + joinPoint.getSignature() + "】方法开始完毕，res=" + result);
    }

    //在目标方法出现异常时执行
    @AfterThrowing(value = "myPoint()", throwing = "e")          //
    public static void logException(JoinPoint joinPoint, Exception e){

        System.out.println("【" + joinPoint.getSignature() + "】方法出现异常，异常信息：" +e );
    }

    //在目标方法执行结束之后执行
    @After("myPoint()")                //后置通知
    public static void logEnd(JoinPoint joinPoint){
        System.out.println("【" + joinPoint.getSignature() + "】方法结束");
    }
}
