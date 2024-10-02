package com.liza.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyPointcutEx {

    @Pointcut("execution(* com.liza.aop.dao.test*.*(..))")
    // public можно упростить,
    // void (int и т.д.) можно заменить на звездочку, что сделает запись универсальной, т
    // акже можно сократить название самого метода, оставив только общую часть, а все остальное заменить на звездочку
    public void pointcutForMethods() {
    }

    @Pointcut("execution(* com.liza.aop.dao.test*.get*(..))")
    public void pointcutForGetter() {
    }

    @Pointcut("execution(* com.liza.aop.dao.test*.set*(..))")
    public void pointcutForSetter() {
    }

    @Pointcut("pointcutForSetter() || pointcutForGetter()")
    public void pointcutForSetterAndGetter() {
    }

    @Pointcut("pointcutForMethods() && !(pointcutForSetter() || pointcutForGetter())")
    public void pointcutNotForSetterAndGetter() {
    }
}
