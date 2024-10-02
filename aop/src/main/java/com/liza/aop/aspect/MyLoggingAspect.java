package com.liza.aop.aspect;

import com.liza.aop.Admin;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Aspect
@Order(1)
public class MyLoggingAspect {

    @Around("execution(* getCr*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("    Around: " + pjp.getSignature().getName());
        long startTime = System.currentTimeMillis();

        Object x = null;
        try{
            x = pjp.proceed();
        } catch (Throwable e) {
            System.out.println("    " + e.getMessage());
            x = " Exception. Credit was NOT APPROVED.";
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("    Around duration: " + duration);
        return x;
    }

    @After("execution(* find*(..))")
    public void afterAdvice (JoinPoint jp) {
        System.out.println("    After: " + jp.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* find*(..))", throwing = "e")
    public void afterThrowing(JoinPoint jp, Throwable e) {
        System.out.println("    After throwing: " + jp.getSignature().getName());
        System.out.println("    After throwing exception: " + e.getMessage());
    }

    @AfterReturning(pointcut = "execution(* find*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, List<Admin> result) {
        System.out.println("    method name: " + joinPoint.getSignature().getName());
        System.out.println("    result: " + result);

        changeResult(result);
    }

    private void changeResult(List<Admin> result) {
        for (Admin admin : result) {
            admin.setName(admin.getName().toUpperCase());
            if (admin.getName().equals("GOSHA")) {
                admin.setName("ANNA");
            }
        }
    }

    @Before("MyPointcutEx.pointcutForMethods()")
    public void beforeAddUserData(JoinPoint joinPoint) {
        System.out.println("    1 Before addUserData");
        MethodSignature mt = (MethodSignature) joinPoint.getSignature();
        System.out.println("        Method:" + mt.getMethod().getName());

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("        Arguments:" + arg.toString());
        }
    }

}
