package com.lihegang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by dong-er on 2019-08-12.
 */
@Aspect
@Component
public class LogAspects {

    // 1. 本类引用
    // 2.其他的切面引用
    @Pointcut("execution(* com.lihegang.aop..*.*(..))")
    public void pointCut() {
    }

    ;

    //切入表达式
    //   @Before("public int com.lihegang.aop.*.*(..)")
    @Before("pointCut()")
    public void logStart(JoinPoint point) {
        Object[] args = point.getArgs();
        System.out.println("" + point.getSignature().getName() + "运行...@Before参数列表是{}" +args);
    }

    @After("pointCut()")
    public void logEnd(JoinPoint point) {
        System.out.println("" + point.getSignature().getName() + "结束...@After");
    }

    // 接收返回值,joinPoint必须在第一位，否则无法识别
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result) {
        System.out.println("除法正常返回...@AfterReturning运行结果：{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "异常...@AfterThrowing异常信息：{}" + exception);
    }
}
