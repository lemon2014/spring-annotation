package org.lemon.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 前置通知 @Before
 * 后置通知 @After
 * 返回通知 @AfterReturning
 * 异常通知 @AfterThrowing
 * 环绕通知 @Around
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public int org.lemon.spring.config.MyMethod.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] params = joinPoint.getArgs();
        System.out.println("方法" + joinPoint.getSignature().getName() + "运行参数是:" + Arrays.asList(params));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("方法" + joinPoint.getSignature().getName() + "执行结束:");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("方法" + joinPoint.getSignature().getName() + "的返回值是:" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("方法" + joinPoint.getSignature().getName() + "的异常是:" + exception);
    }
}
